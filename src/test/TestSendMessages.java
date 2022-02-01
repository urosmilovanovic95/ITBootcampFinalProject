package test;

import objectsPages.ContactUsPage;
import objectsPages.HomePage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class TestSendMessages {
    @Test
    public void SendMessages() {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        Actions action = new Actions(wd);

        try {
            XSSFWorkbook wbook;
            FileInputStream fi;
            wd.get(HomePage.url);

            fi = new FileInputStream("accounts.xlsx");
            wbook = new XSSFWorkbook(fi);
            Sheet sheet = wbook.getSheetAt(0);

            for (int i=1; i<=30; i++){
                HomePage.clickContactUsBtn(wd);
                Thread.sleep(2000);
                ContactUsPage.getEmailField(wd).sendKeys(Keys.ARROW_DOWN);
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(0);
                ContactUsPage.clickSubjectHeading(wd);
                Select dropdown = new Select(wd.findElement(By.xpath(ContactUsPage.subjectHeading)));
                dropdown.selectByVisibleText(cell.getStringCellValue());
                cell = row.getCell(1);
                ContactUsPage.getEmailField(wd).sendKeys(cell.getStringCellValue());
                cell = row.getCell(2);
                ContactUsPage.getMessageTextArea(wd).sendKeys(cell.toString());
                ContactUsPage.clickSendBtn(wd);
                ContactUsPage.clickGoHome(wd);
            }
            wd.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
