package com.lang;

import org.junit.Test;

/**
 * 研究String类的一些基本知识
 * Created by 孙建荣 on 17-6-21.下午1:45
 */
public class StringLearn {
    public void testReflect(){
//        String s = String.class.newInstance();
    }

    @Test
    public void testStringConstructor2(){
        char[] ch=new char[]{'数','化','英'};
        String str=new String(ch);
        String str1=new String(ch);
        String str2=new String(ch);
        String str3=new String(ch);
        String str4=new String(ch);
        String str5=new String(ch);
        System.out.println(str);
    }
    @Test
    public void testNoneConstructor() {
        String s = new String();
    }

    @Test
    public void testStringConstructor() {
        String s = new String("参数");
        System.out.println(s);
        String s2=new String("参数2");
        System.out.println(s+s2);
    }
    @Test
    public void testStringConstructor4(){
        String str1="abc";
        String str2="abc";
        System.out.println(str1);
        System.out.println(str2);
    }

    @Test
    public void testStringConstructor5(){
        String str1=new String("abc");
        String str2=new String("abc");
        System.out.println(str1);
        System.out.println(str2);
    }

    @Test
    public void testStringConstructor3(){
        String str1="参数";
        String str2=new String(str1);
        System.out.println(str2);
    }


}
