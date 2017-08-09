package java.lang;

import org.junit.Test;

/**
 * Created by 孙建荣 on 17-7-15.上午11:58
 */
public class StringBufferTest {

    @Test
    public void testConstructs1(){
        StringBuffer stringBuffer=new StringBuffer();
        StringBuffer stringBuffer2=new StringBuffer(18);
        StringBuffer stringBuffer3=new StringBuffer("121");
        stringBuffer.append(1);
        stringBuffer.append("c");
        stringBuffer.reverse();
        stringBuffer.indexOf("c");
        stringBuffer.insert(1,1);
    }
}
