import java.util.HashSet;
import java.util.TreeSet;

public class Main{
    
    public static void main(String[] args) {
        // HashSet<String> stringSet = new HashSet();
        // stringSet.add("a");
        // stringSet.add("a");
        // stringSet.add("a");
        // System.out.println(stringSet.size());//输出1
        // HashSet<Person> personSet = new HashSet();
        // personSet.add(new Person("b",1));
        // personSet.add(new Person("b",2));
        // personSet.add(new Person("b",3));
        // System.out.println(personSet.size());//输出3
        // System.out.println(personSet.iterator().next().getNum());//输出为1
    
    TreeSet<Person> pts = new TreeSet();
    pts.add(new Person("a",1));
    pts.add(new Person("a",2));
    pts.add(new Person("a",3));
System.out.println(pts.size());
    }
}
class Person implements Comparable<Person>{
    private String name;
    private int testNum;
    Person(String a,int t) {
        this.name = a;
        this.testNum = t;
    }
    public int getNum(){
        return this.testNum;
    }

    @Override
    public int hashCode(){
        return this.name.hashCode();
    }
   @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj instanceof Person){
            Person p = (Person)obj;
           if(this.name.equals(p.name)){
               return true;
           }
        }
     return false;
    }
    public int compareTo(Person o){
        return this.name.compareTo(o.name);
    }
}
