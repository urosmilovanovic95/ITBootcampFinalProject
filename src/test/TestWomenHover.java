package test;

import objectsPages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestWomenHover {
    @Test
    public void UrlCheck1Women(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        Actions action = new Actions(wd);

        System.out.println("Women SummerDresses check...");
        wd.get(HomePage.url);
        HomePage.hoverWomenXpath(wd,action);
        HomePage.clickDresses(wd);
        Assert.assertEquals(wd.getCurrentUrl(),HomePage.summerDresses);
        wd.close();
    }
}
