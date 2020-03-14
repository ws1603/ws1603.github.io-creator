---
title: "IO相关"
date: 2019-11-22T15:18:41+08:00
draft: false
---


I/O相关     输入/输出   流(数据流动)

数据流动的方向  读数据(输入Input)   写数据(输出output)  
文件流  字符流  数据流  对象流  网络流...

1.什么叫文件    
    一种的电脑的存储形式    
    文件有不同的格式 .txt   .doc    .ppt    .mp4    .jpg    .rar    ...
    文件夹?-----目录路径    
    File------>与电脑上的文件或文件夹产生一一对应的映射关系     
    File是一个类    
    1.java.io包中     
    2.文件或目录路径名的抽象表示形式  
    3.File与真实硬盘中的文件或文件夹 不是一个东西     
    File是在内存中的一个对象<---映射--->硬盘上的文件或文件夹
    4.File类中的常用方法
    canRead()    canWrite()     isHidden()      isFile()    isDirectory()  
    length()获取文件中字节的个数    
    lastModified()获取文件最后的修改时间--->毫秒值      
    String path = getAbsolutePath()获取文件的绝对路径   
        绝对路径<----->相对路径 
        绝对路径可以通过完整的字符串 定位盘符 文件夹 文件   
        相对路径没有盘符的写法      当前工程(项目)所在的位置找寻  
    String name = getName()获取文件的名字   
    boolean = createNewFile()创建新文件   
    boolean = mkdir()创建新文件夹 外层没有 不能创建   
    boolean = mkdirs()创建新的文件夹 外层没有 可以自动创建    
    String pname = getParent()获取当前file的父亲file名字   
    File file = getParentFile()获取当前file的父亲file对象   
    String[] names = list()获取当前file的所有儿子名字   
    File[] files = listFile()获取当前file的所有儿子对象 
        数组对象为空    证明当前的file是一个文件    
        数组对象不为空  证明当前的file是一个文件夹  
        数组对象的长度不为0 证明当前的file是一个不为空的文件夹 文件夹内有元素   
    boolean = delete()删除文件或空的文件夹 不能删除带元素的文件夹   



2.什么叫文件流 做什么   
    读取文件中的内容        项文件中写内容  
    文件输入流          文件输出流  
    字节型文件输入流        字节型文件输出流    
    字符型文件输入流        字符型文件输出流 