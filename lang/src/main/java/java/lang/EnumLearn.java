package java.lang;

import org.junit.Test;

/**
 * Created by 孙建荣 on 17-7-2.下午8:06
 */
public class EnumLearn {

    @Test
    public void testEnum(){
        boolean b = Enums.ONE.getDeclaringClass() == Enums.THREE.getDeclaringClass();
        System.out.println(b);
    }

}
