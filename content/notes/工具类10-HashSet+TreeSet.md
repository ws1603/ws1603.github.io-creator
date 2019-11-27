---
title: "工具类10 HashSet+TreeSet"
date: 2019-11-10T09:47:05+08:00
draft: false
---


1.集合的应用    
    集合就是一个小容器，增删改查

2.集合使用的情况    
    各集合的特点    

3.底层原理  
    数据结构的存储方式  

4.自己尝试实现  



### Set   
1.具体的实现类  
    HashSet 
    TreeSet 

2.基本的使用    
3.无序 无重复   
    无序：我们使用集合存放元素的顺序 集合内取出来的顺序不一样       
    集合本身有自己的算法排布顺序 hash算法

#### HashSet (底层为HashMap)    
1.java.util     
2.如何构造方法 无参数 有参数    
3.集合容器的基本使用  

    增删改查    
    boolean = add(value)  addAll(collection c)    retainAll   removeAll   boolean = remove(Object)  
    没有修改方法    
    可以使用增强for进行集合遍历，也可以用迭代器     
    iterator() 获取一个迭代器对象   
        Iterator it = set.iterator();//Iterator接口 多态的效果 
        //判断下一个位置是否有元素  
        while(it.hashNext()){
            String value = it.next();
            System.out.println(value);
        }
    size()
     
4.无重复原则    
    equals() 和 HashCode()判断重复   

```java
public class Main{
    
    public static void main(String[] args) {
        HashSet<String> stringSet = new HashSet();
        stringSet.add("a");
        stringSet.add("a");
        stringSet.add("a");
        System.out.println(stringSet.size());//输出1
        HashSet<Person> personSet = new HashSet();
        personSet.add(new Person("b"));
        personSet.add(new Person("b"));
        personSet.add(new Person("b"));
        System.out.println(personSet.size());//输出3
        //String类重写了hashCode()和equals()方法,所以可根据值相同判断对象相同
        //Person类没有重写了hashCode()和equals()方法则不能根据值相同判断对象相同
    }
}
class Person {
    private String name;
    Person(String a) {
        this.name=a;
    }
}
```
重写Person类的``hashCode()``和``equals()``方法  
```java
public class Main{
    
    public static void main(String[] args) {
        HashSet<String> stringSet = new HashSet();
        stringSet.add("a");
        stringSet.add("a");
        stringSet.add("a");
        System.out.println(stringSet.size());//输出1
        HashSet<Person> personSet = new HashSet();
        personSet.add(new Person("b"));
        personSet.add(new Person("b"));
        personSet.add(new Person("b"));
        System.out.println(personSet.size());//输出1
    }
}
class Person {
    private String name;
    Person(String a) {
        this.name = a;
    }

    @Override
    public int hashCode(){
        return this.name.hashCode();
    }
   @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj instanceof Person){
            Person p = (Person)obj;
           if(this.name.equals(p.name)){
               return true;
           }
        }
     return false;
    }
}
```
发现重复的元素拒绝存入，存储的是第一个 
```java
public class Main{
    
    public static void main(String[] args) {
        HashSet<Person> personSet = new HashSet();
        personSet.add(new Person("b"，1));
        personSet.add(new Person("b"，2));
        personSet.add(new Person("b"，3));
       System.out.println(personSet.iterator().next().getNum());//输出为1，证明存入的是第一个元素
    }
}
class Person {
    private String name;
    private int testNum;//记录号码
    
    Person(String a,int t) {
        this.name = a;
        this.testNum = t; 
    }
    
    public int getNum(){
        return testNum;
    }

    @Override
    public int hashCode(){
        return this.name.hashCode();
    }
   @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj instanceof Person){
            Person p = (Person)obj;
           if(this.name.equals(p.name)){
               return true;
           }
        }
     return false;
    }
```



#### TreeSet (TreeMap二叉树 利用Node)   
1.无参无重复 java.util    
2.无参无构造方法 带Collection构造方法 
3.基本常用方法    
    add(E e)    iterator()  remove(E e) 没有修改    size
4.无重复规则
    treeSet集合本身有顺序 我们指的无序是存入和取出来的不一致
    compareTo--->String类 按照字母的自然顺序排布(Unicode)
    如果想要把自己写的类型 比如Person对象存入TreeSet集合里，不能随意的储存，需要把自己写的类先实现Comparable接口，否则会产生异常

```java

public class Main{
    
    public static void main(String[] args{
   TreeSet<Person> pts = new TreeSet();
    pts.add(new Person("a",1));
    pts.add(new Person("a",2));
    pts.add(new Person("a",3));
System.out.println(pts.size());//输出为1
    }
}
class Person implements Comparable<Person>{
    private String name;
    private int testNum;
    
    Person(String a,int t) {
        this.name = a;
        this.testNum = t; 
    }
    
    public int getNum(){
        return testNum;
    }

    @Override
    public int hashCode(){
        return this.name.hashCode();
    }
   @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj instanceof Person){
            Person p = (Person)obj;
           if(this.name.equals(p.name)){
               return true;
           }
        }
     return false;
    }
//根据需要重写compareTo方法
    public int compareTo(Person o){
        return this.compareTo(0.name);
    }
```
