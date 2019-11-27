---
title: "工具类11 HashMap"
date: 2019-11-10T09:47:22+08:00
draft: false
---


Map 映射 通过某一个key可以直接定位到一个value值 

存储方式以 键值对 存储 key-value    
key无序无重复 value无序可重复   
key无序还是一样，指的是存入顺序与取得顺序不一致     
key无重复指的是 元素不能一致        

1.map基本使用   
    HashMap 
    TreeMap 
    Properties(读取文件中的信息)

HashMap 
1.包java.util   
2.如何创建对象  
3.基本方法  
    增删改查    
    增put(key,value) 存放一组映射关系 key-value   
        1.key存储的顺序与取得的顺序不同     
        2.不同的key可以存储相同的value    
        3.key若有相同的，则将原有的value覆盖而不是拒绝存入(跟set刚好相反)

    删E = remove(key)
    改put(key,value1) put(key,value2)
        replace(key,newValue)   
    查E = get(key)  
    遍历map集合？   key值不一定一样 
    ```
        获取到所有的key 便利key 通过key获取value
        //获取mp集合的所有key   
        Set<k> keys = map.keySet();
        //获取entry 
        Set<Entry> = entrySet();
        //通过迭代器遍历keys    
        Itetator<K> it = keys.iterator();
        while(it.hasNext()){
            K key = it.next();
            V value = map.get(key); 
        }
    ```
    size();
    
4.除了上述的常用的方法外，其他API中提供的方法   
```
    clear() 
    containsKey(key) 
    containsValue(value) 
    getOrDefault(key,defaultValue);//如果key存在就返回对应的value,若没有找到就返回默认值    
    isEmpty()
    putAll(map) 
    putOfAbsent(key,value);//如果key不存在才会向集合内添加，如果存在就不添加    
```

5.map集合在什么情况下使用   
    1.想要存储一组元素    
        数组or集合 如果存储的元素以后长度不变就用数组，如果以后长度不确定用集合     
    2.如果发现长度以后不确定--->集合    
 ```
        List Set Map    
        List家族有序的 存储有顺序用这个 
            ArrayList 更适合遍历轮询
            LinkedList 更适合插入和删除 
            Stack LIFO  
        Set家族无重复 存储元素希望启动去掉重复元素用这个    
            Hash    
            Tree 希望存进去的元素自动去重复，同时哈能自动排序    
        Map家族k-v 通过唯一的k快速寻找v用这个   
            Hash 性能更高   
            Tree 希望存进去的元素key自动排序    
```


6.登录小流程
```java
    设计一个方法 用来登录认证 一维数组
   
    private String[] userBox = new String[]{"张三","李四","王五"};
    private int[] passwordBOX = new int[]{111,222,333};

    public String loginForArray(String name,String password){
       
        for(int i=0;i<userBox.length;i++){
            if(userBox[i].equals(name)){
                if(passwordBox[i]==Integer.parseInt(password)){
                    return "登录成功";
                }
             break;
            }
        }
        return "用户名或密码错误";
    }

```

```java
//设计一个方法，用来登录认证---ArrayList    
private ArrayList<String> userBox = new ArrayList();
{
    userBox.add("张三-111");
    userBox.add("李四-222");
    userBox.add("王五-333");
}
public String loginForList(String name,String password){
    for(int i=0;i<userBox.size();i++){
        String[] value = userBox.get(i).split("-");//一个人的信息 v[0] v[1]
        if(value[0].equals(name)){
            if(value[1].equals(password)){
                return "登录成功";
            }
            break;
        }
    }
    return "用户名或密码错误";
}
```

```java
//设计一个方法 用来登录认证----Set
private HashSet<String> userBox = new HashSet();
{
    userBox.add("张三-111");
    userBox.add("李四-222");
    userBox.add("王五-333");
}
public String loginForSet(String name,String password){
    Iterator<String> it =new Iterator();
    while(it.hasNext()){
        String[] value = it.next().split("-");
        if(value[0].equals(name)){
            if(value[1].equals(password)){
                return "登录成功";
            }
        }
        break;
    }
return "用户名或密码错误";
}
```


```java
//设计一个方法 用来登录认证---Map   
private HashMap<String, Integer> userBox = new HashMap();
{
    userBox.put("张三",111);
    userBox.put("李四",222);
    userBox.put("王五",333);   
} 
public String loginForMap(String name,String password){
    Integer realPassword = userBox.get(name);
    if(realPassword!=null){//人名存在
        if(realPassword.equals(Integer.parseInt(password))){
            return "登录成功";
        }
    }
return "用户名或密码错误";
}
```

7.HashMap底层的数据结构存储     散列表的形式    数组+链表   
    Person对象存入HashMap中？可以   

        如果不重写hashCode 不同的对象能不能产生相同的hashCode值
        hashCode方法---->不同的对象 可以产生相同的hashCode码的  
        不同的hashCode码--->不同的对象  
        
