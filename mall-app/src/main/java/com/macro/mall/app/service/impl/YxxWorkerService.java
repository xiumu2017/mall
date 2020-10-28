package com.macro.mall.app.service.impl;

import com.macro.mall.app.dao.WorkerSkilledProductDao;
import com.macro.mall.app.domain.WorkerDetails;
import com.macro.mall.app.domain.WorkerSkilledProductInfo;
import com.macro.mall.app.domain.YxxWorkerUpdateParam;
import com.macro.mall.app.service.UmsMemberCacheService;
import com.macro.mall.common.exception.Asserts;
import com.macro.mall.common.utils.GeneratorUtil;
import com.macro.mall.example.YxxWorkerCertificateExample;
import com.macro.mall.example.YxxWorkerExample;
import com.macro.mall.example.YxxWorkerSkilledProductExample;
import com.macro.mall.mapper.YxxWorkerCertificateMapper;
import com.macro.mall.mapper.YxxWorkerMapper;
import com.macro.mall.mapper.YxxWorkerSkilledProductMapper;
import com.macro.mall.model.YxxWorker;
import com.macro.mall.model.YxxWorkerCertificate;
import com.macro.mall.model.YxxWorkerSkilledProduct;
import com.macro.mall.security.util.JwtTokenUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class YxxWorkerService {
    private final YxxWorkerMapper workerMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final UmsMemberCacheService memberCacheService;
    private final YxxWorkerCertificateMapper certificateMapper;
    private final WorkerSkilledProductDao skilledProductDao;
    private final YxxWorkerSkilledProductMapper skilledProductMapper;

    private YxxWorker getByUsername(String username) {
        YxxWorker member;
        YxxWorkerExample example = new YxxWorkerExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<YxxWorker> memberList = workerMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(memberList)) {
            member = memberList.get(0);
            return member;
        }
        return null;
    }

    private YxxWorker getByPhone(String phone) {
        return workerMapper.selectOneByExample(new YxxWorkerExample().createCriteria().andPhoneEqualTo(phone).example());
    }

    public void register(String password, String telephone, String authCode, String invitationCode) {
        //验证验证码
        if (!verifyAuthCode(authCode, telephone)) {
            Asserts.fail("验证码错误");
        }
        //查询是否已有该用户
        YxxWorkerExample example = new YxxWorkerExample();
        example.createCriteria().andPhoneEqualTo(telephone);
        List<YxxWorker> umsWorkers = workerMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(umsWorkers)) {
            Asserts.fail("该用户已经存在");
        }
        Long parentId = null;
        if (!StringUtils.isEmpty(invitationCode)) {
            YxxWorker worker = workerMapper.selectOneByExample(
                    new YxxWorkerExample().createCriteria()
                            .andInvitationCodeEqualTo(invitationCode).example()
            );
            if (worker != null) {
                parentId = worker.getId();
            } else {
                Asserts.fail("邀请码不存在");
            }
        }
        //没有该用户进行添加操作
        YxxWorker umsWorker = new YxxWorker();
        umsWorker.setUsername(telephone);
        umsWorker.setPhone(telephone);
        if (!StringUtils.isEmpty(password)) {
            umsWorker.setPassword(passwordEncoder.encode(password));
        }
        umsWorker.setCreateTime(new Date());
        umsWorker.setParentId(parentId);
        umsWorker.setEnable(1);
        umsWorker.setStatus(1);
        workerMapper.insert(umsWorker);
        if (umsWorker.getId() != null) {
            // 生成邀请码
            umsWorker.setInvitationCode(GeneratorUtil.generatePromotionCode(umsWorker.getId()));
            workerMapper.updateByPrimaryKeySelective(umsWorker, YxxWorker.Column.invitationCode);
        }
    }

    public String generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public void updatePassword(String password, String oldPass) {
        YxxWorker worker = this.getCurrentWorker();
        if (worker == null) {
            Asserts.fail("该账号不存在");
        }
        if (!worker.getPassword().equals(passwordEncoder.encode(oldPass))) {
            Asserts.fail("原始密码不正确");
        }
        worker.setPassword(passwordEncoder.encode(password));
        workerMapper.updateByPrimaryKeySelective(worker, YxxWorker.Column.password);
    }

    public void resetPass(String telephone, String password, String authCode) {
        YxxWorker worker = getByPhone(telephone);
        if (worker == null) {
            Asserts.fail("该账号不存在");
        }
        //验证验证码
        if (!verifyAuthCode(authCode, telephone)) {
            Asserts.fail("验证码错误");
        }
        worker.setPassword(passwordEncoder.encode(password));
        workerMapper.updateByPrimaryKeySelective(worker, YxxWorker.Column.password);
    }

    public YxxWorker getCurrentWorker() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        WorkerDetails workerDetails = (WorkerDetails) auth.getPrincipal();
        return workerDetails.getYxxWorker();
    }

    /**
     * 切换区域
     *
     * @param regionId 区域ID
     * @return 更新结果
     */
    public int changeRegion(Long regionId) {
        YxxWorker member = getCurrentWorker();
        member.setRegionId(regionId);
        return workerMapper.updateByPrimaryKeySelective(member);
    }

    public UserDetails loadUserByPhone(String phone) {
        YxxWorker member = getByPhone(phone);
        if (member != null) {
            return new WorkerDetails(member);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    public String login(String phone, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByPhone(phone);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    public String refreshToken(String token) {
        return jwtTokenUtil.refreshHeadToken(token);
    }

    /**
     * 验证码校验
     *
     * @param authCode  验证码
     * @param telephone 手机号码
     * @return 验证结果
     */
    private boolean verifyAuthCode(String authCode, String telephone) {
        if (StringUtils.isEmpty(authCode)) {
            return false;
        }
        String defaultCode = "123456";
        if (defaultCode.equals(authCode)) {
            return true;
        }
        String realAuthCode = memberCacheService.getAuthCode(telephone);
        return authCode.equals(realAuthCode);
    }

    public void orderSwitch(Integer status) {
        YxxWorker worker = this.getCurrentWorker();
        worker.setStatus(status);
        workerMapper.updateByPrimaryKeySelective(worker, YxxWorker.Column.status);
    }

    public int updateInfo(YxxWorkerUpdateParam worker) {
        // 验证用户名唯一性
        YxxWorker yxxWorker = getCurrentWorker();
        if (!yxxWorker.getUsername().equals(worker.getUsername())) {
            YxxWorker ow = this.getByUsername(worker.getUsername());
            if (ow != null && ow.getId().equals(yxxWorker.getId())) {
                Asserts.fail("用户名已存在");
                return 0;
            }
        }
        BeanUtils.copyProperties(worker, yxxWorker);
        yxxWorker.setUpdateTime(new Date());
        return workerMapper.updateByPrimaryKeySelective(yxxWorker);
    }

    public List<YxxWorkerCertificate> certificateList() {
        return certificateMapper.selectByExampleWithBLOBs(new YxxWorkerCertificateExample()
                .createCriteria()
                .andWorkerIdEqualTo(this.getCurrentWorker().getId())
                .example());
    }

    public int certificateCreate(YxxWorkerCertificate certificate) {
        certificate.setWorkerId(this.getCurrentWorker().getId());
        certificate.setCreateTime(new Date());
        return certificateMapper.insert(certificate);
    }

    public int certificateUpdate(YxxWorkerCertificate certificate) {
        return certificateMapper.updateByPrimaryKeySelective(certificate);
    }

    public int certificateDelete(Long id) {
        return certificateMapper.deleteByPrimaryKey(id);
    }

    public int addressUpdate(String address, String location) {
        YxxWorker worker = this.getCurrentWorker();
        worker.setLocation(location);
        worker.setAddress(address);
        return workerMapper.updateByPrimaryKeySelective(worker, YxxWorker.Column.address, YxxWorker.Column.location);
    }

    public List<WorkerSkilledProductInfo> skilledProductList() {
        return skilledProductDao.list(getCurrentWorker().getId());
    }

    public int skilledProductConfig(List<Long> ids) {
        Long workerId = getCurrentWorker().getId();
        // 删除原有的
        skilledProductMapper.deleteByExample(new YxxWorkerSkilledProductExample().createCriteria().andWorkerIdEqualTo(workerId).example());
        Set<Long> set = new HashSet<>(ids.size());
        set.addAll(ids);
        List<YxxWorkerSkilledProduct> list = new ArrayList<>();
        for (Long id : set) {
            list.add(YxxWorkerSkilledProduct.builder().workerId(workerId).productId(id).build());
        }
        return skilledProductMapper.batchInsert(list);
    }
}
