package concurrent.thread.demo;

import java.util.concurrent.TimeUnit;

/**
 * @author sunjianrong
 * @date 2021/8/8 上午10:19
 */
public class SynchronizedDemo {

    public static void main(String[] args) {
        Mutex mutex = new Mutex();
        for (int i = 0; i < 5; i++) {
            new Thread(mutex::access).start();
        }
    }


    static class Mutex {
        private final static Object mutex = new Object();

        public void access() {
            synchronized (mutex) {
                try {
                    TimeUnit.MINUTES.sleep(19);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
