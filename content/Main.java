import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// import java.util.HashSet;
// import java.util.TreeSet;

// public class Main{
    
//     public static void main(String[] args) {
//         // HashSet<String> stringSet = new HashSet();
//         // stringSet.add("a");
//         // stringSet.add("a");
//         // stringSet.add("a");
//         // System.out.println(stringSet.size());//输出1
//         // HashSet<Person> personSet = new HashSet();
//         // personSet.add(new Person("b",1));
//         // personSet.add(new Person("b",2));
//         // personSet.add(new Person("b",3));
//         // System.out.println(personSet.size());//输出3
//         // System.out.println(personSet.iterator().next().getNum());//输出为1
    
//     TreeSet<Person> pts = new TreeSet();
//     pts.add(new Person("a",1));
//     pts.add(new Person("a",2));
//     pts.add(new Person("a",3));
// System.out.println(pts.size());
//     }
// }
// class Person implements Comparable<Person>{
//     private String name;
//     private int testNum;
//     Person(String a,int t) {
//         this.name = a;
//         this.testNum = t;
//     }
//     public int getNum(){
//         return this.testNum;
//     }

//     @Override
//     public int hashCode(){
//         return this.name.hashCode();
//     }
//    @Override
//     public boolean equals(Object obj){
//         if(this==obj){
//             return true;
//         }
//         if(obj instanceof Person){
//             Person p = (Person)obj;
//            if(this.name.equals(p.name)){
//                return true;
//            }
//         }
//      return false;
//     }
//     public int compareTo(Person o){
//         return this.name.compareTo(o.name);
//     }
// }


public class LoginService{

    设计一个方法 用来登录认证 一维数组
   
    private String[] userBox = new String[]{"ws","研究生","Java"};
    private int[] passwordBOX = new int[]{123,666,888};

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





// //设计一个方法，用来登录认证---ArrayList    
// private ArrayList<String> userBox = new ArrayList();
// {
//     userBox.add("张三-111");
//     userBox.add("李四-222");
//     userBox.add("王五-333");
// }
// public String loginForList(String name,String password){
//     for(int i=0;i<userBox.size();i++){
//         String[] value = userBox.get(i).split("-");//一个人的信息 v[0] v[1]
//         if(value[0].equals(name)){
//             if(value[1].equals(password)){
//                 return "登录成功";
//             }
//             break;
//         }
//     }
//     return "用户名或密码错误";
// }
    

   




// //设计一个方法 用来登录认证----Set
// private HashSet<String> userBox = new HashSet();
// {
//     userBox.add("张三-111");
//     userBox.add("李四-222");
//     userBox.add("王五-333");
// }
// public String loginForSet(String name,String password){
//     Iterator<String> it =new Iterator();
//     while(it.hasNext()){
//         String[] value = it.next().split("-");
//         if(value[0].equals(name)){
//             if(value[1].equals(password)){
//                 return "登录成功";
//             }
//         }
//         break;
//     }
// return "用户名或密码错误";
// }





// //设计一个方法 用来登录认证---Map   
// private HashMap<String, Integer> userBox = new HashMap();
// {
//     userBox.put("张三",111);
//     userBox.put("李四",222);
//     userBox.put("王五",333);   
// } 
// public String loginForMap(String name,String password){
//     Integer realPassword = userBox.get(name);
//     if(realPassword!=null){//人名存在
//         if(realPassword.equals(Integer.parseInt(password))){
//             return "登录成功";
//         }
//     }
// return "用户名或密码错误";
// }

}


