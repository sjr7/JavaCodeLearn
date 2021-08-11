package concurrent.thread.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunjianrong
 * @date 2021/8/8 上午10:41
 */
public class HashMapDeadLockDemo {

    private final Map<String, String> map = new HashMap<>();

    public void add(String key, String value) {
        this.map.put(key, value);
    }


    public static void main(String[] args) {
        HashMapDeadLockDemo hashMapDeadLockDemo = new HashMapDeadLockDemo();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (int j = 0; j < Integer.MAX_VALUE; j++) {
                    hashMapDeadLockDemo.add(String.valueOf(j), String.valueOf(j));
                }
            }).start();
        }
    }
}
