package java.lang;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import java.io.File;

/**
 * Created by 孙建荣 on 17-6-24.上午9:18
 */
public class IntegerLearn {

    @Test
    public void testStringSize(){
        Integer integer=new Integer(2);
        long l = integer.longValue();
        int intValue = integer.intValue();
        String s = integer.toString();
        System.out.println(l);
        System.out.println(intValue);
        System.out.println(s);
    }

    @Test
    public void testMinValue(){
        int max = Integer.max(1, 222);
        System.out.println(max);
    }

    @Test
    public void testMax2(){
        int sum = Integer.sum(1, 2);
        System.out.println(sum);
    }

    @Test
    public void testMax(){
        Integer integer=new Integer(22);
        short shortValue = integer.shortValue();
        System.out.println(shortValue);
    }

    @Test
    public void testMin() {
        Integer integer = new Integer(22);
        int maxValue = Integer.MAX_VALUE;
        System.out.println(maxValue);
    }

    @Test
    public void testRename() {
        String path = "/media/sunjianrong/HHD_Date/Java/尚学堂高淇java300集第二季";
        File file = new File(path);
        File[] files = file.listFiles();
        for (File file2 : files) {
            if (file2.getName().contains("_尚学堂_【裴新】_java300集最全视频教程_")) {
                String fileName = file2.getName();
//                String newFileName = fileName.replace("_尚学堂_高淇_java300集最全视频教程_", "");
                String newFileName = fileName.replace("_尚学堂_【裴新】_java300集最全视频教程_", "");
                file2.renameTo(new File(path + "/" + newFileName));
                System.out.println(path + "/" + newFileName);
            }
        }
    }

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
