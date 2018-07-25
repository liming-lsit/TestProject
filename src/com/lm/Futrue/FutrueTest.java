package com.lm.Futrue;

import java.util.concurrent.*;

/**
 * describe:
 *
 * Callable 和 runable 的区别
 *
 * Runable 是run方法被线程调用的,在run 方法是异步执行的
 *
 * Callable的call方法 ，不是异步执行的，是由Future的run 方法调动的
 *
 *
 *
 *
 * @author lm
 * @date 2018/7/19
 */
public class FutrueTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        Callable<Integer> callable = new Callable<Integer>(){
            @Override
            public Integer call() throws Exception {
                System.out.println("FutrueTest.call 正在计算");
                Thread.sleep(4000);
                return 1;
            }
        };
        // FutureTask 实现 RunnableFuture<V> extends Runnable, Future<V>
        FutureTask<Integer> task = new FutureTask<Integer>(callable);

        Thread thread = new Thread(task);

        thread.start();

        System.out.println("FutrueTest.call do something ");
        task.get(2, TimeUnit.SECONDS);

        System.out.println("FutrueTest.call 计算结果： "+task.get());
    }
}
