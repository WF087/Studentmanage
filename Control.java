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
            //����
            System.out.println("  ~~~~~~~~~~~~~~��ӭʹ�����ݿ�~~~~~~~~~~~~~~   ");
            System.out.println("��ѡ������Ҫִ�еĲ����ı�ţ�");
            System.out.println("1.�������  2.ɾ������ 3.�޸����� 4.��ѯ����");
            System.out.println("~~~~~~~~~~~~~~���������Ĳ���~~~~~~~~~~~~~~");
            sc=new Scanner(System.in);
            int c=sc.nextInt();
            switch(c) {
            case 1:
                //�������
                System.out.println("�������:");
                System.out.println("������ѧ�� ���������䣬���ĳɼ�����ѧ�ɼ���Ӣ��ɼ���");
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
                //ɾ������
                System.out.println("ɾ������:");
                System.out.println("������ѧ�� ������");
                sc=new Scanner(System.in);
                name=sc.next();
                Dao.delete(name);
                Dao.getAll();
                break;
            case 3:
                //�޸�����
                System.out.println("�޸�����:");
                System.out.println("��������Ҫ�޸ĵ�ͬѧ������ �� ��Ҫ�޸ĵ���Ϣ��");
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
                //��ѯ����
                System.out.println("��ѯ����:");
                Dao.getAll();
                break;
                default:
                    System.out.println("����");
            }
        }while(true);
    }

}