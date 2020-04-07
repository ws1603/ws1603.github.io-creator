---
title: "踩坑记录"
date: 2020-04-02T20:29:52+08:00
draft: false
---

#### WMVirtualbox/Docker     
问题描述：      
```
Docker无法切换到linux containers。     
```      
如何解决：          
```
    发现windows的hyper-V与WMVirtuabox的虚拟化相冲突，使用Docker需要开启hyper-V，在bios的虚拟化启用后需要在windows开启hyper-V和hypervisorlaunchtype。        
    1.Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Hyper-V –All，
        Disable-WindowsOptionalFeature -Online -FeatureName Microsoft-Hyper-V-All。       
    2.管理员身份打开提示符，输入命令bcdedit /set hypervisorlaunchtype auto 开启，
        bcdedit /set hypervisorlaunchtype off 关闭，重启电脑。
```

#### Redis  
问题描述：
```
使用Docker开启的Redis容器在使用时报错不能反序列化，某某类找不到。
```
如何解决：
```
初学Redis，发现上一个项目也是使用的此Redis容器，两个项目中有一个相同类名的类。猜测是Redis中存了上一个项目中的类，在此项目中遇到了同名的类后会就拒绝存入，在使用到此类时发现类的数据与原先存入的类不相符，于是报错。
在Docker中重新开启一个Redis容器使用，问题得以解决。(如何删除Redis中的数据有待学习)
```

#### FreeMarker 
问题描述：
```
使用FreeMarker渲染时遇到数值的空值处理报错。
```
如何解决：
```
将空值处理的默认值设置为0(${RankItem.amount!0})，还是报错。后来发现RankItem类中的amount类型被设成了Integer，改为int后可以正常显示。
```

#### 正则表达式
问题描述：
```
匹配并删除每行开头的时间戳
"[2019-08-01 21:24:41] bt3102 (11m:21s)\n"
                        + "[2019-08-01 21:24:42] TeamCity server version is 2019.1.1 (build 66192)\n"
                        + "[2019-08-01 21:24:43] Collecting changes in 2 VCS roots (22s)\n";
```
如何解决：
```
    private static final Pattern pattern = Pattern.compile("(?<=\\n|^)\\[.+?\\] ");
    public static String process(String log) {
        Matcher matcher = pattern.matcher(log);
        return matcher.replaceAll("");
    }

使用"(?<=\\n|^)\\[.+?\\] "匹配每行开头时间戳，替换时不会替换\n。
```