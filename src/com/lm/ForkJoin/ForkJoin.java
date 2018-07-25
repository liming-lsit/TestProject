package com.lm.ForkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * describe:
 * ForkJoinTask : RecursiveAction RecursiveTask
 * ForkJoinPool :
 *
 * @author lm
 * @date 2018/7/18
 */
public class ForkJoin extends RecursiveTask<Integer> {
    private int end;
    private int start;

    public ForkJoin( int start,int end) {
        this.end = end;
        this.start = start;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool =new ForkJoinPool();
        Future<Integer> future =pool.submit(new ForkJoin(1,10000));
        System.out.println("ForkJoin.main");
        System.out.println("ForkJoin.main :"+future.get());
    }

    @Override
    protected Integer compute() {
        System.out.println(Thread.currentThread().getName()+"...");
        int sum = 0;
        if(end-start <=2){
                for (int i=start;i<end;i++){
                    sum +=i;
                }
        }else{
            ForkJoin ForkJoin1 = new ForkJoin(start,(start + end)/2);
            ForkJoin ForkJoin2 = new ForkJoin((start + end)/2+1,end);
            ForkJoin1.fork();
            ForkJoin2.fork();
            Integer a = ForkJoin1.join();
            Integer b = ForkJoin2.join();
            sum = a+b;
        }
        return sum;
    }
}
