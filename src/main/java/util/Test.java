package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @Description TODO
 * @Author jl_huang
 * @Date 2020-02-17
 **/
public class Test {
    public static void main(String[] args)throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db_zhihu?characterEncoding=UTF-8";
        Connection conn = DriverManager.getConnection(url,"root","root");
        Statement statement = conn.createStatement();
        statement.executeUpdate("create database db_nCovdata");
        statement.close();
        conn.close();
        url = "jdbc:mysql://localhost:3306/db_nCovdata?characterEncoding=UTF-8";
        conn = DriverManager.getConnection(url,"root","root");
        statement = conn.createStatement();
        /**
         * provinceName,provinceEnglishName,cityName,cityEnglishName,
         * province_confirmedCount,province_suspectedCount,province_curedCount,province_deadCount,
         * city_confirmedCount,city_suspectedCount,city_curedCount,city_deadCount,updateTime
         */
        statement.executeUpdate("create table t_DXYArea(id int,provinceName varchar(255)," +
                "provinceEnglishName varchar(255),cityName varchar(255)," +
                " cityEnglishName varchar(255),province_confirmedCount int," +
                "province_suspectedCount int,province_curedCount int," +
                "province_deadCount int,city_confirmedCount int," +
                "city_suspectedCount int,city_curedCount int,city_deadCount int," +
                "updateTime date)");
        statement.close();
        conn.close();
    }
}