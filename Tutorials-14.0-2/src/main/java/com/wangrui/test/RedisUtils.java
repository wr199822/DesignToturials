package com.wangrui.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RedisUtils {

    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    private AtomicInteger stock = new AtomicInteger(0);

    public RedisUtils() {
        //scheduleAtFixedRate 方法可以执行多次定时任务，此方法需要 4 个参数：
        //第 1 个参数：传递一个任务，Runnable 或 Callable 对象;
        //第 2 个参数：添加定时任务后，再过多久开始执行定时任务;
        //第 3 个参数：定时任务执行的时间间隔;
        //第 4 个参数：时间单位，配合参数 2 和参数 3 一起使用。
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            // 模拟库存消耗
            stock.addAndGet(1);
        }, 0, 100000, TimeUnit.MICROSECONDS);

    }

    public int getStockUsed() {
        return stock.get();
    }

}