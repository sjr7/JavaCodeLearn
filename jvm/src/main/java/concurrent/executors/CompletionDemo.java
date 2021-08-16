package concurrent.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author sunjianrong
 * @date 2021/8/15 上午9:05
 */
public class CompletionDemo {

    public static void main(String[] args) {

        begin("testCompletionServiceCallable");
        testCompletionServiceCallable();
        end("testCompletionServiceCallable");

        begin("testCompletionServiceRunable");
        testCompletionServiceRunable();
        end("testCompletionServiceRunable");
    }


    private static void testCompletionServiceRunable() {
        ExecutorService executorService = getExecutorService();
        CompletionService<AtomicLong> service = new ExecutorCompletionService<>(executorService);

        int execute = 5;

        for (int i = 0; i < execute; i++) {
            AtomicLong atomicLong = new AtomicLong();
            service.submit(()->{
                int nextInt = ThreadLocalRandom.current().nextInt(15);
                try {
                    TimeUnit.SECONDS.sleep(nextInt);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task:" + nextInt + " completed in thread " + Thread.currentThread().getName());
                atomicLong.set(nextInt);

            },atomicLong);
        }


        for (int i = 0; i < execute; i++) {
            try {
                System.out.println(service.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }

    private static void testCompletionServiceCallable() {
        ExecutorService executorService = getExecutorService();
        CompletionService<Integer> service = new ExecutorCompletionService<>(executorService);

        List<Callable<Integer>> list = Arrays.asList(
                () -> {
                    int nextInt = 5;
                    TimeUnit.SECONDS.sleep(nextInt);
                    System.out.println("Task:" + nextInt + " completed in thread " + Thread.currentThread().getName());
                    return nextInt;
                },
                () -> {
                    int nextInt = 8;
                    TimeUnit.SECONDS.sleep(nextInt);
                    System.out.println("Task:" + nextInt + " completed in thread " + Thread.currentThread().getName());
                    return nextInt;
                },
                () -> {
                    int nextInt = 13;
                    TimeUnit.SECONDS.sleep(nextInt);
                    System.out.println("Task:" + nextInt + " completed in thread " + Thread.currentThread().getName());
                    return nextInt;
                }
        );

        list.forEach(service::submit);


        for (int i = 0; i < list.size(); i++) {
            try {
                System.out.println(service.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }

    private static void begin(String testName) {
        System.out.println("=================开始测试 【" + testName + "】=============");
    }


    private static void end(String testName) {
        System.out.println("=================结束测试 【" + testName + "】=============");
        System.out.println();
        System.out.println();
    }

    private static ExecutorService getExecutorService() {
        return Executors.newFixedThreadPool(10);
    }
}
