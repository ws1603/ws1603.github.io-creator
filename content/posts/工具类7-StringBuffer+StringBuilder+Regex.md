---
title: "工具类7 StringBuffer+StringBuilder+Regex"
date: 2019-11-10T09:45:24+08:00
draft: false
---

字符串相关的类  java.lang包     
#### String  
* 实现接口``Serializable``,``CharSequence``,``Comparable``    
* 非常特殊的类 可以像常量一样创建对象  ``String str="abc";``   
* 内存存储 "abc"对象 ``char[] value``     
* String不可变特性    ``private final char[] value;``     
* 频繁的修改其内容的时候，性能很不好      


#### StringBuffer/StringBuilder   
1. 所属的包 java.lang包  

2. 默认继承AbstractStringBuilder 间接继承Object 实现接口 ``Serializable``,``CharSequence``,``Appendable``  
StringBuffer/StringBuilder 没有``compareTo``方法    
StringBuffer/StringBuilder含有一个String没有的方法``append();`` 拼接    

3. 特性      
    可变字符串  ``char[] value``， 动态扩容  

4. 对象的构建   

        //无参数构造方法 构建一个默认长度16个空间的对象
        StringBuilder builder = new StringBuilder();

        //利用给定的参数 构建一个自定义长度空间对象 char[]
        StringBuilder builder = new StringBuilder(20);

        //利用带String参数的构造方法 默认数组长度+16个
        StringBuilder builder = new StringBuilder("abc");

5. StringBuilder中常用的方法 
         
        append();//最主要的方法,频繁拼接字符串的时候使用此方法，提高性能

        ensureCapacity(int minimumCapacity);//确保底层容量够用

        capacity();//字符串底层char[]的容量
        length();//字符串有效元素个数
        setLength();//设置字符串有效元素个数

        char = charAt(int index);
        int = codePointAt(int index);

        String = substring(int start[,int end]);//注意需要接受返回值，才能看见截取出来的新字符串效果

        delete(int start[,int end]);//StringBuilder类中独有的方法，String类没有
        //将start到end之间的字符串删掉，不用接受返回值就能看到效果啦

        StringBuilder = deleteCharAt(int index);//String类中没有的方法
        //将给定index位置的某一字符删除掉
        
        insert(int index,value);//将给定的value插入在index位置之上

        replace(int start,int end,String str);//将start和end之间的内容替换成str

        setCharAt(int index,char value);//将index位置的字符改成给定的value

        toString();//将StringBuilder对象构建成一个String对象

        trimToSize();//将数组中无用的容量去掉，变成length长度的数组


6. #### String家族笔试中经常容易考察的知识点
   
   1. String所属的包 继承关系 实现接口    
      java.lang  继承Object  接口Serializable,CharSequence,Comparable
   2. String构建方式        
      常量 构造方法     
   3. String对象内存结构        
      字符串常量区 new 堆内存对象   
      == equals区别  
      "a"+"b"+"c"
   4. Sreing不可变特性      
      长度及内容
   5. String中的常用方法-----与StringBuilder的区别        
      concat(); toUpperCase();
   6. String和StringBuilder区别 | String和StringBuffer区别          
      1. String 不可变字符串   
             JDK 1.0    
             有一个接口Comparable   
             不可变体现在长度及内容   
             有一些方法另一个没有 concat comparaTo toUpperCase      
      2. StringBuilder可变字符串   
             JDK 1.5    
             有一个接口Appendable   
             可变字符串 没有final修饰 底层可以进行数组扩容  
             有一些方法String没有 append insert delete reverse  

   7. StringBuffer和StringBuilder的不同     
        StringBuffer早期版本1.0     
        StringBuilder后来的版本1.5    
        早期版本  线程同步  安全性较高  执行效率相对较低        
        后期版本  线程非同步  安全性比较低  执行效率相对较高


#### 总结       
1. StringBuilder类不一定需要，是为了避免String频繁拼接修改字符串信息的时候采用的。底层数组是可变的，提高了性能      
2. 常用方法  
    与String类不同的独有方法:    
    append()  insert()  delete()  deleteCharAt()  reverse()   
    与String类相同的方法:        
    length()  charAt()  codePointAt()  indexOf()  lastIndexOf()  replace() 名字相同，用法不同    

regular expression 正则表达式   
一个带有一定规律的表达式，匹配字符串格式的
正则表达式通常的作用如下：  
1.字符串的格式校验      
String类中提供的一个方法 ``boolean = str.matches("regex")``

        str.matches("a[abc]");//第一个字母是a,第二个字母是abc中其中一个？
        str.matches("a[^abc]");//第一个字母是a,第二个字母是非abc任意的其它一个？    
        str.matches("a[a-zA-Z]");//第一个是a,第二个是a到z或者A到Z?
        str.matches("[a-z&&[^bc]]");a到z都可以但不是b和c?

        如下的所有都用来描述字符信息：
        . 代表任意一个字符
        | 或者
        \d digit数字 [0-9]
        \D 非数字 [^0-9]
        \s space留白 一个空格 一个回车 一个换行...
        \S 非留白
        \w word单词 [0-9A-Za-z] 数字或字母都可以
        \W 非单词 [^0-9A-Za-z]

        如下的所有都用来描述字符出现的次数
        ? 0-1次    [0-9]?
        * 0-n次 
        + 1-n次 
        {n} 固定n次  
        {n,} 至少出现n次
        {m，n} m-n次    


2.字符串的拆分及替换    
String类中提供的方法 replace  spilt  


3.字符串的查找      
Pattern模式  Matcher匹配器   

    //所有的字符串中寻找满足如下规则的信息  邮政编码
    String str = "123456abc123456abc123456abc";

    //1.利用Pattern类创建一个模式   理解为是一个正则表达式对象
    Pattern pattern = Pattern.compile("\\d{6}");//邮编
    //2.需要提供一个字符串
    //3.利用Pattern模式对象创建一个匹配器
    Matcher matcher = pattern.matcher(str);
    4.找寻字符串中出现满足上述格式的字串
    while(matcher.fand()){
        System.out.println(matcher.group());//找到满足字符串格式的那一串文字
    }



