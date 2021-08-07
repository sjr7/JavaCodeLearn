package memorytest;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出测试.
 * 测试你前先添加虚拟机启动参数
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author sunjianrong
 * @date 2021/8/7 上午10:39
 */
public class HeapOom {

    static class OomObject {

    }


    public static void main(String[] args) {
        List<OomObject> list = new ArrayList<>();
        while (true) {
            list.add(new OomObject());
        }

    }
}
