---
title: "IO之文件夹遍历删除"
date: 2019-11-22T16:22:05+08:00
draft: false
---


1.文件夹的遍历-------需要一个递归   
    循环 在方法中是正常执行的 只有一个方法执行空间  
    递归 调用时产生很多一样的临时空间 消耗内存  
2.文件夹的删除  
3.文件夹的路径(找父目录)

```java
遍历文件夹输出路径
public void showFile(File file){
    //获取file的子元素 files==null是个文件 files!=null是个文件夹 files.length!=0是个带元素的文件夹
    File[] files = file.listFiles();
    if(files!=null && files.length!=0){
        for(File f:files){
            this.showFile(f);
        }
    }
    System.out.println("file.getAbsolutePath()");
} 
```
```java
设计一个方法，删除文件夹
public viod delete(File file){
    //判断file不是一个空文件夹
    File[] files = file.listFiles();
    if(files!=null && files.length!=0){
        for(File f:files){
            this.deleteFile(f);
        }
    }
    //删除file(file是个文件夹或file是一个空文件夹)
    file.delete()
}
```

文件流来完成------>读取问价内容 将内容写入文件      
4.文件的复制    
5.文件的加密    