package dao;

import entity.DxyArea;
import entity.DxyNews;
import entity.DxyOverall;
import entity.DxyRumor;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description TODO
 * @Author jl_huang
 * @Date 2020-02-19
 **/
public interface DatabaseDAO {
    void createTableArea()throws Exception;
    void createTableNews()throws Exception;
    void createTableOverall()throws Exception;
    void createTableRumor()throws Exception;
    List<DxyArea> selectArea() throws SQLException, ClassNotFoundException;
    List<DxyNews> selectNews() throws SQLException, ClassNotFoundException;
    List<DxyRumor> selectRumor() throws SQLException, ClassNotFoundException;
    List<DxyOverall> selectOverall() throws SQLException, ClassNotFoundException;
    void insert(String tableName,String [] keyArray,String [] valueArray);

}
