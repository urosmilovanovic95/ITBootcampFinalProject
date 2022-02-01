package test;

import objectsPages.Cart;
import objectsPages.HomePage;
import objectsPages.ProductPage;
import objectsPages.SummerDressesPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestCart {
    @Test
    public void CartCheck() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        Actions action = new Actions(wd);

        wd.get(HomePage.summerDresses);
        SummerDressesPage.getHeader(wd).sendKeys(Keys.PAGE_DOWN);
        SummerDressesPage.hoverDressesSummer(wd,action);
        SummerDressesPage.clickDrugaHaljina(wd);
        Thread.sleep(1000);
        ProductPage.getPlusBtn(wd).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        ProductPage.clickPlusBtn(wd);
        ProductPage.dropdownC(wd,"2");
        Thread.sleep(2000);
        ProductPage.clickWhiteColor(wd);
        ProductPage.clickAddToCartBtn(wd);
        Thread.sleep(5000);
        ProductPage.clickProceed(wd);
        Thread.sleep(1000);
        Assert.assertTrue(Cart.getImeHaljine(wd).contains("Printed Summer Dress"));
        Assert.assertTrue(Cart.getKvantitet(wd).contains("2"));
        Assert.assertTrue(Cart.getBojaVelicina(wd).contains(ProductPage.boja));
        Assert.assertTrue(Cart.getBojaVelicina(wd).contains(ProductPage.velicina));
        wd.close();
    }

}
