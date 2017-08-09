# LinkedList浅析(JDK1.8)
## 一. 类的声明
````java
public class LinkedList<E>
    extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable
````

 - 继承父类`AbstractSequentialList`
 - 实现了`List`接口
 - 实现了`Deque`接口
 - 实现了`Cloneable`接口,支持被克隆
 - 实现了`Serializable`接口,支持序列化以及反序列化
##  二. 类的属性
- 容量`size`,被`transient`关键字修饰,不支持序列化传输
`````java
    transient int size = 0;
`````
- 指向第一个节点,或者说是头结点
````java
     /**
     * Pointer to first node.
     * Invariant: (first == null && last == null) ||
     *            (first.prev == null && first.item != null)
     */
    transient Node<E> first;
````
- 指向最后一个节点,可以说是尾节点   

````java
  /**
     * Pointer to last node.
     * Invariant: (first == null && last == null) ||
     *            (last.next == null && last.item != null)
     */
    transient Node<E> last;
````
  
---

## 三.类的构造方法

###   1.    无参的构造方法
```java
public LinkedList() {
    }
```

###    2.   有参的构造方法
- 传入一个集合初始化一个`LinkedList`对象,首先调用无参构造方法,然后调用`addAll()`方法把集合里面所有的数据添加进去
````java
public LinkedList(Collection<? extends E> c) {
        this();
        addAll(c);
    }
````

---
## 四.方法

### 私有的关键方法
这里先把内部类`Node`的代码先贴出来,方便我们下面代码的阅读
```java
private static class Node<E> {
        // 代表元素
        E item;
        // 下一个节点
        Node<E> next;
        // 上一个节点
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
```
- 把元素插入到头部位置
````java

    private void linkFirst(E e) {
        //  得到头部这个节点元素,就是类属性中的 first 属性
        final Node<E> f = first;
        // 这里就是新建出一个新的节点来,新的节点prev属性为null,则前面没有元素,当前元素element为传入的元素e,next的值为f,也就是一开始的第一个节点的元素
        final Node<E> newNode = new Node<>(null, e, f);
        // 把头结点指向新节点
        first = newNode;
        // f为头结点,头结点为null,则说明原来就是空的,尾节点就直接是新节点
        if (f == null)
            last = newNode;
        // 把新节点newNode作为头结点【也就是原来的第一个位置的元素】的前一个节点,相当于把原来的头结点往后移动
        else
            f.prev = newNode;
        size++;
        modCount++;
    }
````
- 插入元素到尾部位置
```java
    void linkLast(E e) {
        //  得到尾部位置的节点 
        final Node<E> l = last;
        //  创建一个新的节点,节点的前一个节点为l,当前节点为e,后一个节点为null
        final Node<E> newNode = new Node<>(l, e, null);
        // 最后一个节点为新节点
        last = newNode;
        // 如果l为空就说明是空节点,所以首节点就是新节点
        if (l == null)
            first = newNode;
        // 把新节点置作为尾节点
        else
            l.next = newNode;
        // 容量要自增
        size++;
        modCount++;
    }
```
- 插入元素到指定节点前面，e为指定元素,succ为指定节点
````java
    
    void linkBefore(E e, Node<E> succ) {
        // assert succ != null;
        // 获取指定节点的前一个节点
        final Node<E> pred = succ.prev;
        // 创建一个新的节点,前一个节点为pred,当前元素为e,下一个节点为succ
        final Node<E> newNode = new Node<>(pred, e, succ);
        // 指定节点的前一个节点为新的节点
        succ.prev = newNode;
        // 前一节点为空说明以前是空的链表,头结点就是信节点
        if (pred == null)
            first = newNode;
        // 不为空下一节点就是新节点
        else
            pred.next = newNode;
        size++;
        modCount++;
    }
````
- 删除头结点的并返回该节点上的数据
````java
    private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;
        // 先获取数据
        final E element = f.item;
        // 把头结点后面的节点后去出来
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        // 后面的节点往前移动
        first = next;
        // next节点都为空了就说明移除后就没有节点了
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;
        return element;
    }
````

- 删除尾节点并返回该节点上的数据
````java
private E unlinkLast(Node<E> l) {
        // assert l == last && l != null;
        // 获取节点的内容
        final E element = l.item;
        // 获取节点的前一个节点,也就是倒数第二
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        // 最后一个节点就等于倒数第二个节点了《因为最后一个已经被删除了
        last = prev;
        // 前一个为空就是链表都为空了
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        modCount++;
        return element;
    }
````
- 删除某个指定节点
````java
E unlink(Node<E> x) {
        // assert x != null;
        final E element = x.item;
        // 获取前一个跟后一个节点元素
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;
        // 前一个为空则说明就是传入指定的节点就是首节点
        if (prev == null) {
            first = next;
            // 否则下一个节点就是
        } else {
            prev.next = next;
            x.prev = null;
        }
        // 后面没有节点就说明当前就是最后一个节点
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        modCount++;
        return element;
    }
````

### 公开的方法












