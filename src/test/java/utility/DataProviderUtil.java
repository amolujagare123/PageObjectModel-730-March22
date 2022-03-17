package utility;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class DataProviderUtil {

    public static Object[][] getMyData(String fileName,String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);

        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        HSSFSheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getPhysicalNumberOfRows();

        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount-1][colCount];

        for(int i=0;i<rowCount-1;i++)
        {
            HSSFRow row = sheet.getRow(i+1);

            for(int j=0; j<colCount;j++) {

                try {
                    HSSFCell cell = row.getCell(j);
                    cell.setCellType(CellType.STRING);
                    data[i][j] = cell.getStringCellValue();

                } catch (Exception e) {
                    data[i][j] = "";
                }

            }
        }
        return data;
    }


    public static Object[][] getMyDataXLSX(String fileName,String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getPhysicalNumberOfRows();

        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount-1][colCount];

        for(int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            for(int j=0; j<colCount;j++) {

                try {
                    XSSFCell cell = row.getCell(j);
                    cell.setCellType(CellType.STRING);
                    data[i][j] = cell.getStringCellValue();

                } catch (Exception e) {
                    data[i][j] = "";
                }

            }
        }
        return data;
    }
}
