---
title: "HTML常用标签"
date: 2020-3-14T11:53:59+08:00
draft: false
---
## a 标签

#### 属性

- href
- target
- download
- rel=noopener

#### 作用

- 跳转外部页面
- 跳转内部锚点
- 跳转到邮箱或电话等

### a 的 href 的取值

#### 网址

- https://google.com
- http://google.com
- //google.com

#### 路径

- /a/b/c 以及 a/b/c
- index.html 以及 ./index.html

#### 伪协议

- javascript:代码;
- mailto:邮箱
- tel:手机号
  (注意逗号和分号)

#### id

- href=#xxx

注：href="javascript:;" 什么都不做的伪协议，点击后页面不会刷新，也不会回到顶部

href="#xxx" 跳转到指定 id 的标签

### a 的 target 的取值

#### 内置名字

- \_blank 在新的页面打开
- \_top 最顶层页面打开
- \_parent 在父级页面打开
- \_self 默认值，在当前页面打开

#### 程序员命名

- window 的 name
- iframe 的 name

### a 的 download

#### 作用

- 不是打开页面，而是下载页面

#### 问题

- 不是所有浏览器都支持，尤其是手机浏览器不可能支持

## table 标签

#### 相关的 table

- table
- thead
- tbody
- tfoot
- tr
- td
- th

table 标签里面只能使用三个标签 thead tbody tfoot  
tr:table row  
th:table head  
td:table data

#### 相关的样式

- table-layout
- border-collapse
- border-spacing

![table标签](table标签.jpg)
![table标签2](table标签2.jpg)

## img标签
#### 作用
* 发出get请求，展示一张图片
  
#### 属性
* alt/height/width/src

#### 事件
* onload/onerror

#### 响应式
* max-with:100%

#### 可替换元素
* 可替换元素就是浏览器根据元素的标签和属性，来决定元素的具体显示内容。览器会根据<img>标签的src属性的值来读取图片信息并显示出来

alt  图片加载失败时显示字。     

宽度和高度只写一个时另一个会自适应，如果两个都写了可能会导致图片变形(这是不应该发生的)  

![img标签](img标签.jpg)        
图片加载成功显示放入的图片，加载失败显示默认的加载失败图片。        

## form标签
#### 作用
* 发get或post请求，然后刷新页面

#### 属性
* action/autocomplete/method/target

#### 事件
* onsubmit

![form标签](form标签.jpg)       
autocomplete设为on时输入框会自动给出建议    

![form标签2](form标签2.jpg)     
target属性与a标签的target同。     

intput submit 和 button submit 的区别：input submit中不能再有其他的内容，button submit中可以有内容和标签。      

一个form表单必须要有一个含有type等于submit的东西(input ,button)才能提交，不写默认是submit。      

## input标签
#### 作用
* 让用户输入内容

#### 属性
* 类型 type:button/checkbox/email/file/hidden/number/password/radio/search/submit/tel/text
* 其他 name/autofocus/checked/disabled/maxlength/pattern/value/placeholder

#### 事件
* onchange/fucus/onblur

#### 验证器
* HTML5新增功能      

![input标签](input标签.jpg)     
type默认为text      
radio为选择，name相同时只能选一个       
checkbox为多选框，name相同为同一组      
hidden是给js自动填一些数字字符串用的        

![input标签](input标签2.jpg)    
textarea 输入区    
resize为none不允许用户拖动大小      

![input标签](input标签3.jpg)   
select     选择框    value为空时为框中默认值

![input标签](input标签4.jpg)   
自带的验证    设为required后为必填项   

### 其他输入标签
#### 标签
* select + option 
* textarea
* label

#### 注意事项
* 一般不监听input的click事件
* form里面的input要有name
* form里面要放一个type=submit才能出发submit事件

