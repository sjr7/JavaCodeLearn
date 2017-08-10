package test.lang;

import org.junit.Test;

import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.StringJoiner;

/**
 * 研究String类的一些基本知识
 * Created by 孙建荣 on 17-6-21.下午1:45
 */
public class StringLearn {
    @Test
    public  void testIntern() {
        String str = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str.intern() == str);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

    @Test

    public void testToArrayCopy() {
        String str = "12312312312";
        char[] chars = str.toCharArray();
        System.out.println(chars);
    }

    @Test
    public void testTrim() {
        char[] chars = new char[21];
        chars[0] = '\u0000';
        chars[1] = '\u0001';
        chars[2] = '\u0002';
        chars[3] = '\u0003';
        chars[4] = '\u0004';
        chars[5] = '\u0005';
        chars[6] = '\u0006';
        chars[7] = '\u0007';
        chars[8] = '\u0008';
        chars[9] = '\u0009';
        chars[10] = '\u0010';
        chars[11] = '\u0012';
        chars[12] = '\u0013';
        chars[13] = '\u0014';
        chars[14] = '\u0015';
        chars[15] = '\u0016';
        chars[16] = '\u0017';
        chars[17] = '\u0018';
        chars[18] = '\u0019';
        chars[19] = '\u0020';
        chars[20] = '\u0021';
        String str1 = new String(chars);
        System.out.println("去除前的长度为" + str1.length());
        String str2 = str1.trim();
        System.out.println("去除后的长度为" + str2.length());
    }

    @Test
    public void testStringJoiner2() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("abc");
        linkedList.add("def");
        linkedList.add("ghi");
        StringJoiner stringJoiner = new StringJoiner("---");
        for (CharSequence cs : linkedList) {
            System.out.println(cs);
            stringJoiner.add(cs);
        }
        System.out.println(stringJoiner.toString());
    }

    @Test
    public void testStringJoiner() {
        StringJoiner stringJoiner = new StringJoiner("-");
        stringJoiner.add("123");
        stringJoiner.add("345");
        stringJoiner.add("456");
        System.out.println(stringJoiner.toString());
    }

    @Test
    public void testJoin() {
        String s = String.join("-----", "a", "b", "c");
        System.out.println(s);
    }

    @Test
    public void testIgnoreUpcase() {
        String s1 = "wer";
        String s2 = "WER";
        System.out.println(s1.equalsIgnoreCase(s2));
    }

    @Test
    public void testContentEqual() {
        String s1 = "hello";
        String s2 = new String("hello");
        StringBuffer sb = new StringBuffer("hello");
        StringBuilder sb2 = new StringBuilder("hello");
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
