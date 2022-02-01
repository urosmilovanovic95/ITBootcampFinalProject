package objectsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SummerDressesPage {
    public static String drugaHaljinaButton = "//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[2]";
    public static String header = "//*[@id=\"header_logo\"]/a";
    public static String imeHaljine;
    public static String drugaHaljina = "//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img";

    // Dress Getters
    public static WebElement getDrugaHaljina(WebDriver wd){
        return wd.findElement(By.xpath(drugaHaljinaButton));
    }
    public static WebElement getHeader(WebDriver wd){
        return wd.findElement(By.xpath(header));
    }
    public static WebElement getDrugaHaljinaZaHover(WebDriver wd){
        return wd.findElement(By.xpath(drugaHaljina));
    }
    // Dress Clicks
    public static void clickDrugaHaljina(WebDriver wd){
        imeHaljine = getDrugaHaljina(wd).getAttribute("title");
        getDrugaHaljina(wd).click();
    }
    public static void hoverDressesSummer(WebDriver wd, Actions action){
        action.moveToElement(getDrugaHaljinaZaHover(wd)).perform();
    }
}
