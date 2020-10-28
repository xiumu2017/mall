package com.macro.mall.schedule;

import com.macro.mall.example.YxxWorkerOrderCountExample;
import com.macro.mall.mapper.YxxWorkerOrderCountMapper;
import com.macro.mall.model.YxxWorkerOrderCount;
import com.macro.mall.service.impl.YxxWorkerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Paradise
 */
@Slf4j
@Component
public class SchedulerJob {

    private final YxxWorkerOrderCountMapper workerOrderCountMapper;
    private final YxxWorkerService workerService;

    public SchedulerJob(YxxWorkerOrderCountMapper workerOrderCountMapper, YxxWorkerService workerService) {
        this.workerOrderCountMapper = workerOrderCountMapper;
        this.workerService = workerService;
    }

    @Scheduled(cron = "1 0 0 1/1 * *")
    public void resetWorkerOrderCount() {
        log.info("每日零点：开始重置会员订单数量");
        workerOrderCountMapper.updateByExampleSelective(
                YxxWorkerOrderCount.builder().assignAmount(0).distributeAmount(0).rushAmount(0).build(),
                new YxxWorkerOrderCountExample(),
                YxxWorkerOrderCount.Column.excludes(YxxWorkerOrderCount.Column.workerId)
        );
    }

    @Scheduled(cron = "0 0 0 1/1 * *")
    public void resetWorkerLevel() {
        log.info("每日零点：开始重置会员等级");
        int count = workerService.resetWorkerLevel();
        log.info("重置完成：更新数量：{}", count);
    }
}
