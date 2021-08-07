package memorytest;

/**
 * 测试栈内存溢出
 * 指定 vm 参数 -Xss228k
 *
 * @author sunjianrong
 * @date 2021/8/7 下午12:47
 */
public class StackOverFlowTest {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }


    public static void main(String[] args) {
        StackOverFlowTest stackOverFlowTest = new StackOverFlowTest();
        try {
            stackOverFlowTest.stackLeak();
        } catch (Throwable e) {
            System.out.println("Stack length:" + stackOverFlowTest.stackLength);
            throw e;
        }

    }
}
