HashMap和Hashtable 区别

1、继承不同。public class Hashtable extends Dictionary implements Map
 public class HashMap extends AbstractMap implements Map

2、Hashtable 中的方法是同步的，而HashMap中的方法在缺省情况下是非同步的。
Hashtable的方法是线程安全的，而HashMap不是线程安全的。
在多线程并发直接使用Hashtable，HashMap用于单线程

3、Hashtable中，key和value都不允许出现null值。
HashMap中，null值可以作为键（key），这样的键只有一个；可以有一个或多个键所对应的值为null。
当get()方法返回null值时，即可以表示 HashMap中没有该键，也可以表示该键所对应的值为null。因此，在HashMap中不能由get()方法来判断HashMap中是否存在某个键， 而应该用containsKey()方法来判断。
HashMap没有contains方法，而是containsValue和containsKey。

4、两个遍历方式的内部实现上不同。
Hashtable、HashMap都使用了Iterator。而由于历史原因，Hashtable还使用了Enumeration的方式 。

5、hash值的使用不同。
HashTable直接使用对象的hashCode。而HashMap重新计算hash值。

6、两个内部实现方式的数组的初始大小和扩容的方式。
HashTable中hash数组默认大小是11，增加的方式是 old*2+1。HashMap中hash数组的默认大小是16，而且一定是2的指数。

ConcurrentHashMap是一个线程安全的HashTable，它的主要功能是提供了一组和HashTable功能相同但是线程安全的方法。
ConcurrentHashMap可以做到读取数据不加锁，并且其内部的结构可以让其在进行写操作的时候能够将锁的粒度保持地尽量地小，不用对整个ConcurrentHashMap加锁
