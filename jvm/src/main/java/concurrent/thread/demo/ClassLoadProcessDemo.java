package concurrent.thread.demo;

/**
 * @author sunjianrong
 * @date 2021/8/9 下午10:59
 */
public class ClassLoadProcessDemo {

    private static int x = 0;
    private static int y;
    private static ClassLoadProcessDemo classLoadProcessDemo = new ClassLoadProcessDemo();

    private ClassLoadProcessDemo() {
        x++;
        y++;
    }



    public static ClassLoadProcessDemo getInstance(){
        return classLoadProcessDemo;
    }

    public static void main(String[] args) {
        ClassLoadProcessDemo instance = getInstance();
        System.out.println(instance.x);
        System.out.println(instance.y);

    }
}
