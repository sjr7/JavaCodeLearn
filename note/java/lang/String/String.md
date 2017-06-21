# java.lang.String浅析
## String类的声明
````java
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence{} 
````
![](images/diagram.png)
 - `String`类是`Final`类型的,不可变的类,所以是不能被继承的
 - 实现`Serializable`接口说明是支持被序列化以及反序列化
 - 实现`Comparable`接口说明`String`支持被排序
 - 实现`CharSequence`接口是一个可读序列
 - 同时在实现接口的时候使用到了`JDK1.5`的新特性`泛型`
## String类的属性
````java
 /** The value is used for character storage. */
    private final char value[];
````
从这里我们可以看出这是一个`Final`修饰的`character`类型数组,由此我们可以想到`String`不可变的性质应该跟这个有关了,然后`String`也还是**字符数组**
```java
 /** Cache the hash code for the string */
    private int hash; // Default to 0
```
缓存字符串的`HashCode`,默认是为0
```java
 /** use serialVersionUID from JDK 1.0.2 for interoperability */
    private static final long serialVersionUID = -6849794470754667710L;
```
`serialVersionUID`翻译过中文来就是`序列化ID`,在反序列化的时候`JVM`要比较从某种途径传递过来的`字节流`中的`serialVersionUID`跟本地类文件中的`serialVersionUID`是否一制,如果不一致就会反序列化失败
```java
 /**
     * Class String is special cased within the Serialization Stream Protocol.
     *
     * A String instance is written into an ObjectOutputStream according to
     * <a href="{@docRoot}/../platform/serialization/spec/output.html">
     * Object Serialization Specification, Section 6.2, "Stream Elements"</a>
     */
private static final ObjectStreamField[] serialPersistentFields =
        new ObjectStreamField[0];
```
这个属性看名字的话就是跟反序列化有关的,就是说一个String实例来源于输入的字节流中,也就是反序列化中的字节流

## String类的构造方法
  - 无参的构造方法
  ```java
/**
     * Initializes a newly created {@code String} object so that it represents
     * an empty character sequence.  Note that use of this constructor is
     * unnecessary since Strings are immutable.
     */
    public String() {
        this.value = "".value;
    }
```
当实例化一个`String`对象没有传参数的话,默认就会赋值**一个空白的字符串**,请注意这里不是`NULL`,`String`
```java
   new String()==null   // 这里得到的是false
```

















