package concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * 测试 isInterrupt
 *
 * @author sunjianrong
 * @date 2021/8/8 上午9:38
 */
public class IsInterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            boolean stop = true;
            while (stop) {
                // cpu空转
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("接收到打断信号，退出处理");
                    stop = false;

                }
            }
        });

        thread.start();
        TimeUnit.MILLISECONDS.sleep(5);
        System.out.println("【前】线程是否被打断" + thread.isInterrupted());
        thread.interrupt();
        System.out.println("【后】线程是否被打断" + thread.isInterrupted());
    }
}
