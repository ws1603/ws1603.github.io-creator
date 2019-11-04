---
title: "如何使用Hugo搭建个人博客"
date: 2019-10-28T10:55:57+08:00
draft: false
---

Hugo是由Go语言实现的静态网站生成器，可以快速搭建一套静态展示类型的网站。并且自带高性能服务器，热部署等特性，是不想多花精力又想构建个人博客的极佳选择。本文将介绍如何使用Hugo搭建个人博客及如何发布到Github并生成Github pages。



## 快速搭建博客
 进入[Hugo 官网](https://gohugo.io/)，点击Quick Start快速开始。
### 安装Hugo
#### Windows安装方式
* 去[Hugo releases页面](https://gohugo.io/categories/releases)下载hugo_xxx_Windows-64bit.zip
* 解压，把hugo.exe放到D:\Software\hugo\hugo.exe
* 把D:\Software\hugo加到PATH
* 重启终端，运行`hugo version` 查看版本

#### Mac安装方式
* brew install hugo
* hugo version

### 建立新站点
输入命令  
```
hugo new site github.io-creator  
```  
在当前文件夹中创建一个新的Hugo网站github.io-creator。

### 添加主题
依次输入下面四条命令，下载并使用主题ananke。  
```
cd github.io-creator  
git init  
git submodule add https://github.com/budparr/gohugo-theme-ananke.git themes/ananke      
echo 'theme = "ananke"' >> config.toml
```    
更换主题可到Hugo的[官方网站](https://themes.gohugo.io/)浏览下载。

### 创建文章 
输入命令
```
hugo new posts/我的博客.md  
```      
Hugo会在content目录下创建post目录，在post目录下创建scala-learning-pattern-matching.md文件。之后打开md文件，里面已经有些内容：     
![](/post1-1.jpg)   
这里的的draft默认状态为true,需要修改为false才能发布。 

### 查看生成的文章
草稿状态下 输入命令``hugo sever -D``    
非草稿状态下 输入``hugo sever``     
可得到如下结果：  

![](/post1-2.jpg)       
在浏览器中打开网址即可查看生成的博客页面。

### 更换主题
进入Hugo[主题官网](https://themes.gohugo.io/)，浏览并下载主题。    
以下载hugo-goa主题为例，将hugo-goa主题下载到themes目录下。
```
cd themes
git clone https://github.com/shenoybr/hugo-goa
```
接下来是应用主题，hugo的全局配置文件是项目根目录下的config.toml，一般来说每个主题样式都有自己独特的配置项及功能，因此config.toml推荐使用所选主题自带的来覆盖本地。每个主题一般会在自己项目的exampleSite目录中留有最佳实践，该主题的配置模板也在里面。
```
cd myblog/thems/beautifulhugo/exampleSite
cp config.toml ../../../
```
覆盖完后查看config.toml文件，内容非常多，但只需修改其中通用的几项，详情可以查看项目文档。  

### 创建静态页面
回到github.io-creator目录下执行命令
```
hugo
```
一个``public``目录将会被创建，我们需再手动创建一个``.gitignore``文件，将``/public/``写入其中保存，这样就可使git操作忽略public文件。

### 发布到GitHub
Hugo将编译所有文件并输出到public目录，需要在github上创建repository，名字就是``<用户名>.github.io``，创建完后，返回本地命令行，进入public目录，执行以下命令：
```
git init
git add .
git commit -m "Initial commit."
git remote add origin git@github.com:<用户名>/<用户名>.github.io.git
git push -u origin master
```
稍等片刻后，打开<你的用户名>.github.io网址，就可以看到你的个人网站了。
