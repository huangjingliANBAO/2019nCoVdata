package util;

import java.sql.*;

/**
 * @Description TODO
 * @Author jl_huang
 * @Date 2020-02-17
 **/
public class DataUtil {
    public void createDatabase() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet res = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/db_test?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8";
        String user = "root";
        String password = "root";
        try {
            //连接数据库
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            //获取Statement对象
            assert conn != null;
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "CREATE TABLE `t_dxyarea`  (\n" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id索引',\n" +
                "  `provinceName` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '省份名',\n" +
                "  `provinceEnglishName` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '省份英文名',\n" +
                "  `cityName` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '城市名',\n" +
                "  `cityEnglishName` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '城市英文名',\n" +
                "  `province_confirmedCount` int(11) NULL DEFAULT NULL COMMENT '省份确诊数',\n" +
                "  `province_suspectedCount` int(11) NULL DEFAULT NULL COMMENT '省份疑似数',\n" +
                "  `province_curedCount` int(11) NULL DEFAULT NULL COMMENT '省份治愈数',\n" +
                "  `province_deadCount` int(11) NULL DEFAULT NULL COMMENT '省份死亡数',\n" +
                "  `city_confirmedCount` int(11) NULL DEFAULT NULL COMMENT '城市确诊数',\n" +
                "  `city_suspectedCount` int(11) NULL DEFAULT NULL COMMENT '城市疑似数',\n" +
                "  `city_curedCount` int(11) NULL DEFAULT NULL COMMENT '城市治愈数',\n" +
                "  `city_deadCount` int(11) NULL DEFAULT NULL COMMENT '城市死亡数',\n" +
                "  `updateTime` date NULL DEFAULT NULL COMMENT '发布时间',\n" +
                "  PRIMARY KEY (`id`) USING BTREE\n" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;\n";
        try {
            assert stmt != null;
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DataUtil du = new DataUtil();
        du.createDatabase();
    }
}