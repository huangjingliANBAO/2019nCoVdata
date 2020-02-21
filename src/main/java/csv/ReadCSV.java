//package csv;
//
//import com.csvreader.CsvReader;
//import dao.impl.DatabaseDAOImpl;
//
//import java.io.IOException;
//import java.nio.charset.Charset;
//
///**
// * @Description TODO
// * @Author jl_huang
// * @Date 2020-02-19
// **/
//public class ReadCSV {
//    public static char separator = ',';
//
//    public static void readCSVInputDB(String filePath, String tableName, DatabaseDAOImpl databaseDAO) {
//        CsvReader reader = null;
//        try {
//            //如果生成文件乱码，就设置GBK编码
//            reader = new CsvReader(filePath, separator, Charset.forName("utf-8"));
//            //读取表头
//            reader.readHeaders();
//            String[] keyArray = reader.getHeaders();
////            for (int i = 1; i < keyArray.length; i++) {
////                System.out.print(keyArray[i]+"+");
////            }
////            逐条读取数据，直至读完
//            int i = 0;
//            //忽略第一行
//            while (reader.readRecord()) {
//                if (i == 0) {
//                    i++;
//                    continue;
//                }
//                i++;
//                //读一行
////                String row=reader. getRawRecord();
////                把行数据转成列数组
//                String[] valueArray = reader.getRawRecord().split(",");
//                databaseDAO.insert(tableName, keyArray, valueArray);
//                //读这行的第一列
////                System.out.println(reader.get(1));
//            }
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                reader.close();
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//
//        String filepath = "D:\\dev\\_2019nCoVdata\\src\\main\\resources\\data\\DXYArea.csv";
//
//    }
//}