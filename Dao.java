package student;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import student.Student;

public class Dao {

    private static Connection getConn() {
        Connection conn =null;
/*CREATE TABLE student{
 * nmae vachar(255) NOT NULL,
 * age varchar(255),
 * grade1 int (255),
 * grade2 int (255),
 * grade3 int (255),
 * PRIMARY KEY('name')
 * }*/
        try {
            //���� JDBC �ŵ���������
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // ���ض�Ӧ����

        //ͨ�����ݿ�� url �������ݿ�
        String url="jdbc:mysql://localhost:3306/mysql";
        //mysql ���ݿ���û���
        String username = "root";
        //mysql ���ݿ�����
        String password = "wang087";

        try {
            //ʹ��sql ���е� Connection �ӿڣ�ͨ��DriverManger ��ľ�̬����getConnection()�������Ӷ���
            conn=DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return conn;
    }

    //���ݿ���Ӳ���
    public static int insert(Student student) throws SQLException {
        // Connection �ӿڴ������ض������ݿ�����  ����������������ִ��sql ���
        Connection conn = getConn();
       int i=0;
        // sql �������             Name��Age,grade1,grade2,grade3  �������������
        String sql="insert into student(Name,Age,grade1,grade2,grade3) values(?,?,?,?,?)";
        PreparedStatement pstmt = null;

        try {
            //ִ�� ��̬��sql ���
            pstmt = conn.prepareStatement(sql);
            //����ȡ���� Name��Sex��Age �����ݲ��뵽ָ����λ��
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getAge());
            pstmt.setInt(3, student.getGrade1());
            pstmt.setInt(4, student.getGrade2());
            pstmt.setInt(5, student.getGrade3());
            i=pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return i;
    }

    //���ݿ���޸�
    public static int updata(Student student) {
        // Connection �ӿڴ������ض������ݿ�����  ����������������ִ��sql ���
        Connection conn= getConn();
        int i=0;
        // sql���ʵ�����ݿ��޸�  �������޸�����
        String sql1 =  "update student set Age='" + student.getAge() + "'"+","+"grade1='"+student.getGrade1()+"'"
        	    +","+"grade2='"+student.getGrade2()+"'"+","+"grade3='"+student.getGrade3()+"'where Name='" + student.getName() + "'";
        // PreparedStatement ִ�ж�̬��sql��� ����ɾ��
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql1);
                 //ִ�ж�̬��sql���  ����insert update delete
            i = pstmt.executeUpdate();
            if(i>0) {
                System.out.println("�޸ĳɹ���");
            }else {
                System.out.println("δ�ҵ���Ҫ�޸ĵ����ݣ�");
            }
            System.out.println("restult:"+i);
            // �ر�
            pstmt.close();
            //�ر����ݿ�����
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       return i;
    }
    //ResultSet �ӿ� �ݴ����ݿ�Ĳ�ѯ���

    //���ݿ�Ĳ���
    public static Integer getAll() {
        // Connection �ӿڴ������ض������ݿ�����  ����������������ִ��sql ���
        Connection conn= getConn();
        String sql="select name,age,grade1,grade2,grade3,grade1+grade2+grade3 AS SUM  from student order by(SUM) desc";
        //PreparedStatement����ִ�ж�̬��sql���     Statement ִ�о�̬���
        PreparedStatement pstmt;

        try {
            //ִ��sql���
            pstmt = conn.prepareStatement(sql);
            // ִ�и�����sql��䷵�ص��� ResultSet ����
            ResultSet rs = pstmt.executeQuery();
            // getMetaData()  ������ ResultSet�����е����������ͺ����ԡ� getColumnCount() ����ResultSet�����е�����
            int col =rs.getMetaData().getColumnCount();
            System.out.println("============================");
            while(rs.next()) {
                for(int i=1;i<=col;i++) {
                    //�����ȡ�������ݿ�����
                    System.out.print(rs.getString(i)+"\t");
                    if(i==5){
                        System.out.println();
                    }
                }
                //����
                System.out.println();
            }
            System.out.println("======================");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    //���ݿ��ɾ��
    public static int delete(String name) {
        // Connection �ӿڴ������ض������ݿ�����  ����������������ִ��sql ���
        Connection conn =getConn();
        int i=0;
        //�޸����͵�sql ���ʵ��
        String sql="delete from student where Name ='"+ name+ "'";
        PreparedStatement pstmt;

        try {
            // ִ�ж�̬sql���
            pstmt = conn.prepareStatement(sql);
            // executeUpdate() ָʾ��Ӱ�������
            i = pstmt.executeUpdate();
            if(i>0) {
            System.out.println("ɾ���ɹ���");
            }else {
                System.out.println("δ�ҵ���Ҫɾ�����ݣ�");
            }
            System.out.println("result:"+i);
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return i;
    }

}