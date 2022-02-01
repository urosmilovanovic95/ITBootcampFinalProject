package test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class TestCreate30acc {
    @Test
    public void CreateExcel() {
        XSSFWorkbook wbook = new XSSFWorkbook();
        XSSFSheet sheet = wbook.createSheet("testovi");

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("choose");
        cell = row.createCell(1);
        cell.setCellValue("email");
        cell = row.createCell(2);
        cell.setCellValue("message");

        for (int i=1; i<=30; i++){
            String select;
            row = sheet.createRow(i);
            cell = row.createCell(0);
            Random radnom = new Random();
            int izbor = radnom.nextInt(2);
            if (izbor == 0){
                cell.setCellValue("Customer service");
            }else {
                cell.setCellValue("Webmaster");
            }
            cell = row.createCell(1);
            cell.setCellValue("email"+i+"@gmail.com");
            cell = row.createCell(2);
            cell.setCellValue("lorem");
        }
        try {
            FileOutputStream os = new FileOutputStream("create30.xlsx");
            wbook.write(os);
            wbook.close();
            os.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
