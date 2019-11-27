---
title: "工具类12 TreeMap+考试系统练习"
date: 2019-11-10T09:47:59+08:00
draft: fault
---



TreeMap     
1.java.util包     
2.构造方法      
    无参数 带map参数    
3.常用方法  
    put get remove replace size 
4.底层数据结构的存储    
    红黑二叉树  
    

## 考试系统     

```java
public class Main {
    public static void main(String[] args) {
    ExamMachine machine = new ExamMachine();
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎进入考试系统\n请输入用户名");
        String userName = input.nextLine();
        System.out.println("请输入密码");
        String password = input.nextLine();
        Student student =new Student(userName,password);
        String result = machine.logIn(student.getUserName(),student.getPassword());
        if(result.equals("登录成功")){
            System.out.println("登录成功\n"+student.getUserName()+"开始考试啦，请认真作答");
            ArrayList<Question> paper = machine.getPaper();
            String[] answers = student.exam(paper);
            Teacher teacher = new Teacher();
            int score = teacher.checkPaper(paper,answers);
            System.out.println(student.getUserName()+"最终的成绩是"+score);
        }
    }
}
```
```java
public class ExamMachine {

    private HashMap<String, String> userBox = new HashMap<>();
    {
        userBox.put("张三", "111");
    }

    private HashSet<Question> questionBank = new HashSet<Question>();
    {
        questionBank.add(new Question("如下哪个选项不是Java基本数据类型?\n\tA.String\n\tB.Short\n\tC.Char\n\tD.Boolean", "B"));
        questionBank.add(new Question("如下哪个选项是是Java基本数据类型?\n\tA.String\n\tB.Short\n\tC.Char\n\tD.Boolean", "B"));
        questionBank.add(new Question("如下哪个选项不是Java引用数据类型?\n\tA.String\n\tB.Short\n\tC.Char\n\tD.Boolean", "B"));
        questionBank.add(new Question("如下哪个选项是Java引用数据类型?\n\tA.String\n\tB.Short\n\tC.Char\n\tD.Boolean", "B"));
        questionBank.add(new Question("如下哪个选项不是Java.util包中的类?\n\tA.String\n\tB.Short\n\tC.Char\n\tD.Boolean", "B"));
        questionBank.add(new Question("如下哪个选项是Java.util包中的类?\n\tA.String\n\tB.Short\n\tC.Char\n\tD.Boolean", "B"));
        questionBank.add(new Question("如下哪个选项是String类的方法?\n\tA.String\n\tB.Short\n\tC.Char\n\tD.Boolean", "B"));
        questionBank.add(new Question("如下哪个选项不是String类的方法?\n\tA.String\n\tB.Short\n\tC.Char\n\tD.Boolean", "B"));
        questionBank.add(new Question("如下哪个选项不是接口中属性的修饰符?\n\tA.String\n\tB.Short\n\tC.Char\n\tD.Boolean", "B"));
        questionBank.add(new Question("如下哪个选项是接口中属性的修饰符?\n\tA.String\n\tB.Short\n\tC.Char\n\tD.Boolean", "B"));
    }

    public ArrayList<Question> getPaper() {
        System.out.println("考试机正在随机生成试卷，请耐心等待");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HashSet<Question> paper = new HashSet<>();

        ArrayList<Question> questionBank = new ArrayList<>(this.questionBank);
        while (paper.size() != 5) {
            int index = new Random().nextInt(this.questionBank.size());
            Question question = questionBank.get(index);
            paper.add(question);
        }
        return new ArrayList<Question>(paper);
    }
    //登录方法
    public String logIn(String userName, String password) {
        String realPassword = this.userBox.get(userName);
        if (realPassword != null && realPassword.equals(password)) {
            return "登录成功";
        }
        return "用户名或密码错误";
    }
}
```
```java
public class Question {
    private String tittle;
    private String answer;

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return  true;
        }
        if(obj instanceof Question){
            Question anotherQuestion = (Question)obj;
        if(this.tittle.equals(anotherQuestion.tittle)){
            return true;
        }
        }
        return  false;
    }
    public String getTittle() {
        return tittle;
    }

    public Question(String tittle, String answer){
    this.tittle = tittle;
    this.answer = answer;
    }
}
```
```java
public class Student {

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Student(String userName, String password){
        this.userName = userName;
        this.password = password;

    }

    public String[] exam(ArrayList<Question> paper){
        String[] answers = new String[paper.size()];
        Scanner input = new Scanner(System.in);
        for(int i=0;i<paper.size();i++){
            Question question = paper.get(i);//题干，真实答案
            System.out.println((i+1)+"."+question.getTittle());
            System.out.println("请输入正确选项");
            answers[i] = input.nextLine();
        }
        return answers;
    }
}
```
```java
public class Teacher {
    public int checkPaper(ArrayList<Question> paper, String[] answers){
        try {
            System.out.println("老师正在批阅试卷，请耐心等待");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int score=0;
        for(int i=0;i<paper.size();i++){
            Question question = paper.get(i);
            if(question.getAnswer().equalsIgnoreCase(answers[i])){
                score+=(100/paper.size());
            }
        }
        return score;
    }
}
```     


