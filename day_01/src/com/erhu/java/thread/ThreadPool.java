package com.erhu.java.thread;

import java.util.concurrent.*;

class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <=100; i++) {
           if (i % 2 == 0){
               System.out.println(Thread.currentThread().getName()+":"+i);
           }
        }
    }
}

class NumberCallable implements Callable<Integer>{
    private int sum = 0;
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i <100; i++) {
           if (i % 2 != 0){
               System.out.println(Thread.currentThread().getName()+"---->"+i);
               sum+=i;
           }
        }
        return sum;
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //ThreadPoolExecutor service = (ThreadPoolExecutor) executorService;
        //service.setCorePoolSize(3);
        //适用于Runnable
        executorService.execute(new NumberThread());
        //适用于callable
        NumberCallable numberCallable = new NumberCallable();
        Future future = executorService.submit(numberCallable);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
       /* List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        list.add(executorService.submit(numberCallable));
        for (Future<Integer> f :list) {
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }*/
        executorService.shutdown();
    }
}
