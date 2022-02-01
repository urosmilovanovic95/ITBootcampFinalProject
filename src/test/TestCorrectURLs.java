package test;

import objectsPages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestCorrectURLs {
    @Test
    public void SameURLDifferentApproach(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        Actions action = new Actions(wd);

        System.out.println("Same URL check...");
        wd.get(HomePage.url);
        HomePage.hoverWomenXpath(wd,action);
        HomePage.clickDresses(wd);
        String prvaAdresa = wd.getCurrentUrl();
        wd.navigate().back();
        HomePage.hoverDressesXpath(wd,action);
        HomePage.clickDresses(wd);
        String drugaAdresa = wd.getCurrentUrl();
        Assert.assertEquals(prvaAdresa,HomePage.summerDresses);
        Assert.assertEquals(drugaAdresa,HomePage.summerDresses);
        wd.close();
    }
}
