package concurrent.thread.demo;

import java.util.concurrent.TimeUnit;

/**
 * @author sunjianrong
 * @date 2021/8/9 下午10:19
 */
public class UncaughtExceptionHandlerDemo {

    public static void main(String[] args) {
        /*Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("全局线程异常回调 " + t.getName() + " 异常信息 " + e.getMessage());
            }
        });*/
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(1 / 0);
        }, "测试线程");

        Thread thread2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(1 / 0);
        }, "测试线程2");


        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("线程1异常回调 " + t.getName() + " 异常信息 " + e.getMessage());
            }
        });

        thread.start();
        thread2.start();


    }
}
