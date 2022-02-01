package test;

import objectsPages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestSocialLinks {
    @Test
    public void SocialCheck() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        Actions action = new Actions(wd);

        System.out.println("Check social...");
        wd.get(HomePage.url);
        HomePage.checkSocialIcons(wd,HomePage.facebookBtn,HomePage.facebookURL);
        HomePage.checkSocialIcons(wd,HomePage.twitterBtn,HomePage.twitterURL);
        HomePage.checkSocialIcons(wd,HomePage.youtubeBtn,HomePage.youtubeURL);
        HomePage.checkSocialIcons(wd,HomePage.googlePlusBtn,HomePage.googlePlusURL);
        wd.close();
    }
}
