package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GetCsvData {

    public static final int COLUMN_NUM = 13;//csv文件列数
    //获取目录当前路径下所有csv文件的绝对路径
    public static ArrayList<String> getFileList(String dirPath) {
        File dir = new File(dirPath);
        File[] fileList = dir.listFiles();
        ArrayList<String> strList = new ArrayList<String>();
        for (File f : fileList) {
            if ((f.isFile())
                    && (".csv".equals(
                    f.getName().
                            substring(
                                    f.getName().lastIndexOf("."),
                                    f.getName().length())))) {
                strList.add(f.getAbsolutePath());
            }
        }
        return strList;
    }

    //获取指定目录下所有csv文件数据，存入三维数组并返回
    public static String[][][] getAllCsvData(String dir) throws IOException {
        //ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> csvList = getFileList(dir);
        String[][][] s3 = new String[csvList.size()][][];
        for (int i = 0; i < csvList.size(); i++) {
            s3[i] = (getCsvDataNew(csvList.get(i)));
        }
        return s3;
    }
    //获取指定csv文件数据，存入二维数组并返回
    public static String[][] getCsvDataNew(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
        String line = "";
        ArrayList<String[]> lineList = new ArrayList<String[]>();
        // Read a single line from the file until there are no more lines to read
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, ","); // 以逗号作为分隔符
            String[] currCol = new String[COLUMN_NUM]; // Each currCol has 9 fields, so we need room for the 8 tokens.
            for (int i = 0; i < COLUMN_NUM; i++) { // For each token in the line that we've read:
                //先判断是否还有待读取数据，防止溢出
                if (st.hasMoreTokens()) {
                    currCol[i] = st.nextToken();
                }
            }
            lineList.add(currCol);
        }
        String[][] str = new String[lineList.size()][13];
        for (int i = 0; i < lineList.size(); i++) {
            for (int j = 0; j < 13; j++) {
                str[i][j] = lineList.get(i)[j];
                //System.out.println(str[i][x]);
            }
        }
        br.close();
        return str;
    }


    public static void main(String[] args) throws IOException {
        String[][][] s = getAllCsvData("D:\\dev\\_2019nCoVdata\\src\\main\\resources\\data\\");
        for (int i = 0; i < s.length; i++)
            for (int j = 0; j < s[i].length; j++)
                for (int k = 0; k < s[i][j].length; k++) {
                    System.out.println("s[" + i + "]" + "[" + j + "]" + "[" + k + "]: " + s[i][j][k]);
                }
    }
}