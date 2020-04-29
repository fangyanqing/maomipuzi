package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;


/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-29 10:19
 * Excel导出
 **/
public class ExcelUtil {
    private static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    private final static String xls = "xls";
    private final static String xlsx = "xlsx";

    /**
     * 注：
     * HSSFWorkbook:是操作Excel2003以前（包括2003）的版本，扩展名是.xls
     * XSSFWorkbook:是操作Excel2007的版本，扩展名是.xlsx
     */
    public static HSSFWorkbook getHSSFWorkbook(InputStream inputStream){
        HSSFWorkbook hssfWorkbook = null;
        try {
            hssfWorkbook = new HSSFWorkbook(inputStream);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            hssfWorkbook = null;
        }
        return hssfWorkbook;
    }

    //工作簿
    public static Workbook getWorkBook(MultipartFile file) {
        //获得文件名
        String fileName = file.getOriginalFilename();
        //创建workbook工作簿对象，表示整个excel
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream inputStream = file.getInputStream();
            //根据文件后缀名（.xls或.xlsx）不同获得不同的workbook实现类对象
            if (fileName.endsWith(xls)){
                //2003前版本
                workbook = new HSSFWorkbook(inputStream);
            }else if(fileName.endsWith(xlsx)){
                //2007后版本
                workbook = new XSSFWorkbook(inputStream);
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
            workbook = null;
        }
        return workbook;
    }
}
