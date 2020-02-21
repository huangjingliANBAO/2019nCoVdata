package dao.impl;

import dao.DatabaseDAO;
import entity.DxyArea;
import entity.DxyNews;
import entity.DxyOverall;
import entity.DxyRumor;
import util.DataBaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author jl_huang
 * @Date 2020-02-19
 **/
public class DatabaseDAOImpl implements DatabaseDAO {
    DataBaseConnection dbc = new DataBaseConnection();

    /**
     * 创建省份数据表
     * @throws Exception
     */
    public void createTableArea() throws Exception {
        String sql = "CREATE TABLE `t_dxyarea`  (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id索引',\n" +
                "  `provinceName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '省份名',\n" +
                "  `provinceEnglishName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '省份英文名',\n" +
                "  `cityName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '城市名',\n" +
                "  `cityEnglishName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '城市英文名',\n" +
                "  `province_confirmedCount` int(11) NULL DEFAULT NULL COMMENT '省份确诊数',\n" +
                "  `province_suspectedCount` int(11) NULL DEFAULT NULL COMMENT '省份疑似数',\n" +
                "  `province_curedCount` int(11) NULL DEFAULT NULL COMMENT '省份治愈数',\n" +
                "  `province_deadCount` int(11) NULL DEFAULT NULL COMMENT '省份死亡数',\n" +
                "  `city_confirmedCount` int(11) NULL DEFAULT NULL COMMENT '城市确诊数',\n" +
                "  `city_suspectedCount` int(11) NULL DEFAULT NULL COMMENT '城市疑似数',\n" +
                "  `city_curedCount` int(11) NULL DEFAULT NULL COMMENT '城市治愈数',\n" +
                "  `city_deadCount` int(11) NULL DEFAULT NULL COMMENT '城市死亡数',\n" +
                "  `updateTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发布时间',\n" +
                "  PRIMARY KEY (`id`) USING BTREE\n" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;\n";
        //创建PreparedStatement对象,把sql语句进行封装发送给数据库
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.execute();
        dbc.DBClose();
        pstmt.close();
    }

    /**
     * 创建新闻数据表
     * @throws Exception
     */
    @Override
    public void createTableNews() throws Exception {
        String sql = "CREATE TABLE `t_dxynews`  (\n" +
                "  `id` bigint(20) NULL DEFAULT NULL COMMENT 'id索引',\n" +
                "  `pubDate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发布时间',\n" +
                "  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',\n" +
                "  `summary` varchar(2028) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '摘要',\n" +
                "  `infoSource` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源来源',\n" +
                "  `sourceUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源链接',\n" +
                "  `provinceId` int(11) NULL DEFAULT NULL COMMENT '省份id',\n" +
                "  `provinceName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '省份名称',\n" +
                "  `createTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建时间',\n" +
                "  `modifyTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改时间'\n" +
                ") ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.execute();
        dbc.DBClose();
        pstmt.close();
    }

    /**
     * 创建全国数据表
     * @throws Exception
     */
    @Override
    public void createTableOverall() throws Exception {
        String sql = "CREATE TABLE `t_dxyoverall`  (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id索引',\n" +
                "  `infectSource` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '感染源',\n" +
                "  `passWay` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '传播途径',\n" +
                "  `dailyPic` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '每日图片',\n" +
                "  `dailyPics` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '每日图片',\n" +
                "  `summary` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '摘要',\n" +
                "  `countRemark` int(11) NULL DEFAULT NULL,\n" +
                "  `currentConfirmedCount` int(11) NULL DEFAULT NULL,\n" +
                "  `confirmedCount` int(11) NULL DEFAULT NULL,\n" +
                "  `suspectedCount` int(11)  NULL,\n" +
                "  `curedCount` int(11) NULL DEFAULT NULL,\n" +
                "  `deadCount` int(11) NULL DEFAULT NULL,\n" +
                "  `seriousCount` int(11) NULL DEFAULT NULL,\n" +
                "  `suspectedIncr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `currentConfirmedIncr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `confirmedIncr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `curedIncr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `deadIncr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `seriousIncr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `virus` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `remark1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `remark2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `remark3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `remark4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `remark5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `note1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `note2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `note3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `generalRemark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `abroadRemark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `marquee` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `quanguoTrendChart` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `hbFeiHbTrendChart` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `updateTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE\n" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 4971 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;\n";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.execute();
        dbc.DBClose();
        pstmt.close();
    }

    /**
     * 创建谣言数据表
     * @throws Exception
     */
    @Override
    public void createTableRumor() throws Exception {
        String sql = "CREATE TABLE `t_dxyrumor`  (\n" +
                "  `_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id索引',\n" +
                "  `body` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容',\n" +
                "  `id` int(11) NULL DEFAULT NULL COMMENT '谣言id',\n" +
                "  `mainSummary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主要摘要',\n" +
                "  `rumorType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '谣言类型',\n" +
                "  `sourceUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '链接来源',\n" +
                "  `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '摘要',\n" +
                "  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',\n" +
                "  `crawlTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发布时间',\n" +
                "  PRIMARY KEY (`_id`) USING BTREE\n" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 252 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;\n";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.execute();
        dbc.DBClose();
        pstmt.close();
    }


