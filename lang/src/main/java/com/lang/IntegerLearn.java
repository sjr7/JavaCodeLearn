package com.lang;

import org.junit.Test;

/**
 * Created by 孙建荣 on 17-6-24.上午9:18
 */
public class IntegerLearn {

    public void testDigits(){
        Integer integer=new Integer(1);
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
