package com.luyuheng.mycloud.utils;

import com.luyuheng.mycloud.pojo.ExcelResult;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Excel 文件导入导出工具类
 * @Author:luyuheng
 * @Date:2018/4/26 10 52
 * @Description
 */
public class ExcelUtils<T> {

    private static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    /**
     * suffix of excel 2003
     */
    public static final String OFFICE_EXCEL_V2003_SUFFIX = "xls";
    /**
     * suffix of excel 2007-2010
     */
    public static final String OFFICE_EXCEL_V2007_SUFFIX = "xlsx";


    public ExcelResult<ArrayList<T>> excelReader(File file,String[] headers){
        String fileName = file.getName();
        try {
            if (fileName.endsWith(OFFICE_EXCEL_V2003_SUFFIX) || fileName.endsWith(OFFICE_EXCEL_V2007_SUFFIX)){
                logger.info("{}===文件类型为正确",file.getName());
                return excelReaderForExcelFile(file,headers);
            }else{
                logger.info("{}===文件类型错误",file.getName());
                return new ExcelResult<ArrayList<T>>("文件类型错误",null);
            }
        }catch (Exception e){
            logger.error("===文件导入出错：{}",e);
        }
        return null;
    }

    /**
     * 文件转换方法
     * @param file
     * @param headers
     * @return
     */
    private ExcelResult<ArrayList<T>> excelReaderForExcelFile(File file,String[] headers){
        ArrayList<T> arrayList = new ArrayList<>();
        try {
            Workbook workbook = WorkbookFactory.create(file);
            //获取泛型
            T t = getKey();
            Class clazz = t.getClass();
            //Read the Sheet
            for (int sheetNum = 0;sheetNum < workbook.getNumberOfSheets() ;sheetNum++){
                Sheet sheet = workbook.getSheetAt(sheetNum);
                if (sheet == null) {
                    continue;
                }
                // Read the Row
                for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                    if (sheetNum == 0 && rowNum == 0){
                        continue;
                    }
                    Row row = sheet.getRow(rowNum);
                    Object ob = instanceHelper(clazz);
                    if (row != null) {
                        //columnNum 也是 headers index
                        for (int columnNum = 0;columnNum < headers.length; columnNum++){
                            //对对象处理
                            String[] tempHeader = headers[columnNum].split("\\.");
                            if (tempHeader.length == 0){
                                tempHeader = new String[]{headers[columnNum]};
                            }
                            Field tempField = clazz.getDeclaredField(tempHeader[0]);
                            Class fieldType = tempField.getType();
                            tempField.setAccessible(true);
                            if (tempHeader.length > 1){
                                Object[] objArray = new Object[tempHeader.length];
                                objArray[0] = instanceHelper(fieldType);
                                tempField.set(ob,fieldType.cast(objArray[0]));
                                tempField.setAccessible(true);
                                for (int k = 1;k < tempHeader.length-1;k++){
                                    tempField = fieldType.getDeclaredField(tempHeader[k]);
                                    fieldType = tempField.getType();
                                    objArray[k] = instanceHelper(fieldType);
                                    tempField.setAccessible(true);
                                    tempField.set(objArray[k-1],objArray[k]);
                                }
                                int index = tempHeader.length-1;
                                tempField = fieldType.getDeclaredField(tempHeader[index]);
                                fieldType = tempField.getType();
                                objArray[index] = instanceHelper(fieldType);
                                tempField.setAccessible(true);
                                tempField.set(objArray[index-1],fieldType.cast(cellTypeConventer(row.getCell(columnNum),fieldType)));
                            }else {
                                tempField.setAccessible(true);
                                tempField.set(ob,fieldType.cast(cellTypeConventer(row.getCell(columnNum),fieldType)));
                            }
                        }
                    }
                    arrayList.add((T) ob);
                }
            }
       } catch (IOException e) {
            logger.error("文件IO出错");
            e.printStackTrace();
        } catch (InstantiationException e) {
            logger.error("实例化出错");
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            logger.error("找不到此属性");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            logger.error("非法访问属性");
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            logger.error("无效的格式");
            e.printStackTrace();
        }

        return new ExcelResult<ArrayList<T>>("success",arrayList);
    }

    private Object instanceHelper(Class fieldType) throws IllegalAccessException, InstantiationException {
        if (fieldType==String.class){
            return "";
        }else if (fieldType==Integer.class){
            return 0;
        }else if (fieldType==Long.class){
            return 0L;
        }else {
            return fieldType.newInstance();
        }
    }

    private Object cellTypeConventer(Cell cell, Class fieldType){
        if (fieldType==String.class){
            return cell.getStringCellValue();
        }else if (fieldType==Integer.class){
            return cell.getNumericCellValue();
        }else if (fieldType==Long.class){
            return Long.valueOf(Math.round(cell.getNumericCellValue()));
        }else {
            logger.info("未找到对应数据类型");
            return null;
        }
    }


    private T key;

    public ExcelUtils(Class<T> clazz) {
        try {
            this.key = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public T getKey(){
        return key;
    }

}
