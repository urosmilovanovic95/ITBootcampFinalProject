package test;

import objectsPages.ContactUsPage;
import objectsPages.HomePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestContactUs {
    @Test
    public void ContactUsTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        Actions action = new Actions(wd);

        System.out.println("ContactUS page check...");
        wd.get(HomePage.url);
        HomePage.clickContactUsBtn(wd);
        //start
        Thread.sleep(1000);
        ContactUsPage.getEmailField(wd).sendKeys(Keys.ARROW_DOWN);
        ContactUsPage.dropdownSubject(wd,"1");
        ContactUsPage.getEmailField(wd).sendKeys("uros.milovanovic@bootcamp8.com");
        ContactUsPage.getOrderReference(wd).sendKeys("ne znam sta znaci ovo polje");
        ContactUsPage.sendPicture(wd);
        Thread.sleep(5000);
        ContactUsPage.getMessageTextArea(wd).sendKeys("Haljina mi ne radi bla bla bla");
        ContactUsPage.clickSendBtn(wd);
        wd.close();

    }
}
