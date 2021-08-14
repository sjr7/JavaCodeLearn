package gc;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 软引用测试
 * -Xmx128M -Xms64M -XX:+PrintGCDetails
 * 分别为最大堆内存  初始化堆内存
 *
 * @author sunjianrong
 * @date 2021/8/12 下午11:13
 */
public class SoftReferenceDemo {

    public static void main(String[] args) {
        List<SoftReference<byte[]>> list = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            byte[] bytes = new byte[1 << 21];
            list.add(new SoftReference<>(bytes));
            System.out.println("当前元素大小" + list.size());
        }

    }
}
