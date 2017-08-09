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
#####大部分就是调用上面的私有方法来进行操作的
- 获取第一个元素
````java
public E getFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    
````
- 获取最后一个元素
````java

    public E getLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }
````
- 移除第一个元素
````java
    public E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }
````
- 移除最后一个元素

```java
    public E removeLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }
```
- 添加到第一个元素位置
````java
    public void addFirst(E e) {
        linkFirst(e);
    }
````

- 添加到最后一个元素位置
```java
    public void addLast(E e) {
        linkLast(e);
    }
```

- 查看集合中是否包含指定对象
````java
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
````
- 返回当前容量大小
````java
    public int size() {
        return size;
    }
````
- 添加指定元素到集合,默认就是放到最后
````java
     public boolean add(E e) {
         linkLast(e);
         return true;
     }
````
- 移除集合中指定元素,如果有多个只会移除其中的一个
````java
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    // 调用用私有的方法进行移除
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }
````

- 添加指定集合到链表中去,默认就是放到最后
````java
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }
 
````
- 添加指定集合中所有的元素到到链表中的指定下标位置
```java
public boolean addAll(int index, Collection<? extends E> c) {
        checkPositionIndex(index);

        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;

        Node<E> pred, succ;
        if (index == size) {
            succ = null;
            pred = last;
        } else {
            succ = node(index);
            pred = succ.prev;
        }

        for (Object o : a) {
            @SuppressWarnings("unchecked") E e = (E) o;
            Node<E> newNode = new Node<>(pred, e, null);
            if (pred == null)
                first = newNode;
            else
                pred.next = newNode;
            pred = newNode;
        }

        if (succ == null) {
            last = pred;
        } else {
            pred.next = succ;
            succ.prev = pred;
        }

        size += numNew;
        modCount++;
        return true;
    }
```
- 清楚所有的元素
````java
    public void clear() {
        // Clearing all of the links between nodes is "unnecessary", but:
        // - helps a generational GC if the discarded nodes inhabit
        //   more than one generation
        // - is sure to free memory even if there is a reachable Iterator
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
        modCount++;
    }
````
- 获取指定下标元素
```java
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }
```
-设置指定下标的元素
````java
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> x = node(index);
        E oldVal = x.item;
        x.item = element;
        return oldVal;
    }
````
- 添加指定元素到指定下标
````java
    public void add(int index, E element) {
        checkPositionIndex(index);

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }
````
-移除指定下标元素
````java
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }
````
-返回指定下标的节点
````java
　　Node<E> node(int index) {
        // assert isElementIndex(index);
        // 这里有用移位操作,如果指定下标小于总容量大小的1/2,就从头部开始查找,高中数学二分法
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        // 大于1/2就从后面开始查找    
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
````

#### 搜索相关操作
-　查找集合中包含指定对象的下标位置,默认为第一次出现的位置
````java
public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }
````
- 查找集合中最后一次出现指定对象的下标位置
````java
    public int lastIndexOf(Object o) {
        int index = size;
        if (o == null) {
            for (Node<E> x = last; x != null; x = x.prev) {
                index--;
                if (x.item == null)
                    return index;
            }
        } else {
            for (Node<E> x = last; x != null; x = x.prev) {
                index--;
                if (o.equals(x.item))
                    return index;
            }
        }
        return -1;
    }
````

#### 队列的操作
- 出队的操作,不会删除元素,如果为空就会返回null,不会跑出异常
````java
public E peek() {
        final Node<E> f = first;
        return (f == null) ? null : f.item;
    }
````
- 出队的操作,存在的话就会返回元素并且不会移除元素,但是如果为空就会跑出异常,因为调用的是getFirst()方法
```java
 public E element() {
        return getFirst();
    }
```
- 出队的操作,存在的话就会返回这个元素并且被移除,不存在的话就会返回null
```java
public E poll() {
        final Node<E> f = first;
        return (f == null) ? null : unlinkFirst(f);
    }
```
- 出队操作,如果不存在就会跑出异常,存在的话就会有返回值,然后删除这个元素
```java
 public E remove() {
        return removeFirst();
    }
```
- 入队操作,把元素放到后端,始终返回true
```java
  public boolean offer(E e) {
        return add(e);
    }
```

#### 双向队列操作
- 入队操作,把元素放到最前端,始终返回true
```java
 public boolean offerFirst(E e) {
         addFirst(e);
         return true;
     }
```
- 入队操作,把元素放到后端,始终返回true
```java
  public boolean offerLast(E e) {
          addLast(e);
          return true;
      }
```
- 出队操作,如果存在首元素的话就会被返回,不会被移除,如果不存在就会返回null,不会抛出异常(也就是从前端出队)
```java
     public E peekFirst() {
        final Node<E> f = first;
        return (f == null) ? null : f.item;
     }
```
- 出队操作,如果存在尾元素的话就会被返回,不会被移除,如果不存在就会返回null,不会抛出异常(也就是从后端出队)
```java
public E peekLast() {
        final Node<E> l = last;
        return (l == null) ? null : l.item;
    }
```

- 出队操作,从前端开始操作,如果存在第一个元素的话就会被返回,并且被移除,如果不存在的话就返回null
```java
    public E pollFirst() {
        final Node<E> f = first;
        return (f == null) ? null : unlinkFirst(f);
    }
```

- 出队操作,从后端开始操作,如果存在最后一个元素的话就会被返回,同事也会被移除,如果不存在的话就会返回null
```java
    public E pollLast() {
        final Node<E> l = last;
        return (l == null) ? null : unlinkLast(l);
    }
```
- 入栈操作,也就是调用addFirst()方法把元素放在第一个
```java
public void push(E e) {
        addFirst(e);
    }
```
- 出栈操作,也就是把栈顶第一个元素弹出,同时把元素删除
```java
    public E pop() {
        return removeFirst();
    } 
```






















