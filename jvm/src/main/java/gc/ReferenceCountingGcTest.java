package gc;

/**
 * 引用计数算法测试
 *
 * @author sunjianrong
 * @date 2021/8/7 下午3:03
 */
public class ReferenceCountingGcTest {

    public Object instance = null;

    public static final int size = 1024 * 1024;

    /**
     * 占用内存
     */
    private byte[] bigSize = new byte[size];

    // 观察 gc 日志，会发现内存依旧被回收，说明不是引用计数算法
    public static void main(String[] args) {
        ReferenceCountingGcTest objA = new ReferenceCountingGcTest();
        ReferenceCountingGcTest objB = new ReferenceCountingGcTest();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();


    }
}
