package student;


import java.sql.SQLException;
import java.util.Scanner;

import student.Student;
import student.Dao;

public class Control {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws SQLException {
        String name=null;
        String age=null;
        String grade1=null;
        String grade2=null;
        String grade3=null;
        Scanner sc=null;
        do {
            //界面
            System.out.println("  ~~~~~~~~~~~~~~欢迎使用数据库~~~~~~~~~~~~~~   ");
            System.out.println("请选择你需要执行的操作的编号：");
            System.out.println("1.添加数据  2.删除数据 3.修改数据 4.查询数据");
            System.out.println("~~~~~~~~~~~~~~请输入您的操作~~~~~~~~~~~~~~");
            sc=new Scanner(System.in);
            int c=sc.nextInt();
            switch(c) {
            case 1:
                //添加数据
                System.out.println("添加数据:");
                System.out.println("请输入学生 姓名，年龄，语文成绩，数学成绩，英语成绩：");
                sc=new Scanner(System.in);
                name=sc.next();
                age=sc.next();
                grade1=sc.next();
                grade2=sc.next();
                grade3=sc.next();
               
				Dao.insert(new Student(name,age,grade1,grade2,grade3));
		
                Dao.getAll();
                break;
            case 2:
                //删除数据
                System.out.println("删除数据:");
                System.out.println("请输入学生 姓名：");
                sc=new Scanner(System.in);
                name=sc.next();
                Dao.delete(name);
                Dao.getAll();
                break;
            case 3:
                //修改数据
                System.out.println("修改数据:");
                System.out.println("请输入需要修改的同学的姓名 和 需要修改的信息：");
                sc=new Scanner(System.in);
                name=sc.next();
                age=sc.next();
                grade1=sc.next();
                grade2=sc.next();
                grade3=sc.next();
                Dao.getAll();
                Dao.updata(new Student(name,"",age,grade1,grade2,grade3));
                break;
            case 4:
                //查询数据
                System.out.println("查询数据:");
                Dao.getAll();
                break;
                default:
                    System.out.println("错误！");
            }
        }while(true);
    }

}