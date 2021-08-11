package concurrent.thread.demo;

/**
 * @author sunjianrong
 * @date 2021/8/8 上午9:59
 */
public class TicketDemo implements Runnable {

//    private int current = 1;
    private volatile int current = 1;

    public static final int max = 500;

    @Override
    public void run() {
        while (current <= max) {
            int i = current++;
            if (i > max) {
                System.out.println("本次超卖!!!!!!!!!!!!!!!!!!");
            }
            System.out.println(Thread.currentThread().getName() + "售票第" + i + "张");
        }
    }


    public static void main(String[] args) {
        TicketDemo ticketDemo = new TicketDemo();

        Thread thread1 = new Thread(ticketDemo, "窗口一");
        Thread thread2 = new Thread(ticketDemo, "窗口二");
        Thread thread3 = new Thread(ticketDemo, "窗口三");
        Thread thread4 = new Thread(ticketDemo, "窗口四");
        Thread thread5 = new Thread(ticketDemo, "窗口五");
        Thread thread6 = new Thread(ticketDemo, "窗口六");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}
