package memorytest;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 直接内存测试
 * -Xmx20M -XX:MaxDirectMemorySize=10M
 *
 * @author sunjianrong
 * @date 2021/8/7 下午1:02
 */
public class DirectMemoryTest {

    public static final int size = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);

        Unsafe unsafe = (Unsafe) field.get(null);
        while (true) {
            unsafe.allocateMemory(size);
        }

    }
}
