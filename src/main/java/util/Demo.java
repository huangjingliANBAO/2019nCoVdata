package util;

import java.sql.*;

/**
 * @Description TODO
 * @Author jl_huang
 * @Date 2020-02-17
 **/
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //一开始必须填一个已经存在的数据库
        String url = "jdbc:mysql://localhost:3306/db_zhihu?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8";
        Connection conn = DriverManager.getConnection(url, "root", "root");
        Statement stat = conn.createStatement();
        //创建数据库hello
        stat.executeUpdate("create database hello");
        //打开创建的数据库
        stat.close();
        conn.close();
        url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8";
        conn = DriverManager.getConnection(url, "root", "root");
        stat = conn.createStatement();
        //创建表test
        stat.executeUpdate("create table test(id int, name varchar(80))");
        stat.close();
        conn.close();
    }
}
