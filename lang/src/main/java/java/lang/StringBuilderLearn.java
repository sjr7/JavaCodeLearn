package java.lang;

import org.junit.Test;

/**
 * Created by 孙建荣 on 17-7-15.上午9:24
 */
public class StringBuilderLearn {

    @Test
    public void testReverse() {
        StringBuilder stringBuilder = new StringBuilder("sdfsdfsd");
        stringBuilder.reverse();
        System.out.println(stringBuilder);
    }

    @Test
    public void testInsert() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("aaaaaaaaaaaaaa");
        stringBuilder.insert(1, "w");
        System.out.println(stringBuilder);
    }

    @Test
    public void testAppend1() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1);
        System.out.println(stringBuilder);
    }

    @Test
    public void testConstructs2() {
        StringBuilder stringBuilder = new StringBuilder(17);
    }

    @Test
    public void testConstructs() {
        StringBuilder stringBuilder = new StringBuilder();
    }

    @Test
    public void testStringBuilder() {
        long oldTime = System.currentTimeMillis();
        System.out.println(oldTime);
        for (int i = 0; i < 1000000; i++) {
            StringBuilder stringBuilder = new StringBuilder();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime);
    }
}
