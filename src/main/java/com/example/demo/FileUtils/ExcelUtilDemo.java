package com.example.demo.FileUtils;

import com.sun.deploy.util.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

/**
 * excel 操作
 * 不带层级结构
 * Created by cuilb3 on 2017/8/29.
 */
public class ExcelUtilDemo {
    // excel文件源目录
    private static String path = "/home/clb/FA_clean.xlsx";
    //写入的sql文件目录
    static File tmpfile = new File("/home/clb/fa_clean.sql");
    // 抽取表的哪几列
    private static Integer[] columns = {0,2,6,4,7,8};
    // 构建sql的对应的名称
    private static String[] sqlNames = {"device_no","title","name","faultNo","isStop"};
    //表名称
    private static String tableName = "table_fa_clean";
    // 表id初始值
    private static int num = 1;
    // 拼接的表字段
    private static String initDML = "";
    static {
        StringBuffer sb = new StringBuffer();
        sb.append("insert into ").append(tableName).append(" ( id ,");
        String columnsString = StringUtils.join(Arrays.asList(sqlNames),",");
        sb.append(columnsString).append(")").append(" values ");
        initDML = sb.toString();
    }


    public static void main(String[] args) {
        try {
            List<List<String>> result = new ExcelUtilDemo().readXlsx(path);
            System.out.println(result.size());
            List<Map> excelObjectsList = new ArrayList<>();
            for (int i = 0; i < result.size(); i++) {
                List<String> model = result.get(i);
                Map excelObjectMap = new HashMap();
                for (int i1 = 0; i1 < sqlNames.length; i1++) {
                    excelObjectMap.put(sqlNames[i1],model.get(columns[i1]));
                }
                excelObjectsList.add(excelObjectMap);
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(tmpfile));
            //设置父类id和id,并写入文件sql语句
            LogInfo(excelObjectsList,writer);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static int  LogInfo(List<Map> list,BufferedWriter writer) throws IOException {
        for(int i =0 ;i<list.size();i++){
            StringBuffer values = new StringBuffer("("+num+", ");
            for (int i1 = 0; i1 < sqlNames.length; i1++) {
                Object value = list.get(i).get(sqlNames[i1]);
                if(value instanceof String){
                    values.append("'"+value+"'");
                } else {
                    values.append(value);
                }
                if(i1 < sqlNames.length-1){
                    values.append(", ");
                }
            }
            values.append(")");
            String ddl = initDML + values.toString() + ";" + "\n";
            writer.write(ddl);
            System.out.println(ddl);
            num++;
        }
        return 1;
    }

    /**
     *
     * @Title: readXlsx
     * @Description: 处理Xlsx文件
     * @param @param path
     * @param @return
     * @param @throws Exception    设定文件
     * @return List<List<String>>    返回类型
     * @throws
     */
    private List<List<String>> readXlsx(String path) throws Exception {
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        List<List<String>> result = new ArrayList<List<String>>();
        // 循环每一页，并处理当前循环页
        for (XSSFSheet xssfSheet : xssfWorkbook) {
            if (xssfSheet == null) {
                continue;
            }
            // 处理当前页，循环读取每一行
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                int minColIx = xssfRow.getFirstCellNum();
                int maxColIx = xssfRow.getLastCellNum();
                List<String> rowList = new ArrayList<String>();
                for (int colIx = minColIx; colIx < maxColIx; colIx++) {
                    XSSFCell cell = xssfRow.getCell(colIx);
                    if (cell == null) {
                        rowList.add(null);
                        continue;
                    }
                    rowList.add(cell.toString());
                }
                rowList.add(String.valueOf(xssfRow.getCTRow().getOutlineLevel()));
                result.add(rowList);
            }
        }
        return result;
    }
}
