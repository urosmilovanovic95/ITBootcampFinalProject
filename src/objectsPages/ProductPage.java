package objectsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    public static String plusBtn = "//*[@id=\"quantity_wanted_p\"]/a[2]";
    public static String sizeDropdown = "//*[@id=\"group_1\"]";
    public static String whiteColor = "//a[@name='White']";
    public static String addToCartBtn = "//button[@name='Submit']//span";
    public static String proceed = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]/span[1]";
    public static String boja;
    public static String velicina;
    //Getters
    public static WebElement getPlusBtn(WebDriver wd){
        return wd.findElement(By.xpath(plusBtn));
    }
    public static WebElement getSizeDropdown(WebDriver wd){
        return wd.findElement(By.xpath(sizeDropdown));
    }
    public static WebElement getWhiteColor(WebDriver wd){
        return wd.findElement(By.xpath(whiteColor));
    }
    public static WebElement getAddToCartBtn(WebDriver wd){
        return wd.findElement(By.xpath(addToCartBtn));
    }
    public static WebElement getProceed(WebDriver wd){
        return wd.findElement(By.xpath(proceed));
    }
    // Click methods
    public static void clickPlusBtn(WebDriver wd){
        getPlusBtn(wd).click();
    }
    public static void clickSizeDropdown(WebDriver wd){
        getSizeDropdown(wd).click();
    }
    public static void clickWhiteColor(WebDriver wd){
        boja = getWhiteColor(wd).getAttribute("name");
        getWhiteColor(wd).click();
    }
    public static void clickAddToCartBtn(WebDriver wd){
        getAddToCartBtn(wd).click();
    }
    public static void clickProceed(WebDriver wd){
        getProceed(wd).click();
    }

    //Dropdown value method
    public static void dropdownC(WebDriver wd,String size){
        clickSizeDropdown(wd);
        Select dropdown = new Select(wd.findElement(By.xpath(sizeDropdown)));
        dropdown.selectByValue(size);
        switch (size){
            case "1":
                velicina = "S";
                break;
            case "2":
                velicina = "M";
                break;
            case "3":
                velicina = "L";
                break;
        }
    }


}
