---
title: "工具类8 List集合"
date: 2019-11-10T09:45:58+08:00
draft: false
---



    集合：
    Collection  存储的都是value对象
        List  有序可重复
        Set   无序无重复

    Map   存储的是以key-value形式存在，key无序无重复，value无序可重复

有序：添加进去的元素与取得元素的顺序一致。注意指的不是集合自己的顺序    
重复：两个对象元素一致   


List集合
1.``ArrayList``
2.``LinkedList``
3.``Vector``

ArrayList与Vector区别：类似于StringBuilder和StringBuffer

1.ArrayList-->底层就是个数组(动态)    
* 所属的包 jaba.util    
* 特点是适合遍历查询，不适合插入删除
* 如何创建对象  
无参数构造方法   、   带默认空间的构造方法   、       带collection参数的构造方法      
* 常用方法------小容器    CURD       
  
    存 add  
    取 get  
    删 remove
    改  set     
    个数 size   

    add(E e);
    add(int index,E e);
    addAll(Collection c);
    addAll(int index,Collection c)//c的类型需比list小
    clear();//将集合内的全部元素清除
    boolean = contains(Object);//找寻某一个给定的元素是否在集合中拥有
    ensureCapacity(int miniCapacity);
    E = get(int index);
    int = indexOf(Object obj);lastIndexOf();
    boolean = isEmpty();
    Iterator = iterator();//迭代器
    remove(int index);remove(Object obj);
    //ArrayList<Integer>-->1 2 3
    //list.remove(1) -->index=1
    //list.remove(new Integer(1)) -->obj=1
    removeAll();//差集
    retainAll();//交集
    E = set(int index,E value);
    int = size();
    List = subList(int begin,int end);//截取
    Object[] = toArray();//集合变成数组
    T[] = toArray(T[] );集合装入数组
    trimToSize();//变成有效元素那么长


    //删掉集合的全部元素,期间list.size()在减小,不能与i放一起让i++
    int size = list.size();
    for(int i=0;i<size;i++){
        list.remove(0);
    }


由于arrayList底层是一个Object[]，什么类型都可以存进去取出来的时候有多态的效果，需要自己造型，显得用起来非常麻烦     
JDK1.5之后--->泛型      
用来规定数据类型，定义的时候用一个符号代替某种类型，在使用的时候用具体的数据类型将定义的符号替换掉      

泛型可以用在哪里？  
1.泛型类    
类定义的时候描述某种数据类型，集合用的就是这样      
2.泛型接口      
与泛型类的使用基本一致，子类实现接口时必须添加泛型      
3.泛型方法      
方法调用时传参数，方法的泛型与类无关，带有泛型的方法可以不放在带有泛型的类中    
4.高级泛型  规范边界    extends    super
  
泛型不能使用基本类型---如想要使用基本类型，需要使用其对应的包装类   
```java
ArrayList<Integer> list = new ArrayList<Integer>();
list.add(10);
```



