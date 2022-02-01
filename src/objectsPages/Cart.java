package objectsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {
    public static String imeHaljine = "//*[@id=\"product_6_41_0_0\"]/td[2]/p/a";
    public static String bojaVelicina = "//*[@id=\"product_6_41_0_0\"]/td[2]/small[2]/a";
    public static String kvantitet = "//*[@id=\"product_6_41_0_0\"]/td[5]/input[2]";
    public static String nestoZaScroll = "//*[@id=\"block_top_menu\"]/ul/li[1]/a";

    //Getters
    public static String getImeHaljine(WebDriver wd){
        return wd.findElement(By.xpath(imeHaljine)).getText();
    }
    public static String getBojaVelicina(WebDriver wd){
        return wd.findElement(By.xpath(bojaVelicina)).getText();
    }
    public static String getKvantitet(WebDriver wd){
        return wd.findElement(By.xpath(kvantitet)).getAttribute("value");
    }
}
