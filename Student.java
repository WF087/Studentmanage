package student;

public class Student {

    //学生类需要的属性，都是私有的
    
    private String Name;
    private String Age;
    private String grade1;
    private String grade2;
    private String grade3;

    //Get Set 方法的实现
   
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getAge() {
        return Age;
    }
    public void setAge(String age) {
        Age = age;
    }
    public String getGrade1() {
        return grade1;
    }
    public void setGrade1(String grade1) {
        this.grade1 = grade1;
    }
    public String getGrade2() {
        return grade2;
    }
    public void setGrade2(String grade2) {
        this.grade2 = grade2;
    }
   
    public void setGrade3(String grade3) {
    	this.grade3= grade3;
    }
    public String getGrade3() {
    	return grade3;
    }
    //构造方法
    public Student(String name, String age, String grade1, String grade2,  String grade3, String grade32) {
        
        this.grade1 =grade1;
        Name = name;
        this.grade2=grade2;
        Age = age;
        this.grade3=grade3;
    }
    public Student(String string, String string2, String string3, String string4, String string5) {
        // TODO Auto-generated constructor stub
       
        this.Name=string;
        this.Age=string2;
        this.grade1=string3;
        this.grade2=string4;
        this.grade3=string5;
        
    }
}
