package concurrent.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author sunjianrong
 * @date 2021/8/15 上午8:44
 */
public class ExecutorsDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        begin("invokeAny");
        testInvokeAny();
        end("invokeAny");


        begin("invokeAll");
        testInvokeAll();
        end("invokeAll");

    }

    private static void begin(String testName) {
        System.out.println("=================开始测试 【" + testName + "】=============");
    }


    private static void end(String testName) {
        System.out.println("=================结束测试 【" + testName + "】=============");
        System.out.println();
        System.out.println();
    }


    private static void testInvokeAll() {
        ExecutorService executorService = getExecutorService();

        List<Callable<Integer>> list = getCallables();

        // 批量执行任务,获取所有异步任务的 future 集合
        List<Future<Integer>> futureList = new ArrayList<>();
        try {
            futureList = executorService.invokeAll(list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        futureList.forEach(f -> {
            try {
                System.out.println("First result: " + f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdownNow();
    }


    private static void testInvokeAny() {
        ExecutorService executorService = getExecutorService();

        List<Callable<Integer>> list = getCallables();

        // 批量执行任务,只关心第一个返回值结果
        Integer invokeAny = null;
        try {
            invokeAny = executorService.invokeAny(list);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("First result: " + invokeAny);
        executorService.shutdownNow();
    }


    private static ExecutorService getExecutorService() {
        return Executors.newFixedThreadPool(10);
    }


    private static List<Callable<Integer>> getCallables() {
        List<Callable<Integer>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(
                    () -> {
                        int nextInt = ThreadLocalRandom.current().nextInt(5);
                        TimeUnit.SECONDS.sleep(nextInt);
                        System.out.println("Task:" + nextInt + " completed in thread " + Thread.currentThread().getName());
                        return nextInt;
                    }
            );
        }
        return list;
    }


}
