---
title: "Java、Maven的包管理"
date: 2019-10-29T11:53:59+08:00
draft: false
---

## Java的包管理机制
JVM的工作流程：执行一个类的字节码，碰到了新的类就去加载它




## Maven的包管理机制





## 包管理冲突的解决

以运行一个程序得到如下异常为例:

![](/post2-1.jpg)

首先对冲突的包进行定位，可以从Maven的Dependency中找到对应的两个包，可以看到此项目中只有两个``org.springframework:spring-web``的包，5.18版本不受其他包所依赖，距离本项目较4.36版本更近，所以Maven是采用了5.18版本，所以我们可以很快地定位到运行项目缺失的类方法是在4.36版本中。
![](/post2-2.jpg)

但是，如果这里发生冲突的包不止有两个呢？这时，我们就需要到Maven的中央仓库去查看源码进行定位。

定位到了发生冲突的包，那么接下来就该解决问题了。
### 方法一 提高优先级
在pom.xml文件中引入一个4.36版本的dependency即可

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-web</artifactId>
        <version>4.3.6.RELEASE</version>
        <scope>compile</scope>
    </dependency>

### 方法二 消除与其冲突的包
如果5.18版本包不被其他包所依赖，直接在pom.xml文件中将其dependency删去或者注释掉即可；如果5.18版本包受其他包所依赖，可在上级包的dependency中添加如下内容即可将5.18版本包从其中排除不受依赖。

    <exclusions>
                <exclusion>
                <groupId>org.springframework</groupId>
                <artifactId>spring-web</artifactId>
                </exclusion>
    </exclusions>
    
    


