package gc;

/**
 * GC自我拯救演示
 *
 * @author sunjianrong
 * @date 2021/8/7 下午3:35
 */
public class FinalizeEscapeGc {

    public static FinalizeEscapeGc saveHook = null;


    public void isAlive() {
        System.out.println("活着");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize 函数被执行");
        FinalizeEscapeGc.saveHook = this;
    }

    public static void main(String[] args) throws InterruptedException {
        saveHook = new FinalizeEscapeGc();

        // 第一次拯救自己
        finalizeExecute();

        // 自救失败
        finalizeExecute();

    }

    private static void finalizeExecute() throws InterruptedException {
        saveHook = null;
        System.gc();

        // finalize 方法优先级低，休眠等待一下
        Thread.sleep(500);
        if (saveHook != null) {
            saveHook.isAlive();
        } else {
            System.out.println("对象消亡");
        }
    }
}
