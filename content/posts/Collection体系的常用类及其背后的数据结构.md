---
title: "Collection体系的常用类及其背后的数据结构"
date: 2019-11-27T22:55:04+08:00
draft: false
---
   
```
集合    
    Collection 存储的都是value对象  
        List 有序可重复 
        Set 无序无重复  
    Map 存储的是key-value形式的对象，key无序无重复，value无序可重复 

    有序：添加进去的元素与取得元素的顺序一致。注意不是集合自己的顺序    
    重复：两个对象元素一致  
```


#### 集合框架的接口      
![](集合框架的接口.jpg)     

#### 集合框架中的类      
![](集合框架中的类.jpg)     




### 常见的集合       

#### List接口    
``ArrayList``   
一种可以动态增长和缩减的索引队列，其底层为一个动态数组，适合随机访问不适合插入删除，初始容量为10，可以自动扩容。  

``LinkedList``  
一种可以在任何位置进行高效地插入和删除的有序队列，为一个双向链表，适合插入和删除不适合随机访问。        

``Vector``  
与ArrayList相似，是一个动态数组，操作与ArrayList相同，不同的是Vector是线程同步的(synchronized)，安全性高，效率低。
      
`Stack`     
栈，继承自Vector，特性是后进先出。

#### Set接口        
``HashSet``         
一种没有重复元素的集合，是线程非同步的，底层为HashMap。     
无重复原则:通过equals()和HashCode()判断，判断重复则拒绝存入。       

``TreeSet``     
一种有序的集合，基于TreeMap实现，其排序为自然排序或根据compareTo排序，当存入自己写的类时需要先实现compareTo接口。         

#### Map接口     
``HashMap``     
存储键值对(key-value)映射的散列表，不同的key可以存储相同的value，key若有相同则将原有的value覆盖而不是拒绝存入(跟Set刚好相反)。

``TreeMap``     
存储键值对有序排列的集合，基于红黑树实现，根据自然排序或compareTo排序。        
      




