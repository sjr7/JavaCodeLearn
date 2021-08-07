package memorytest;

import java.util.HashSet;
import java.util.Set;

/**
 * 常量池溢出测试
 * 在JDK7以上，指定 -Xmx 为6M
 *
 * @author sunjianrong
 * @date 2021/8/7 下午12:57
 */
public class RuntimeConstantPoolOomTest {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }

    }
}
