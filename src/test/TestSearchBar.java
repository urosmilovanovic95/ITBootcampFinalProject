package test;

import objectsPages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class TestSearchBar {

    @Test
    public void SearchBar() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        Actions action = new Actions(wd);

        System.out.println("Search bar check...");
        wd.get(HomePage.url);
        HomePage.writeInSearchBar(wd,"yellow");
        HomePage.clickSearchBarBtn(wd);
        Thread.sleep(1000);
        boolean haveKeyWord = false;
        List<WebElement> results = wd.findElements(By.className("color_to_pick_list"));
        for (int i=0; i<results.size(); i++){
            List<WebElement> rezultatiBoja = results.get(i).findElements(By.className("color_pick"));
            for (int j=0; j<rezultatiBoja.size(); j++){
                if (rezultatiBoja.get(j).getAttribute("style").contains("background: rgb(241, 196, 15);")){
                    haveKeyWord = true;
                }
            }
        }
        Assert.assertEquals(haveKeyWord,true);
        wd.close();
    }
}
