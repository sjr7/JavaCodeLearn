package com.lang;

import org.junit.Test;

/**
 * Created by 孙建荣 on 17-6-24.上午9:18
 */
public class IntegerLearn {
    @Test
    public void testIntegerCache2() {
        Integer integer1 = 256;
        Integer integer2 = 256;
        System.out.println(integer1 == integer2);

        Integer integer3 = 257;
        Integer integer4 = 257;
        System.out.println(integer3 == integer4);
    }

    @Test
    public void testIntegerCache() {
        Integer integer1 = 127;
        Integer integer2 = 127;
        System.out.println(integer1 == integer2);

        Integer integer3 = 128;
        Integer integer4 = 128;
        System.out.println(integer3 == integer4);

        Integer integer5 = -128;
        Integer integer6 = -128;
        System.out.println(integer5 == integer6);

        Integer integer7 = -129;
        Integer integer8 = -129;
        System.out.println(integer7 == integer8);
    }


    public void testDigits() {
        Integer integer = new Integer(1);
    }

    @Test
    public void testIntegerType() {
        System.out.println(Integer.TYPE);
        // 使用 == 进行比较
        System.out.println(Integer.TYPE == int.class);
        System.out.println(Integer.class == int.class);
        // 如果还想更加准确地比较,可以使用System.identityHashCode()产生一个哈希码,这个是给予地址生成的,不是给予内容
        System.out.println(System.identityHashCode(Integer.TYPE));
        System.out.println(System.identityHashCode(int.class));
        System.out.println(System.identityHashCode(Integer.class));
    }

    @Test
    public void testByte() {
        byte b = 127;
//        byte c=b+1;
        System.out.println(b + 1);
    }

    @Test
    public void testInteger() {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
}
