package concurrent.thread.demo;

import java.util.concurrent.TimeUnit;

/**
 * Synchorized 不可被打断
 *
 * @author sunjianrong
 * @date 2021/8/8 下午1:45
 */
public class SynchronizeDefectDemo {

    public synchronized void syncMethod() {
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizeDefectDemo synchronizeDefectDemo = new SynchronizeDefectDemo();
        Thread t1 = new Thread(synchronizeDefectDemo::syncMethod, "T1");
//        t1.start();
//        t1.interrupt();
//        System.out.println("T1 isInterrupt " + t1.isInterrupted());
//        System.out.println("T1 state " + t1.getState());

        TimeUnit.MILLISECONDS.sleep(5);

        Thread t2 = new Thread(synchronizeDefectDemo::syncMethod, "T2");
        t2.start();
        t2.interrupt();
        System.out.println("T2 isInterrupt " + t2.isInterrupted());
        System.out.println("T2 state " + t2.getState());

    }
}
