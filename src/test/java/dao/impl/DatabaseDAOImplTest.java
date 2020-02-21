package dao.impl;

import entity.DxyArea;
import entity.DxyNews;
import entity.DxyOverall;
import entity.DxyRumor;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class DatabaseDAOImplTest {
DatabaseDAOImpl dbdi = new DatabaseDAOImpl();
    @Test
    public void createTableArea() {
        try {
            dbdi.createTableArea();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insert() {

    }

    @Test
    public void selectArea() throws SQLException, ClassNotFoundException {
        List<DxyArea> dxyareaList = dbdi.selectArea();
        dxyareaList.forEach(System.out::println);
    }



    @Test
    public void selectNews() throws SQLException, ClassNotFoundException {
        List<DxyNews> dxyNewsList = dbdi.selectNews();
        dxyNewsList.forEach(System.out::println);
    }

    @Test
    public void selectRumor() throws SQLException, ClassNotFoundException {
        List<DxyRumor> rumorList = dbdi.selectRumor();
        rumorList.forEach(System.out::println);
    }

    @Test
    public void selectOverall() throws SQLException, ClassNotFoundException {
        List<DxyOverall> overallList = dbdi.selectOverall();
        overallList.forEach(System.out::println);
    }
}