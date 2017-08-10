package test.util;

import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by 孙建荣 on 17-8-9.下午3:40
 */
public class LinkedListLearn {



    /**
     * 在1千万数据里面往下标为1千万的位置插入一个数据
     * 使用LinkedList随机插入数据:0毫秒
     * 使用ArrayList随机地插入数据:0毫秒
     */
    @SuppressWarnings("Duplicates")
    @Test
    public void test7() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long begin = System.currentTimeMillis();
        list.add(10000000,10000000);
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println("使用LinkedList往下标为1千万的位置数据:" + time + "毫秒");

        ArrayList<Integer> list2 = new ArrayList();
        for (int i = 0; i < 10000000; i++) {
            list2.add(i);
        }
        long begin2 = System.currentTimeMillis();
        list.add(10000000,10000000);
        long end2 = System.currentTimeMillis();
        long time2 = end2 - begin2;
        System.out.println("使用ArrayList往下标为1千万的位置插入数据:" + time2 + "毫秒");

    }

    /**
     * 在1千万数据里面往下标为8020300的位置插入一个数据
     * 使用LinkedList随机插入数据:8毫秒
     * 使用ArrayList随机地插入数据:21毫秒
     */
    @SuppressWarnings("Duplicates")
    @Test
    public void test10() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long begin = System.currentTimeMillis();
        list.add(8020300,10000000);
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println("使用LinkedList往下标为8020300的位置数据:" + time + "毫秒");

        ArrayList<Integer> list2 = new ArrayList();
        for (int i = 0; i < 10000000; i++) {
            list2.add(i);
        }
        long begin2 = System.currentTimeMillis();
        list.add(8020300,10000000);
        long end2 = System.currentTimeMillis();
        long time2 = end2 - begin2;
        System.out.println("使用ArrayList往下标为8020300的位置插入数据:" + time2 + "毫秒");

    }



    /**
     * 在1千万数据里面往下标为7000000的位置插入一个数据
     * 使用LinkedList随机插入数据:13毫秒
     * 使用ArrayList随机地插入数据:34毫秒
     */
    @SuppressWarnings("Duplicates")
    @Test
    public void test21() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long begin = System.currentTimeMillis();
        list.add(7000000,10000000);
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println("使用LinkedList往下标为7000000的位置数据:" + time + "毫秒");

        ArrayList<Integer> list2 = new ArrayList();
        for (int i = 0; i < 10000000; i++) {
            list2.add(i);
        }
        long begin2 = System.currentTimeMillis();
        list.add(7000000,10000000);
        long end2 = System.currentTimeMillis();
        long time2 = end2 - begin2;
        System.out.println("使用ArrayList往下标为7000000的位置插入数据:" + time2 + "毫秒");

    }

    /**
     * 在1千万数据里面往下标为5000000的位置插入一个数据
     * 使用LinkedList随机插入数据:30毫秒
     * 使用ArrayList随机地插入数据:54毫秒
     */
    @SuppressWarnings("Duplicates")
    @Test
    public void test20() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long begin = System.currentTimeMillis();
        list.add(5000000,10000000);
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println("使用LinkedList往下标为5000000的位置数据:" + time + "毫秒");

        ArrayList<Integer> list2 = new ArrayList();
        for (int i = 0; i < 10000000; i++) {
            list2.add(i);
        }
        long begin2 = System.currentTimeMillis();
        list.add(5000000,10000000);
        long end2 = System.currentTimeMillis();
        long time2 = end2 - begin2;
        System.out.println("使用ArrayList往下标为5000000的位置插入数据:" + time2 + "毫秒");

    }

    /**
     * 在1千万数据里面往下标为2000000的位置插入一个数据
     * 使用LinkedList随机插入数据:19毫秒
     * 使用ArrayList随机地插入数据:25毫秒
     */
    @SuppressWarnings("Duplicates")
    @Test
    public void test19() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long begin = System.currentTimeMillis();
        list.add(2000000,10000000);
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println("使用LinkedList往下标为2000000的位置数据:" + time + "毫秒");

        ArrayList<Integer> list2 = new ArrayList();
        for (int i = 0; i < 10000000; i++) {
            list2.add(i);
        }
        long begin2 = System.currentTimeMillis();
        list.add(2000000,10000000);
        long end2 = System.currentTimeMillis();
        long time2 = end2 - begin2;
        System.out.println("使用ArrayList往下标为2000000的位置插入数据:" + time2 + "毫秒");

    }

    /**
     * 在1千万数据里面往下标为1的位置插入一个数据
     * 使用LinkedList随机插入数据:0毫秒
     * 使用ArrayList随机地插入数据:0毫秒
     */
    @SuppressWarnings("Duplicates")
    @Test
    public void test6() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long begin = System.currentTimeMillis();
        list.add(1,10000000);
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println("使用LinkedList往下标为1的位置数据:" + time + "毫秒");

        ArrayList<Integer> list2 = new ArrayList();
        for (int i = 0; i < 10000000; i++) {
            list2.add(i);
        }
        long begin2 = System.currentTimeMillis();
        list.add(1,10000000);
        long end2 = System.currentTimeMillis();
        long time2 = end2 - begin2;
        System.out.println("使用ArrayList往下标为1的位置插入数据:" + time2 + "毫秒");

    }

    /**
     * 在1千万数据里面不指定下标插入一个数据
     * 使用LinkedList随机插入数据:0毫秒
     * 使用ArrayList随机地插入数据:0毫秒
     */
    @SuppressWarnings("Duplicates")
    @Test
    public void test5() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long begin = System.currentTimeMillis();
        list.add(5000000);
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println("使用LinkedList往下标为1的位置数据:" + time + "毫秒");

        ArrayList<Integer> list2 = new ArrayList();
        for (int i = 0; i < 10000000; i++) {
            list2.add(i);
        }
        long begin2 = System.currentTimeMillis();
        list.add(5000000);
        long end2 = System.currentTimeMillis();
        long time2 = end2 - begin2;
        System.out.println("使用ArrayList往下标为1的位置插入数据:" + time2 + "毫秒");

    }

    /**
     * 在1千万数据里面查找下标为1千万的数据
     * 使用LinkedList随机读取数据:0毫秒
     * 使用ArrayList随机地读取数据:0毫秒
     */
    @SuppressWarnings("Duplicates")
    @Test
    public void test18() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long begin = System.currentTimeMillis();
        Object o1 = list.get(9999999);
        System.out.println(o1.toString());
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println("使用LinkedList随机读取第1千万位置数据:" + time + "毫秒");

        ArrayList<Integer> list2 = new ArrayList();
        for (int i = 0; i < 10000000; i++) {
            list2.add(i);
        }
        long begin2 = System.currentTimeMillis();
        Object o2 = list.get(9999999);
        System.out.println(o2.toString());
        long end2 = System.currentTimeMillis();
        long time2 = end2 - begin2;
        System.out.println("使用ArrayList随机地读取第1千万位置数据:" + time2 + "毫秒");

    }

    /**
     * 在1千万数据里面查找下标为9020300的数据
     * 使用LinkedList随机读取数据:6毫秒
     * 使用ArrayList随机地读取数据:9毫秒
     */
    @SuppressWarnings("Duplicates")
    @Test
    public void test15() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long begin = System.currentTimeMillis();
        Object o1 = list.get(9020300);
        System.out.println(o1.toString());
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println("使用LinkedList随机读取第9020300位置数据:" + time + "毫秒");

        ArrayList<Integer> list2 = new ArrayList();
        for (int i = 0; i < 10000000; i++) {
            list2.add(i);
        }
        long begin2 = System.currentTimeMillis();
        Object o2 = list.get(9020300);
        System.out.println(o2.toString());
        long end2 = System.currentTimeMillis();
        long time2 = end2 - begin2;
        System.out.println("使用ArrayList随机地读取第9020300位置数据:" + time2 + "毫秒");

    }

    /**
     * 在1千万数据里面查找下标为8020300的数据
     * 使用LinkedList随机读取数据:9毫秒
     * 使用ArrayList随机地读取数据:19毫秒
     */
    @SuppressWarnings("Duplicates")
    @Test
    public void test14() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long begin = System.currentTimeMillis();
        Object o1 = list.get(8020300);
        System.out.println(o1.toString());
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println("使用LinkedList随机读取第8020300位置数据:" + time + "毫秒");

        ArrayList<Integer> list2 = new ArrayList();
        for (int i = 0; i < 10000000; i++) {
            list2.add(i);
        }
        long begin2 = System.currentTimeMillis();
        Object o2 = list.get(8020300);
        System.out.println(o2.toString());
        long end2 = System.currentTimeMillis();
        long time2 = end2 - begin2;
        System.out.println("使用ArrayList随机地读取第8020300位置数据:" + time2 + "毫秒");

    }

    /**
     * 在1千万数据里面查找下标为5000000的数据
     * 使用LinkedList随机读取数据:34毫秒
     * 使用ArrayList随机地读取数据:47毫秒
     */
    @SuppressWarnings("Duplicates")
    @Test
    public void test4() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long begin = System.currentTimeMillis();
        Object o1 = list.get(5000000);
        System.out.println(o1.toString());
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println("使用LinkedList随机读取第5百万位置数据:" + time + "毫秒");

        ArrayList<Integer> list2 = new ArrayList();
        for (int i = 0; i < 10000000; i++) {
            list2.add(i);
        }
        long begin2 = System.currentTimeMillis();
        Object o2 = list.get(5000000);
        System.out.println(o2.toString());
        long end2 = System.currentTimeMillis();
        long time2 = end2 - begin2;
        System.out.println("使用ArrayList随机地读取第5百万位置数据:" + time2 + "毫秒");

    }

    /**
     * 在1千万数据里面查找下标为3020300的数据
     * 使用LinkedList随机读取数据:28毫秒
     * 使用ArrayList随机地读取数据:30毫秒
     */
    @SuppressWarnings("Duplicates")
    @Test
    public void test16() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long begin = System.currentTimeMillis();
        Object o1 = list.get(3020300);
        System.out.println(o1.toString());
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println("使用LinkedList随机读取第3020300位置数据:" + time + "毫秒");

        ArrayList<Integer> list2 = new ArrayList();
        for (int i = 0; i < 10000000; i++) {
            list2.add(i);
        }
        long begin2 = System.currentTimeMillis();
        Object o2 = list.get(3020300);
        System.out.println(o2.toString());
        long end2 = System.currentTimeMillis();
        long time2 = end2 - begin2;
        System.out.println("使用ArrayList随机地读取第3020300位置数据:" + time2 + "毫秒");

    }
    /**
     * 在1千万数据里面查找下标为1020300的数据
     * 使用LinkedList随机读取数据:10毫秒
     * 使用ArrayList随机地读取数据:10毫秒
     */
    @SuppressWarnings("Duplicates")
    @Test
    public void test17() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long begin = System.currentTimeMillis();
        Object o1 = list.get(1020300);
        System.out.println(o1.toString());
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println("使用LinkedList随机读取第1020300位置数据:" + time + "毫秒");

        ArrayList<Integer> list2 = new ArrayList();
        for (int i = 0; i < 10000000; i++) {
            list2.add(i);
        }
        long begin2 = System.currentTimeMillis();
        Object o2 = list.get(1020300);
        System.out.println(o2.toString());
        long end2 = System.currentTimeMillis();
        long time2 = end2 - begin2;
        System.out.println("使用ArrayList随机地读取第1020300位置数据:" + time2 + "毫秒");

    }


    /**
     * 在1千万数据里面查找下标为1的数据
     * 使用LinkedList随机读取数据:0毫秒
     * 使用ArrayList随机地读取数据:0毫秒
     */
    @SuppressWarnings("Duplicates")
    @Test
    public void test3() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long begin = System.currentTimeMillis();
        Object o1 = list.get(1);
        System.out.println(o1.toString());
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println("使用LinkedList随机读取第1位置数据:" + time + "毫秒");

        ArrayList<Integer> list2 = new ArrayList();
        for (int i = 0; i < 10000000; i++) {
            list2.add(i);
        }
        long begin2 = System.currentTimeMillis();
        Object o2 = list.get(1);
        System.out.println(o2.toString());
        long end2 = System.currentTimeMillis();
        long time2 = end2 - begin2;
        System.out.println("使用ArrayList随机地读取第1位置数据:" + time2 + "毫秒");

    }

    /**
     * 在1千万数据里面查找第9百万的下标数据
     * 使用LinkedList随机读取数据:5毫秒
     * 使用ArrayList随机地读取数据:9毫秒
     */
    @Test
    public void test2() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long begin = System.currentTimeMillis();
        Object o1 = list.get(9000000);
        System.out.println(o1.toString());
        long end = System.currentTimeMillis();
        long time = end - begin;

        System.out.println("使用LinkedList随机读取第9百万下标位置数据:" + time + "毫秒");

        ArrayList<Integer> list2 = new ArrayList();
        for (int i = 0; i < 10000000; i++) {
            list2.add(i);
        }
        long begin2 = System.currentTimeMillis();
        Object o2 = list.get(9000000);
        System.out.println(o2.toString());
        long end2 = System.currentTimeMillis();
        long time2 = end2 - begin2;

        System.out.println("使用ArrayList随机地读取第9百万下标位置数据:" + time2 + "毫秒");
        System.out.println("==================");

    }


    /**
     * 正常地测试两个类型对象的插入，插入1千万的数据,连续数据
     * 使用LinkedList正常地使用LinkedList插入数据:4982毫秒
     * 使用ArrayList正常地一个一个插入数据:843毫秒
     */
    @Test
    public void test1() {
        long begin = System.currentTimeMillis();
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println("使用LinkedList正常地使用LinkedList插入数据:" + time + "毫秒");

        long begin2 = System.currentTimeMillis();
        ArrayList<Integer> list2 = new ArrayList();
        for (int i = 0; i < 10000000; i++) {
            list2.add(i);
        }
        long end2 = System.currentTimeMillis();
        long time2 = end2 - begin2;
        System.out.println("使用ArrayList正常地一个一个插入数据:" + time2 + "毫秒");

    }
}
