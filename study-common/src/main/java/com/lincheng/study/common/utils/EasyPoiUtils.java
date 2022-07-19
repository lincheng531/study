package com.lincheng.study.common.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * @Description Excle 文件导入导出Util(easypoi)
 * @author lincheng5
 * @date 2021/10/17 22:45
 */
public class EasyPoiUtils {
    /**
     * 功能描述：复杂导出Excel，包括文件名以及表名。创建表头
     *
     * @author lincheng5
     * @date 2021/10/17 22:45
     * @param list 导出的实体类
     * @param title 表头名称
     * @param sheetName sheet表名
     * @param pojoClass 映射的实体类
     * @param isCreateHeader 是否创建表头
     * @param fileName
     * @param response
     * @return
     */
    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, boolean isCreateHeader, HttpServletResponse response) {
        ExportParams exportParams = new ExportParams(title, sheetName);
        exportParams.setCreateHeadRows(isCreateHeader);
        defaultExport(list, pojoClass, fileName, response, exportParams);
    }


    /**
     * 功能描述：复杂导出Excel，包括文件名以及表名,不创建表头
     *
     * @author lincheng5
     * @date 2021/10/17 22:45
     * @param list 导出的实体类
     * @param title 表头名称
     * @param sheetName sheet表名
     * @param pojoClass 映射的实体类
     * @param fileName
     * @param response
     * @return
     */
    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, HttpServletResponse response) {
        defaultExport(list, pojoClass, fileName, response, new ExportParams(title, sheetName));
    }

    /**
     * 功能描述：Map 集合导出
     *
     * @author lincheng5
     * @date 2021/10/17 22:45
     * @param list 实体集合
     * @param fileName 导出的文件名称
     * @param response
     * @return
     */
    public static void exportExcel(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
        defaultExport(list, fileName, response);
    }

    /**
     * 功能描述：默认导出方法
     *
     * @author lincheng5
     * @date 2021/10/17 22:45
     * @param list 导出的实体集合
     * @param fileName 导出的文件名
     * @param pojoClass pojo实体
     * @param exportParams ExportParams封装实体
     * @param response
     * @return
     */
    private static void defaultExport(List<?> list, Class<?> pojoClass, String fileName, HttpServletResponse response, ExportParams exportParams) {
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
        if (workbook != null) {
            downLoadExcel(fileName, response, workbook);
        }
    }

    /**
     * 功能描述：Excel导出
     *
     * @author lincheng5
     * @date 2021/10/17 22:45
     * @param fileName 文件名称
     * @param response
     * @param workbook Excel对象
     * @return
     */
    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new  RuntimeException(e);
        }
    }

    /**
     * 功能描述：默认导出方法
     *
     * @author lincheng5
     * @date 2021/10/17 22:45
     * @param list 导出的实体集合
     * @param fileName 导出的文件名
     * @param response
     * @return
     */
    private static void defaultExport(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
        if (workbook != null) {
            downLoadExcel(fileName, response, workbook);
        }
    }


    /**
     * 功能描述：根据文件路径来导入Excel
     *
     * @author lincheng5
     * @date 2021/10/17 22:45
     * @param filePath 文件路径
     * @param titleRows 表标题的行数
     * @param headerRows 表头行数
     * @param pojoClass Excel实体类
     * @return
     */
    public static <T> List<T> importExcel(String filePath, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        //判断文件是否存在
        if (StringUtils.isBlank(filePath)) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("模板不能为空");
        } catch (Exception e) {
            e.printStackTrace();

        }
        return list;
    }

    /**
     * 功能描述：根据接收的Excel文件来导入Excel,并封装成实体类
     *
     * @author lincheng5
     * @date 2021/10/17 22:45
     * @param file 上传的文件
     * @param titleRows 表标题的行数
     * @param headerRows 表头行数
     * @param pojoClass Excel实体类
     * @return
     */
    public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        if (file == null) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("excel文件不能为空");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
        return list;
    }



    /**
     * 功能描述：根据接收的Excel文件来导入Excel,并封装成实体类
     *
     * @author lincheng5
     * @date 2021/10/17 22:45
     * @param file 上传的文件
     * @param headerRows 表头行数
     * @param pojoClass Excel实体类
     * @return
     */
    public static <T> List<T> importExcel(MultipartFile file,Integer headerRows, Class<T> pojoClass) {
        if (file == null) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("excel文件不能为空");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
        return list;
    }



    /**
     * 功能描述：根据接收的Excel文件来导入Excel,并封装成实体类
     *
     * @param file       上传的文件
     * @param sheetNum   导入第几个sheet页
     * @param headerRows 表头行数
     * @param pojoClass  Excel实体类
     * @return
     * @author lincheng5
     */
    public static <T> List<T> importExcelBySheet(MultipartFile file, Integer sheetNum, Integer headerRows, Class<T> pojoClass) {
        if (file == null) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setStartSheetIndex(sheetNum);
        params.setTitleRows(headerRows);

        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
            //list = (List<T>) getNotNullObjList(ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params));
        } catch (NoSuchElementException e) {
            throw new RuntimeException("excel文件不能为空");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
        return list;
    }


    /**
     * @Description: 去除集合中的空对象
     * @author: linCheng
     * @Date: 2022/7/19 14:51
     * @param: sourceList
     * @Return: java.util.List<?>
     */
    private static List<?> getNotNullObjList(List<?> sourceList){

        List<?> oldList = new ArrayList<>(sourceList);

        if (CollectionUtils.isNotEmpty(sourceList)){
            sourceList.forEach(obj->{
                if (checkObjAllFieldsIsNull(obj)){
                    oldList.remove(obj);
                }
            });
        }

        return oldList;
    }



    /**
     * @Description: 判断对象中的所有属性是否为空
     * @author: linCheng
     * @Date: 2022/7/19 14:51
     * @param: object
     * @Return: boolean
     */
    private static boolean checkObjAllFieldsIsNull(Object object) {
        if (null == object) {
            return true;
        }
        try {
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.get(object) != null && StringUtils.isNotBlank(f.get(object).toString())) {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }





    /**
     * @Description:
     * @author: linCheng
     * @Date: 2022/7/19 15:04
     * @param: title 标题
     * @param: sheetName sheet名称
     * @param: pojoClass  Excel实体类
     * @param: list 导入的实体集合
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     */
    public static Map<String, Object> setExportParams(String title, String sheetName, Class<?> pojoClass, List<?> list) {
        ExportParams params = new ExportParams(title, sheetName, ExcelType.XSSF);
        Map<String, Object> valueMap = Maps.newHashMap();
        valueMap.put("title", params);
        valueMap.put("data", list);
        valueMap.put("entity", pojoClass);
        return valueMap;
    }


    /**
     * @Description: 导出多sheet页
     * @author: linCheng
     * @Date: 2022/7/19 15:05
     * @param: fileName 文件名称
     * @param: exportParamList 配置数据信息
     * @param: response
     * @Return: void
     */
    public static void exportExcel(String fileName,List<Map<String, Object>> exportParamList, HttpServletResponse response) {
        Workbook workbook = ExcelExportUtil.exportExcel(exportParamList, ExcelType.XSSF);
        if (workbook != null) {
            downLoadExcel(fileName, response, workbook);
        }
    }

}




