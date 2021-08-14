package concurrent.volatiledemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示 volatile 不保证原子性
 *
 * @author sunjianrong
 * @date 2021/8/11 下午10:09
 */
public class VolatileDemo {
    public static volatile int i = 0;

    public static void main(String[] args) {
        int thread = 10;
        int everyExecute = 1000;
        int exceptCount = thread * everyExecute;

        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int j = 0; j < 10; j++) {
            executorService.submit(() -> {
                for (int k = 0; k < 10000000; k++) {
                    i++;
                }
                System.out.println("线程 " + Thread.currentThread().getName() + "执行结束");
                countDownLatch.countDown();
            });
        }
        try {
            System.out.println("开始等待结束");
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("预期值" + exceptCount + ", 最后 i 的值" + i);

    }
}
