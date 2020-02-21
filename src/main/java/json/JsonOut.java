package json;


import dao.impl.DatabaseDAOImpl;
import entity.DxyArea;
import entity.DxyNews;
import entity.DxyOverall;
import entity.DxyRumor;
import net.sf.json.JSONArray;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description TODO
 * @Author jl_huang
 * @Date 2020-02-21
 **/
public class JsonOut {
  private static  DatabaseDAOImpl ddi = new DatabaseDAOImpl();
    public static void getJson1() throws SQLException, ClassNotFoundException, IOException {
        List<DxyArea> dxyareaList = ddi.selectArea();
        JSONArray array = JSONArray.fromObject(dxyareaList);
        String filepath = "D:\\data\\dxyarea.json";
        FileWriter fw = new FileWriter(filepath);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(String.valueOf(array));
        bw.close();
        fw.close();
        System.out.println(array);
    }
    public static void getJson2() throws SQLException, ClassNotFoundException, IOException {
        List<DxyNews> dxyNewsList = ddi.selectNews();
        JSONArray array = JSONArray.fromObject(dxyNewsList);
        String filepath = "D:\\data\\dxynews.json";
        FileWriter fw = new FileWriter(filepath);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(String.valueOf(array));
        bw.close();
        fw.close();
        System.out.println(array);
    }
    public static void getJson3() throws SQLException, ClassNotFoundException, IOException {
        List<DxyRumor> rumorList = ddi.selectRumor();
        JSONArray array = JSONArray.fromObject(rumorList);
        String filepath = "D:\\data\\dxyrumor.json";
        FileWriter fw = new FileWriter(filepath);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(String.valueOf(array));
        bw.close();
        fw.close();
        System.out.println(array);
    }
    public static void getJson4() throws SQLException, ClassNotFoundException, IOException {
        List<DxyOverall> overallList = ddi.selectOverall();
        JSONArray array = JSONArray.fromObject(overallList);
        String filepath = "D:\\data\\dxyoverall.json";
        FileWriter fw = new FileWriter(filepath);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(String.valueOf(array));
        bw.close();
        fw.close();
        System.out.println(array);
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        getJson4();
    }

}