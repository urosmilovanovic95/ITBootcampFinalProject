package test;

import objectsPages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestDressesHover {

    @Test
    public void UrlCheck2Dresses(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        Actions action = new Actions(wd);

        System.out.println("Dresses SummerDresses check...");
        wd.get(HomePage.url);
        HomePage.hoverDressesXpath(wd,action);
        HomePage.clickDresses(wd);
        Assert.assertEquals(wd.getCurrentUrl(), HomePage.summerDresses);
        wd.close();
    }
}
