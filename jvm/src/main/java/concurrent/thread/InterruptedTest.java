package concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author sunjianrong
 * @date 2021/8/8 上午9:46
 */
public class InterruptedTest {

    public static void main(String[] args) {
        System.out.println("主线程是否被 interrupted " + Thread.interrupted());

        Thread.currentThread().interrupt();

        System.out.println("主线程是否被 interrupted " + Thread.currentThread().isInterrupted());

        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("捕获到中断信号");
        }
    }
}
