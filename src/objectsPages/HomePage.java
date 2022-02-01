package objectsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class HomePage {
    public static String url = "http://automationpractice.com/index.php";
    public static String summerDresses = "http://automationpractice.com/index.php?id_category=11&controller=category";
    public static String womenMain = "//a[@class='sf-with-ul'][contains(text(),'Women')]";
    public static String dresses = "//li[@class='sfHover']//a[contains(text(),'Summer Dresses')]";
    public static String dressesMain = "//*[@id=\"block_top_menu\"]/ul/li[2]/a";
    public static String searchBarXPATH = "//*[@id=\"search_query_top\"]";
    public static String searchBarBtn = "//button[@name='submit_search']";
    public static String contactUsBtn = "//div[@id='contact-link']//a[contains(text(),'Contact us')]";
    public static String facebookBtn = "//*[@id=\"social_block\"]/ul/li[1]/a";
    public static String twitterBtn = "//*[@id=\"social_block\"]/ul/li[2]/a";
    public static String youtubeBtn = "//*[@id=\"social_block\"]/ul/li[3]/a";
    public static String googlePlusBtn = "//*[@id=\"social_block\"]/ul/li[4]/a";
    public static String facebookURL = "https://www.facebook.com/groups/525066904174158/";
    public static String twitterURL = "https://twitter.com/seleniumfrmwrk";
    public static String youtubeURL = "https://www.youtube.com/channel/UCHl59sI3SRjQ-qPcTrgt0tA";
    public static String googlePlusURL = "https://accounts.google.com/signin/v2/identifier?passive=1209600&osid=1&continue=https%3A%2F%2Fplus.google.com%2F111979135243110831526%2Fposts&followup=https%3A%2F%2Fplus.google.com%2F111979135243110831526%2Fposts&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

    // Element GETTERS
    public static WebElement getWomenMainXpath(WebDriver wd){
        return wd.findElement(By.xpath(womenMain));
    }
    public static WebElement getDressesXpath(WebDriver wd){
        return wd.findElement(By.xpath(dresses));
    }
    public static WebElement getDressesMainXpath(WebDriver wd){
        return wd.findElement(By.xpath(dressesMain));
    }
    public static WebElement getSearchBar(WebDriver wd){
        return wd.findElement(By.xpath(searchBarXPATH));
    }
    public static WebElement getSearchBarBtn(WebDriver wd){
        return wd.findElement(By.xpath(searchBarBtn));
    }
    public static WebElement getContactUsBtn(WebDriver wd){
        return wd.findElement(By.xpath(contactUsBtn));
    }
    public static WebElement getFacebookBtn(WebDriver wd){
        return wd.findElement(By.xpath(facebookBtn));
    }
    public static WebElement getTwitterBtn(WebDriver wd){
        return wd.findElement(By.xpath(twitterBtn));
    }
    public static WebElement getYoutubeBtn(WebDriver wd){
        return wd.findElement(By.xpath(youtubeBtn));
    }
    public static WebElement getGooglePlusBtn(WebDriver wd){
        return wd.findElement(By.xpath(googlePlusBtn));
    }


    // HOVER METHODS
    public static void hoverWomenXpath(WebDriver wd, Actions action){
        action.moveToElement(getWomenMainXpath(wd)).perform();
    }
    public static void hoverDressesXpath(WebDriver wd, Actions action){
        action.moveToElement(getDressesMainXpath(wd)).perform();
    }

    // Click Methods
    public static void clickDresses(WebDriver wd){
        getDressesXpath(wd).click();
    }
    public static void clickSearchBarBtn(WebDriver wd){
        getSearchBarBtn(wd).click();
    }
    public static void clickContactUsBtn(WebDriver wd){
        getContactUsBtn(wd).click();
    }
    public static void clickFacebookBtn(WebDriver wd){
        getFacebookBtn(wd).click();
    }
    public static void clickTwitterBtn(WebDriver wd){
        getTwitterBtn(wd).click();
    }
    public static void clickYoutubeBtn(WebDriver wd){
        getYoutubeBtn(wd).click();
    }
    public static void clickGooglePlusBtn(WebDriver wd){
        getGooglePlusBtn(wd).click();
    }


    // Other Methods
    public static void writeInSearchBar(WebDriver wd,String string){
        Actions action = new Actions(wd);
        action.click(getSearchBar(wd)).sendKeys(string).perform();
    }
    public static void checkSocialIcons(WebDriver wd,String socialIconPath, String destinationUrl){
        wd.findElement(By.xpath(socialIconPath)).click();
        ArrayList<String> tabs = new ArrayList<String>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1));
        String noviLink = wd.switchTo().window(tabs.get(1)).getCurrentUrl();
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(destinationUrl,noviLink);
        wd.switchTo().window(tabs.get(1)).close();
        wd.switchTo().window(tabs.get(0));
    }

}
