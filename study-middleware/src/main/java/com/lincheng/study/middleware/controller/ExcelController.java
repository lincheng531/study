package com.lincheng.study.middleware.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSON;
import com.lincheng.study.common.domain.dubbo.vo.ProductVO;
import com.lincheng.study.common.domain.middleware.excel.vo.EasyPoiDemoAchievementVO;
import com.lincheng.study.common.domain.middleware.excel.vo.EasyPoiDemoVO;
import com.lincheng.study.common.utils.EasyPoiUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @description:
 * @author: linCheng
 * @create: 2021-10-12 15:08
 **/
@Slf4j
@RestController
@RequestMapping("/easyPoi")
public class ExcelController {


    @RequestMapping(value = "/importCons")
    public void importCons(@RequestParam("file") MultipartFile file, @RequestParam("rows")Integer rows ) throws IOException {
        if (null==file){
            System.out.println("null");
        }
        //根据file得到Workbook,主要是要根据这个对象获取,传过来的excel有几个sheet页
        Workbook hssfWorkbook = getWorkBook(file);
        //获取sheet数量
        int sheetNum = hssfWorkbook.getNumberOfSheets();
        ImportParams params = new ImportParams();
        //表头在第几行
        params.setTitleRows(rows);

        try {
            params.setStartSheetIndex(0);
            List<ConsFrom> result = ExcelImportUtil.importExcel(file.getInputStream(), ConsFrom.class, params);
            System.out.println(JSON.toJSONString(result));
            params.setStartSheetIndex(1);
            List<SwtichRoundLoadPowerFrom> result2 = ExcelImportUtil.importExcel(file.getInputStream(), SwtichRoundLoadPowerFrom.class, params);
            System.out.println(JSON.toJSONString(result2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Excel中的sheet
     * @param file
     * @return
     * @throws IOException
     */
    public static Workbook getWorkBook(MultipartFile file) throws IOException {
        //这样写excel能兼容03和07
        InputStream is = file.getInputStream();
        Workbook hssfWorkbook = null;
        try {
            hssfWorkbook = new HSSFWorkbook(is);
        } catch (Exception ex) {
            is =file.getInputStream();
            hssfWorkbook = new XSSFWorkbook(is);
        }
        return hssfWorkbook;
    }



    @RequestMapping("/export")
    public void export(HttpServletResponse response) {

        List<EasyPoiDemoVO> easyPoiDemoVOList = new ArrayList<>();
        EasyPoiDemoVO easyPoiDemoVO1 = new EasyPoiDemoVO();
        easyPoiDemoVO1.setId(1);
        easyPoiDemoVO1.setBirthday(new Date());
        easyPoiDemoVO1.setName("李四");
        easyPoiDemoVO1.setRegistrationDate("2021-10-14 22:17:06");
        easyPoiDemoVO1.setSex("1");
        easyPoiDemoVO1.setAge(9L);
        easyPoiDemoVO1.setNation("汉族");
        easyPoiDemoVO1.setRemark("导出时间设置,如果字段是Date类型则不需要设置 数据库如果是string类型,这个需要设置这个数据库格式,用以转换时间格式输出");
        EasyPoiDemoAchievementVO achievemen1 = new EasyPoiDemoAchievementVO();
        achievemen1.setChinese(20.0);
        achievemen1.setMath(30.0);
        achievemen1.setEnglish(10.0);
        easyPoiDemoVO1.setAchievemen(achievemen1);
        easyPoiDemoVOList.add(easyPoiDemoVO1);
        EasyPoiDemoVO easyPoiDemoVO2 = new EasyPoiDemoVO();
        easyPoiDemoVO2.setId(2);
        easyPoiDemoVO2.setBirthday(new Date());
        easyPoiDemoVO2.setName("王五");
        easyPoiDemoVO2.setRegistrationDate("2021-10-13 22:17:06");
        easyPoiDemoVO2.setSex("2");
        easyPoiDemoVO2.setAge(7L);
        easyPoiDemoVO2.setNation("苗族");
        EasyPoiDemoAchievementVO achievemen2 = new EasyPoiDemoAchievementVO();
        achievemen2.setChinese(50.0);
        achievemen2.setMath(70.0);
        achievemen2.setEnglish(6.5);
        easyPoiDemoVO2.setAchievemen(achievemen2);
        easyPoiDemoVOList.add(easyPoiDemoVO2);

        EasyPoiUtils.exportExcel(easyPoiDemoVOList, "easypoi导出功能(用户表)", "导出sheet1", EasyPoiDemoVO.class, "测试Users.xls", response);

    }



    @RequestMapping("/import")
    public void export(@RequestParam("file") MultipartFile file, ProductVO productVO) {
        System.out.println(JSON.toJSONString(productVO));

        List<EasyPoiDemoVO> easyPoiDemoVOS = EasyPoiUtils.importExcel(file, 2, EasyPoiDemoVO.class);

        System.out.println(JSON.toJSONString(easyPoiDemoVOS));
    }

    @RequestMapping("/templateConsExport")
    public String templateConsExport(HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + "cons_template.xlsx");
        InputStream inputStream = null;
        OutputStream os = null;
        try {
            inputStream = this.getClass().getClassLoader().getResourceAsStream("excel_template/cons_template.xlsx");
            os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        } finally {
            try {
                if (Optional.ofNullable(os).isPresent()){
                    os.close();
                }
                if (Optional.ofNullable(inputStream).isPresent()){
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage(), e);
            }
        }
        return null;
    }


}
