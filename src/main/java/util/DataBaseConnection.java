package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
private static Connection connection;
     public  Connection getConnection() throws ClassNotFoundException, SQLException {
        //1.加载驱动
         Class.forName("com.mysql.cj.jdbc.Driver");
         //2.连接数据库
         String url = "jdbc:mysql://localhost:3306/db_2019ncovdata?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8";
         String user = "root";
         String password = "root";
         connection = DriverManager.getConnection(url,user,password);
         return connection;
	}
	public  void DBClose() throws SQLException {
         connection.close();
    }
}