    /**
     * 查询省份数据
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<DxyArea> selectArea() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM t_dxyarea";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<DxyArea> dxyareaList = new ArrayList<DxyArea>();
        while (rs.next()){
          DxyArea dxyarea = new DxyArea();
          dxyarea.setId(rs.getInt("id"));
          dxyarea.setProvinceName(rs.getString("provinceName"));
          dxyarea.setProvinceEnglishName(rs.getString("provinceEnglishName"));
          dxyarea.setCityName(rs.getString("cityName"));
          dxyarea.setCityEnglishName(rs.getString("cityEnglishName"));
          dxyarea.setProvinceConfirmedCount(rs.getInt("province_confirmedCount"));
          dxyarea.setProvinceSuspectedCount(rs.getInt("province_suspectedCount"));
          dxyarea.setProvinceCuredCount(rs.getInt("province_curedCount"));
          dxyarea.setProvinceDeadCount(rs.getInt("province_deadCount"));
          dxyarea.setCityConfirmedCount(rs.getInt("city_confirmedCount"));
          dxyarea.setCitySuspectedCount(rs.getInt("city_suspectedCount"));
          dxyarea.setCityCuredCount(rs.getInt("city_curedCount"));
          dxyarea.setCityDeadCount(rs.getInt("city_deadCount"));
          dxyarea.setUpdateTime(rs.getString("updateTime"));
          dxyareaList.add(dxyarea);
        }
        return dxyareaList;
    }

    /**
     * 查询新闻数据
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public List<DxyNews> selectNews() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM t_dxynews";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<DxyNews> dxyNewsList = new ArrayList<>();
        while (rs.next()){
            DxyNews dxyNews = new DxyNews();
            dxyNews.setId(rs.getInt("id"));
            dxyNews.setPubDate(rs.getString("pubDate"));
            dxyNews.setTitle(rs.getString("title"));
            dxyNews.setSummary(rs.getString("summary"));
            dxyNews.setInfoSource(rs.getString("infoSource"));
            dxyNews.setProvinceId(rs.getInt("provinceId"));
            dxyNews.setProvinceName(rs.getString("provinceName"));
            dxyNews.setCreateTime(rs.getString("createTime"));
            dxyNews.setModifyTime(rs.getString("modifyTime"));
            dxyNewsList.add(dxyNews);
        }
        return dxyNewsList;
    }

    /**
     * 查询谣言数据
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public List<DxyRumor> selectRumor() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM t_dxyrumor";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<DxyRumor> dxyRumorList = new ArrayList<>();
        while (rs.next()){
            DxyRumor dxyRumor = new DxyRumor();
            dxyRumor.setId(rs.getInt("_id"));
            dxyRumor.setBody(rs.getString("body"));
            dxyRumor.setRumorId(rs.getInt("id"));
            dxyRumor.setMainSummary(rs.getString("mainSummary"));
            dxyRumor.setRumorType(rs.getString("rumorType"));
            dxyRumor.setSourceUrl(rs.getString("sourceUrl"));
            dxyRumor.setSummary(rs.getString("summary"));
            dxyRumor.setTitle(rs.getString("title"));
            dxyRumor.setTitle(rs.getString("crawlTime"));
            dxyRumorList.add(dxyRumor);
        }
        return dxyRumorList;
    }

    /**
     * 查询全国数据
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public List<DxyOverall> selectOverall() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM t_dxyoverall";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<DxyOverall> dxyOverallList = new ArrayList<>();
        while (rs.next()){
            DxyOverall dxyOverall = new DxyOverall();
            dxyOverall.setId(rs.getInt("id"));
            dxyOverall.setInfectSource(rs.getString("infectSource"));
            dxyOverall.setPassWay(rs.getString("passWay"));
            dxyOverall.setDailyPic(rs.getString("dailyPic"));
            dxyOverall.setConfirmedCount(rs.getInt("confirmedCount"));
            dxyOverall.setSuspectedCount(rs.getInt("suspectedCount"));
            dxyOverall.setCuredCount(rs.getInt("curedCount"));
            dxyOverall.setDeadCount(rs.getInt("deadCount"));
            dxyOverall.setVirus(rs.getString("virus"));
            dxyOverall.setRemark1(rs.getString("remark1"));
            dxyOverall.setRemark2(rs.getString("remark2"));
            dxyOverall.setGeneralRemark(rs.getString("generalRemark"));
            dxyOverall.setUpdateTime(rs.getString("updateTime"));
            dxyOverallList.add(dxyOverall);
        }
        return dxyOverallList;
    }

    public void insert(String tableName,String [] keyArray,String [] valueArray) {
        try {
//            String sql="insert into  "+tableName+"(";
            String sql="insert into  "+tableName+" values (";
            String sql2="";
           PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
//            Iterator iterator= (Iterator) map.entrySet();
//            // 鉴于map的key不能重复，所以键为列名，值为这个列的值
//            while (iterator.hasNext()){
//                String key= (String) iterator.next();
//                String value=map.get(key);
//                sql+=key+",";
//                sql2+=value+",";
//            }
            for (int i = 0; i <keyArray.length&&i<valueArray.length ; i++) {
//                sql+=keyArray[i].toLowerCase()+",";//列名要转成全小写
                sql2+="'"+valueArray[i]+"',";
            }
            //删除最后一个逗号
//            sql=sql.substring(0,sql.length()-1);
            sql2=sql2.substring(0,sql2.length()-1);
//            sql+=") values (";
            sql2+=")";
            sql+=sql2;
//            System.out.println("在表添加数据的sql:"+sql);
//            System.out.println(sql);
            int m=pstmt.executeUpdate(sql);
//            System.out.println(m);
//            System.out.println("添加数据结束");
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}