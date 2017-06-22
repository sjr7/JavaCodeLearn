package com.lang;

import org.junit.Test;

import java.nio.charset.Charset;

/**
 * 研究String类的一些基本知识
 * Created by 孙建荣 on 17-6-21.下午1:45
 */
public class StringLearn {
    @Test
    public void testIgnoreUpcase(){
        String s1="wer";
        String s2="WER";
        System.out.println(s1.equalsIgnoreCase(s2));
    }

    @Test
    public void testContentEqual() {
        String s1 = "hello";
        String s2 = new String("hello");
        StringBuffer sb = new StringBuffer("hello");
        StringBuilder sb2=new StringBuilder("hello");
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(sb));
        System.out.println(s1.equals(sb2));
        System.out.println(s1.contentEquals(sb));
        System.out.println(s1.contentEquals(sb2));
    }

    public void testGetBYte() {
        Charset charset = Charset.defaultCharset();
    }

    @Test
    public void testCompareTo() {
        String str1 = "12312";
        int i = str1.compareTo("12");
        System.out.println(i);
    }

    @Test
    public void testCharAt() {
        String str = "0123456789";
        char c = str.charAt(3);
        System.out.println(c);
    }

    @Test
    public void testStringConstructor2() {
        char[] ch = new char[]{'数', '化', '英'};
        String str = new String(ch);
        String str1 = new String(ch);
        String str2 = new String(ch);
        String str3 = new String(ch);
        String str4 = new String(ch);
        String str5 = new String(ch);
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
        String s2 = new String("参数2");
        System.out.println(s + s2);
    }

    @Test
    public void testStringConstructor4() {
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1);
        System.out.println(str2);
    }

    @Test
    public void testStringConstructor5() {
        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println(str1);
        System.out.println(str2);
    }

    @Test
    public void testStringConstructor3() {
        String str1 = "参数";
        String str2 = new String(str1);
        System.out.println(str2);
    }


}
