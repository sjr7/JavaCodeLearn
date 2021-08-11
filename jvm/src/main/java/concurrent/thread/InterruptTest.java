package concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * 测试 interrupt 打断线程
 *
 * @author sunjianrong
 * @date 2021/8/8 上午9:34
 */
public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("线程被打断");
            }
        });

        thread.start();

        TimeUnit.MILLISECONDS.sleep(5);
        System.out.println("开始打断线程");
        thread.interrupt();
    }
}
