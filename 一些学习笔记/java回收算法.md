两个最基本的java回收算法：复制算法和标记清理算法
复制算法：两个区域A和B，初始对象在A，继续存活的对象被转移到B。此为新生代最常用的算法
标记清理：一块区域，标记可达对象（可达性分析），然后回收不可达对象，会出现碎片，那么引出
标记-整理算法：多了碎片整理，整理出更大的内存放更大的对象
两个概念：新生代和年老代
新生代：初始对象，生命周期短的
永久代：长时间存在的对象
整个java的垃圾回收是新生代和年老代的协作，这种叫做分代回收。
P.S：Serial New收集器是针对新生代的收集器，采用的是复制算法
Parallel New（并行）收集器，新生代采用复制算法，老年代采用标记整理
Parallel Scavenge（并行）收集器，针对新生代，采用复制收集算法
Serial Old（串行）收集器，新生代采用复制，老年代采用标记整理
Parallel Old（并行）收集器，针对老年代，标记整理
CMS收集器，基于标记清理
G1收集器：整体上是基于标记 整理 ，局部采用复制

综上：新生代基本采用复制算法，老年代采用标记整理算法。cms采用标记清理。
