---
title: "工具类9 LinkedList+Vector+Stack+Queue"
date: 2019-11-10T09:46:38+08:00
draft: false
---

### Vector类    
1.java.util包   
2.是ArrayList集合的早期版本 (StringBuffer早期，Stringbuilder后来)   
    Vector底层也是利用(动态)数组的形式存储
    Vector是线程同步的(synchronized)，安全性高，效率低    
3.扩容机制与ArrayList不同，默认是扩容2倍    (ArrayList是1.5)，可以通过构造方式创建对象修改这一机制  
4.构造方法  
5.常用方法  


### Stack类 栈      
1.java.util包   
2.构造方法只有一个无参数
3.除了继承自Vector类的方法外还有几个特殊方法  
```
    push(E e) 将某一个元素压如栈顶     
    E = pop() 将某一个元素从栈顶取出并删掉(E = remove())
    E = peek() 查看栈顶的一个元素,不删除
    boolean = empty() 判断栈顶元素是否为空
    int = search() 查找给定的元素在栈中的位置   
```     

### Queue接口   
1.java.util     
通常子类LinkedList,ArratDeque   
2.通常无参数构造方法创建    
3.一般方法  
    add()   
    element()--->get()  
    remove()    

    boolean = offer(E e);//相当于add,可以处理异常
    E = peek();//相当于 element方法  
    E = poll();//剪短,相当于remove()    



LinkedList      
List的子类，Queue的子类     
1.java.uitl包   自己封装过的LinkedBox   
2.底层使用双向链表的数据结构形式来存储，更适合插入和删除不适合遍历轮询      
3.构建对象  
    无参数构造方法，单参数的构造方法(collection)
    ArrayList<String> array = new ArrayList();
    LinkedList<String> linked = new LinkedList(array);

4.常用的方法    
    增删改查 add() remove() set() get() size() offer() poll() peek()    
    手册中提供的其他常用方法    
    addAll() addFirst() addLast() clear() contain() element() getFirst() getLast() indexOf() lastIndex()...     
    

    



