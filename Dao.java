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
            //加载 JDBC 桥的驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // 加载对应驱动

        //通过数据库的 url 访问数据库
        String url="jdbc:mysql://localhost:3306/mysql";
        //mysql 数据库的用户名
        String username = "root";
        //mysql 数据库密码
        String password = "wang087";

        try {
            //使用sql 包中的 Connection 接口，通过DriverManger 类的静态方法getConnection()创建连接对象
            conn=DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return conn;
    }

    //数据库添加操作
    public static int insert(Student student) throws SQLException {
        // Connection 接口代表与特定的数据库连接  并在连接上下文中执行sql 语句
        Connection conn = getConn();
       int i=0;
        // sql 语句的添加             Name，Age,grade1,grade2,grade3  插入的数据属性
        String sql="insert into student(Name,Age,grade1,grade2,grade3) values(?,?,?,?,?)";
        PreparedStatement pstmt = null;

        try {
            //执行 动态的sql 语句
            pstmt = conn.prepareStatement(sql);
            //将获取到的 Name，Sex，Age 的数据插入到指定的位置
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

    //数据库的修改
    public static int updata(Student student) {
        // Connection 接口代表与特定的数据库连接  并在连接上下文中执行sql 语句
        Connection conn= getConn();
        int i=0;
        // sql语句实现数据库修改  按名字修改年龄
        String sql1 =  "update student set Age='" + student.getAge() + "'"+","+"grade1='"+student.getGrade1()+"'"
        	    +","+"grade2='"+student.getGrade2()+"'"+","+"grade3='"+student.getGrade3()+"'where Name='" + student.getName() + "'";
        // PreparedStatement 执行动态的sql语句 如增删改
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql1);
                 //执行动态的sql语句  包含insert update delete
            i = pstmt.executeUpdate();
            if(i>0) {
                System.out.println("修改成功！");
            }else {
                System.out.println("未找到需要修改的数据！");
            }
            System.out.println("restult:"+i);
            // 关闭
            pstmt.close();
            //关闭数据库连接
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       return i;
    }
    //ResultSet 接口 暂存数据库的查询结果

    //数据库的查找
    public static Integer getAll() {
        // Connection 接口代表与特定的数据库连接  并在连接上下文中执行sql 语句
        Connection conn= getConn();
        String sql="select name,age,grade1,grade2,grade3,grade1+grade2+grade3 AS SUM  from student order by(SUM) desc";
        //PreparedStatement类型执行动态的sql语句     Statement 执行静态语句
        PreparedStatement pstmt;

        try {
            //执行sql语句
            pstmt = conn.prepareStatement(sql);
            // 执行给定的sql语句返回单个 ResultSet 对象
            ResultSet rs = pstmt.executeQuery();
            // getMetaData()  检索此 ResultSet对象列的数量，类型和属性。 getColumnCount() 返回ResultSet对象列的数量
            int col =rs.getMetaData().getColumnCount();
            System.out.println("============================");
            while(rs.next()) {
                for(int i=1;i<=col;i++) {
                    //输出获取到的数据库数据
                    System.out.print(rs.getString(i)+"\t");
                    if(i==5){
                        System.out.println();
                    }
                }
                //分行
                System.out.println();
            }
            System.out.println("======================");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    //数据库的删除
    public static int delete(String name) {
        // Connection 接口代表与特定的数据库连接  并在连接上下文中执行sql 语句
        Connection conn =getConn();
        int i=0;
        //修改类型的sql 语句实现
        String sql="delete from student where Name ='"+ name+ "'";
        PreparedStatement pstmt;

        try {
            // 执行动态sql语句
            pstmt = conn.prepareStatement(sql);
            // executeUpdate() 指示受影响的行数
            i = pstmt.executeUpdate();
            if(i>0) {
            System.out.println("删除成功！");
            }else {
                System.out.println("未找到需要删除数据！");
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