package student;

public class Student {

    //学生类需要的属性，都是私有的
    
    private String Name;
    private String Age;
    private int grade1;
    private int grade2;
    private int grade3;

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
    public Integer getGrade1() {
        return grade1;
    }
    public void setGrade1(Integer grade1) {
        this.grade1 = grade1;
    }
    public Integer getGrade2() {
        return grade2;
    }
    public void setGrade2(Integer grade2) {
        this.grade2 = grade2;
    }
   
    public void setGrade3(Integer grade3) {
    	this.grade3= grade3;
    }
    public Integer getGrade3() {
    	return grade3;
    }
    //构造方法
    public Student(String name, String age, int grade1, int grade2,  int grade3, int grade32) {
        
        this.grade1 =grade1;
        Name = name;
        this.grade2=grade2;
        Age = age;
        this.grade3=grade3;
    }
    public Student(String string, String string2, int int3, int int4, int int5) {
        // TODO Auto-generated constructor stub      
        this.Name=string;
        this.Age=string2;
        this.grade1=int3;
        this.grade2=int4;
        this.grade3=int5;        
    }
}
