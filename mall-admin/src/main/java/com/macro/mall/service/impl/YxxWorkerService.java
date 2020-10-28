package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.utils.GeneratorUtil;
import com.macro.mall.dto.YxxWorkerBody;
import com.macro.mall.example.YxxWorkerExample;
import com.macro.mall.mapper.YxxWorkerMapper;
import com.macro.mall.model.YxxWorker;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Paradise
 */
@Service
public class YxxWorkerService {
    private final YxxWorkerMapper yxxWorkerMapper;
    private final PasswordEncoder passwordEncoder;

    public YxxWorkerService(YxxWorkerMapper yxxWorkerMapper, PasswordEncoder passwordEncoder) {
        this.yxxWorkerMapper = yxxWorkerMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public List<YxxWorker> page(String keywords, Integer pageNum, Integer pageSize) {
        YxxWorkerExample yxxMemberExample = new YxxWorkerExample();
        YxxWorkerExample.Criteria criteria = yxxMemberExample.createCriteria();
        criteria.andEnableNotEqualTo(3);
        if (!StringUtils.isEmpty(keywords)) {
            criteria.andUsernameLike("%" + keywords + "%");
        }
        // TODO 需要查询上级名称
        PageHelper.startPage(pageNum, pageSize);
        return yxxWorkerMapper.selectByExample(yxxMemberExample);
    }

    public List<YxxWorker> listByParentId(Integer pageNum, Integer pageSize, Long parentId) {
        YxxWorkerExample yxxMemberExample = new YxxWorkerExample();
        YxxWorkerExample.Criteria criteria = yxxMemberExample.createCriteria();
        criteria.andEnableNotEqualTo(3);
        if (parentId != null) {
            criteria.andParentIdEqualTo(parentId);
        }
        PageHelper.startPage(pageNum, pageSize);
        return yxxWorkerMapper.selectByExample(yxxMemberExample);
    }

    public YxxWorker create(YxxWorkerBody worker) {
        YxxWorker yxxWorker = new YxxWorker();
        BeanUtils.copyProperties(worker, yxxWorker);
        yxxWorker.setCreateTime(new Date());
        yxxWorker.setPassword(passwordEncoder.encode(worker.getPassword()));
        yxxWorkerMapper.insert(yxxWorker);
        if (yxxWorker.getId() != null) {
            yxxWorker.setInvitationCode(GeneratorUtil.generatePromotionCode(yxxWorker.getId()));
            yxxWorkerMapper.updateByPrimaryKeySelective(yxxWorker, YxxWorker.Column.invitationCode);
        }
        return yxxWorker;
    }

    public int changeStatus(Long id, Integer enable) {
        YxxWorker worker = new YxxWorker();
        worker.setId(id);
        worker.setEnable(enable);
        return yxxWorkerMapper.updateByPrimaryKeySelective(worker);
    }

    public int del(Long id) {
        YxxWorker worker = new YxxWorker();
        worker.setId(id);
        worker.setEnable(3);
        return yxxWorkerMapper.updateByPrimaryKeySelective(worker);
    }

    public YxxWorker update(YxxWorkerBody yxxWorkerBody) {
        YxxWorker worker = new YxxWorker();
        BeanUtils.copyProperties(yxxWorkerBody, worker);
        yxxWorkerMapper.updateByPrimaryKeySelective(worker);
        return worker;
    }

    public List<Long> getAvailableWorkerList(Long orderId) {
        // 关联技能 查询
        List<YxxWorker> workers = yxxWorkerMapper.selectByExample(new YxxWorkerExample().createCriteria().andEnableEqualTo(1).example());
        // 查询策略权重规则 并计算得分 排序
        return workers.stream().sorted().map(YxxWorker::getId).collect(Collectors.toList());
    }

    /**
     * 重置 过期会员的会员等级
     *
     * @return 更新数量
     */
    public int resetWorkerLevel() {
        return yxxWorkerMapper.updateByExampleSelective(
                YxxWorker.builder().levelId(1).updateTime(new Date()).build(),
                new YxxWorkerExample().createCriteria().andLevelIdGreaterThan(1).andLevelExpireDateLessThan(new Date()).example(),
                YxxWorker.Column.updateTime, YxxWorker.Column.levelId);
    }

}
