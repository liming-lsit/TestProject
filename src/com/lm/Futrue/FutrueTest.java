package com.lm.Futrue;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * describe:
 *
 * @author lm
 * @date 2018/7/19
 */
public class FutrueTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

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

        System.out.println("FutrueTest.call 计算结果： "+task.get());
    }
}
