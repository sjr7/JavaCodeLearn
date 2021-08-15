package concurrent.lock;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author sunjianrong
 * @date 2021/8/14 下午4:49
 */
public class ConditionDemo {

    private static final Lock LOCK = new ReentrantLock();

//    public static final Condition CONDITION = LOCK.newCondition();

    public static final Condition FULL_CONDITION = LOCK.newCondition();

    public static final Condition EMPTY_CONDITION = LOCK.newCondition();


    public static final LinkedList<Integer> LIST = new LinkedList<>();

    public static final int CAPACITY = 100;

    public static int TOTAL = 0;


    public static void produce() {
        LOCK.lock();
        try {
            while (LIST.size() >= CAPACITY) {
//                CONDITION.await();
                FULL_CONDITION.await();
            }

            TOTAL++;
            LIST.addLast(TOTAL);
            System.out.println(Thread.currentThread().getName() + " -> " + TOTAL);
//            CONDITION.signalAll();
            EMPTY_CONDITION.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }

    }


    public static void consume() {

        LOCK.lock();
        try {
            while (LIST.isEmpty()) {
//                CONDITION.await();
                EMPTY_CONDITION.await();
            }
            Integer integer = LIST.removeFirst();
            System.out.println(Thread.currentThread().getName() + "->" + integer);
            FULL_CONDITION.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    public static void sleep() {

        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IntStream.range(1, 2).forEach(i -> {
            new Thread(() -> {
                for (; ; ) {
                    produce();
                    sleep();
                }
            }, "Producer-" + i).start();
        });


        IntStream.range(1, 2).forEach(i -> {
            new Thread(() -> {
                for (; ; ) {
                    consume();
                    sleep();
                }
            }, "Consumer-" + i).start();
        });


    }
}
