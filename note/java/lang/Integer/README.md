# java.lang.Integer浅析

## 一. Integer类的声明
```java
public final class Integer extends Number implements Comparable<Integer>{}
```
![](images/Integer.png)  
  - Integer是一个**Final**类,也就是不可变的类
  - 继承了**Number**这个抽象类,拥有了父类的一系列方法,同时也隐式的实现了**Serializable**接口
  - 实现了**Comparable**接口,说明它是可以进行比较的,但是限定了智能跟**Integer**类型进行比较,愿意就是在实现**Comparable**接口的时候使用了**泛型**,进行比较的方法`compareTo(T o)`是根据传入的泛型作为比较的参数的,所以限定了`compareTo()`只能比较`INteger`类型

## 二. Integer的属性
- ①.定义了一个**最小值**,是`2^-31`,换算过来就是`-2147483648`,因为是个静态属性,可以直接通过`Integer.MIN_VALUE`取到
```java
    //  A constant holding the minimum value an {@code int} can have, -2^31
    @Native public static final int   MIN_VALUE = 0x80000000;
```
---
- ②.定义一个**最大值**,是`2^31`,换算过来就是`2147483647`,因为是个静态属性,可以直接通过`Integer.MAX_VALUE`取到
````java
    // A constant holding the maximum value an  int can have, 2^31-1.
   @Native public static final int   MAX_VALUE = 0x7fffffff;
````
---
- ③.得到`Integer`的类型,根据方法注释我们可以知道是`Integer`类型的`Type`是一个基本类型
```java
 /**
     * The  Class instance representing the primitive type int.
     * @since   JDK1.1
     */
    @SuppressWarnings("unchecked")
    public static final Class<Integer>  TYPE = (Class<Integer>) Class.getPrimitiveClass("int");
```
然后我们这里就会引发一个疑问了,为什么`Integer`的`Type`会是`in.class`呢？,这里我们其实可以像个栗子：
```java
        System.out.println(Integer.TYPE);                        //  int 
        // 使用 == 进行比较
        System.out.println(Integer.TYPE == int.class);          // true
        System.out.println(Integer.class == int.class);         // false
        // 如果还想更加准确地比较,可以使用System.identityHashCode()产生一个哈希码,这个是给予地址生成的,不是给予内容
        System.out.println(System.identityHashCode(Integer.TYPE));      //  2061475679
        System.out.println(System.identityHashCode(int.class));        //  2061475679
        System.out.println(System.identityHashCode(Integer.class));    //   410424423
```
这里我们可以很清楚的得到理论就是:  
   1.  `Integer.TYPE`跟`int.class`是相等的,因为`Integer.TYPE`这个常量就是通过`Class.getPrimitiveClass("int")`得到的.
   2.  `Integer.class`跟`int.class`是不相等的,因为`Integer.class`是个包装类,我们可以看到它的源码,`int.class`的源码我就不知道去哪里看了  
---

- 列举出所有可能作为数字的字母,每个字母对应着`ASCII`码,是可以进行转换的,给方法内部使用的
```java
     //  All possible chars for representing a number as a String
    final static char[] digits = {
        '0' , '1' , '2' , '3' , '4' , '5' ,
        '6' , '7' , '8' , '9' , 'a' , 'b' ,
        'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
        'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
        'o' , 'p' , 'q' , 'r' , 's' , 't' ,
        'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };
```
## Integer的方法
- toString()方法,也重写了`Object`的`toString()`方法
```java
public static String toString(int i, int radix) {
        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX)
            radix = 10;

        /* Use the faster version */
        if (radix == 10) {
            return toString(i);
        }

        char buf[] = new char[33];
        boolean negative = (i < 0);
        int charPos = 32;

        if (!negative) {
            i = -i;
        }

        while (i <= -radix) {
            buf[charPos--] = digits[-(i % radix)];
            i = i / radix;
        }
        buf[charPos] = digits[-i];

        if (negative) {
            buf[--charPos] = '-';
        }

        return new String(buf, charPos, (33 - charPos));
    }
```

- 转变成一个无符号的`String`类型
```java
 public static String toUnsignedString(int i, int radix) {
        return Long.toUnsignedString(toUnsignedLong(i), radix);
    }
```