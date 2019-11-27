---
title: "工具类5 String常用方法"
date: 2019-11-10T09:44:21+08:00
draft: false
---

        boolean = equals(Object obj);//继承自Object,equals默认比较地址,被String重写了,比较两个字符串内容

        int = hashCode();//继承自Object,被String重写,将当前字符串的每一个cahr元素拆开 乘以31求和

        int = compareTo(String str);//实现自Comparable接口，按字典(Unicode编码)索引顺序比较
        str1.compareTo(str2);
        //按照两个字符串长度较短的那个作为比较循环的次数
        //挨个比较元素 str1[i]-str2[i]不为0就返回
        //如果循环过后发现所有的字符都一样 len1-len2
        //返回0表示两个字符相等

        String = toString();//继承自Object,被String重写了,不在输出 类名@hashCode,而是字符串中的字面值

        char = charAt(int index);//"abc" 0->'a'
        //返回给定index对应位置的那个char值

        int = codePointAt(int index);//"abc" 0->97
        //返回给定index对应位置的那个char所对应的code码

        int = length();//返回字符串的长度(其实就是底层char[] value属性的长度)
        注意:区别数组length是属性 String的length()为方法 集合size()为方法

        String = concat(String);//将给定的字符串拼接在当前字符串之后
        //此处要注意String对象的不可变特性
        String str = "ab";
        str = str.concat("c");//将str重新赋值才能得到"abc"
        //concat拼接字符串比+拼接性能高

        String str = "a"+"b"+"c"+"d";//数学计算  拼接符号
        system.out.println(str);//过程中产生了几个String对象?  字符串常量池7个
        //对象1->value[] a  "a"
        //对象2->value[] b  "b"
        //对象3->value[] {a,b}  "ab"
        //对象4->value[] c  "c"
        //对象5->value[] {a,b,c}   "abc"
        //对象6->value[] d  "d"
        //对象7->value[] {a,b,c,d}  "abcd"

        boolean = contains(CharSequence s);//判断给定的s是否在字符串中存在

        starstWith(String prefix);
        endsWith(String suffix);
        //判断次字符串是否以xx开头/结尾

        byte[] = getBytes();
        char[] = toCharArray();
        //将当前子字符串转化成数组

        int = indexOf(int/String str[,int fromIndex]);//四个方法重载
        //找寻给定的元素在字符串中第一次初选的索引位置,若字符串不存在则返回-1
        int = lastIndexOf(int/String str[,int fronIndex]);
        //找寻给定的元素在字符串中最后一次出现的索引位置,若不存在则返回-1

        boolean = isEmpty();
        //判断当前字符串是否为空字符串(length是否为0)
        //注意与null之间的区别

        replace(target,replacement);
        replaceAll(target,replacement);//前两个所有出现的都能换
        replaceFirst(target,replacement);//第三个只换第一次出现的
        //将给定的字符串替换成另外的字符串

        String[] = split(String regex[,int limit]);//按照给定的表达式将原来的字符串拆分开 "a-b-c-d" "-"

        String = substring(int beginIndex[,int endIndex]); //[beginIndex,endIndex)
        //将当前的字符串截取一部分,若ebdIndex不写 则默认到字符串最后

        String = tpUpperCase();
        String = tpLowerCase();
        //将全部字符串转换成大写/小写

        String = trim();
        //去掉字符串前后多余的空格

        boolean = matches(String regex);//匹配正则表达式
        //regular expression 正则表达式
        
