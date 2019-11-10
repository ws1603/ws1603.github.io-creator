---
title: "Java、Maven的包管理"
date: 2019-10-29T11:53:59+08:00
draft: false
---

## Java的包管理机制
包管理的本质就是告诉JVM如何找到所需的第三方类库，以及成功地解决其中的冲突问题。

JVM的包管理机制非常简单：

* JVM一辈子只干一件事，读字节码文件，执行字节码。
* 每当JVM看到一个全限定类名，就尝试从classpath中加载。

要找一个类就在-classpath所指定的jar包(一堆类的压缩包)或文件夹中按照全限定类名(目录层级)挨个查找，找到为止，找不到就会丢出一个ClassNotFoundExeption。

当多个同名类同时出现在classpath中，JVM就``只会加载放在前面的类``，导致了放在后面的想要使用的类得不到使用，这就是Classpath hell。

由于传递性依赖，我们依赖的类可能还依赖类其他的类，classpath中会将所有依赖的类引用进来，这就导致classpath非常长，要解决Classpath hell，人工寻找classpath中的同名类非常困难，这就需要借助自动化工具来实现。

## Maven的包管理机制

Maven的仓库

* Maven的中央仓库：按照一定的约定存储包
* Maven的本地仓库：默认位于~/.m2,下载的第三方包放在这里进行缓存

Maven按照约定为所有的包编号：groupId/artifactId/version，方便检索。

当我们需要一个包时，Maven按照我们给出的编号，去仓库查找这个包，并根据依赖找到所有的包下载到本地，然后拼接成一个很长的classpath，以供JVM查找加载。

作为依赖性的自动管理工具，Maven绝对不允许最终的classpath出现同名不同版本的jar包，其解决依赖冲突的原则是：``距离本项目最近的胜出`` 。
但这一原则并不能总是让我们得到需要的包，当看到这些异常的的时候，说明Maven解决不了这个包冲突，需要靠手动解决。

    AbstractMethodError
    NoClassDefFoundError
    ClassNotFoundException
    LinkageError


## 包管理冲突的解决

以运行一个程序得到如下异常为例:

![](/post2-1.jpg)

首先对冲突的包进行定位，可以从Maven的Dependency中找到对应的两个包，可以看到此项目中只有两个``org.springframework:spring-web``的包，5.1.8版本不受其他包所依赖，距离本项目较4.3.6版本更近，所以Maven是采用了5.1.8版本，所以我们可以很快地定位到运行项目缺失的类方法是在4.3.6版本中。

![](/post2-2.jpg)

但是，如果这里发生冲突的包不止有两个呢？这时，就需要到Maven的中央仓库去查看源码进行定位了。

定位到了发生冲突的包，那么接下来就该解决问题了。
### 方法一 在最近处添加一个新的包
在pom.xml文件中引入一个4.3.6版本的dependency即可

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-web</artifactId>
        <version>4.3.6.RELEASE</version>
        <scope>compile</scope>
    </dependency>

### 方法二 消除与其冲突的包
如果5.1.8版本包不被其他包所依赖，直接在pom.xml文件中将其dependency删去或者注释掉即可；如果5.1.8版本包受其他包所依赖，可在上级包的dependency中添加如下内容即可将5.1.8版本包从其中排除不受依赖。

    <exclusions>
                <exclusion>
                <groupId>org.springframework</groupId>
                <artifactId>spring-web</artifactId>
                </exclusion>
    </exclusions>
    
    


