int和int之间，用==比较，肯定为true。基本数据类型没有equals方法
int和Integer比较，Integer会自动拆箱，== 和 equals都肯定为true
int和new Integer比较，Integer会自动拆箱，调用intValue方法, 所以 == 和 equals都肯定为true
Integer和Integer比较的时候，由于直接赋值的话会进行自动的装箱。所以当值在[-128,127]中的时候，由于值缓存在IntegerCache中，那么当赋值在这个区间的时候，不会创建新的Integer对象，而是直接从缓存中获取已经创建好的Integer对象。而当大于这个区间的时候，会直接new Integer。 
当Integer和Integer进行==比较的时候，在[-128,127]区间的时候，为true。不在这个区间，则为false 
当Integer和Integer进行equals比较的时候，由于Integer的equals方法进行了重写，比较的是内容，所以为true

Integer和new Integer ： new Integer会创建对象，存储在堆中。而Integer在[-128,127]中，从缓存中取，否则会new Integer. 
所以 Integer和new Integer 进行==比较的话，肯定为false ; Integer和new Integer 进行equals比较的话，肯定为true

new Integer和new Integer进行==比较的时候，肯定为false ; 进行equals比较的时候，肯定为true 
原因是new的时候，会在堆中创建对象，分配的地址不同，==比较的是内存地址，所以肯定不同

装箱过程是通过调用包装器的valueOf方法实现的 
拆箱过程是通过调用包装器的xxxValue方法实现的（xxx表示对应的基本数据类型）

总结：Byte、Short、Integer、Long这几个类的valueOf方法实现类似的。所以在[-128,127]区间内，==比较的时候，值总是相等的（指向的是同一对象），在这个区间外是不等的。 
而Float和Double则不相等， Boolean的值总是相等的。
