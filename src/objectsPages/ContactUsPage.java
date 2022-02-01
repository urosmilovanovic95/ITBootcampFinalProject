package objectsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {
    public static String subjectHeading = "//*[@id=\"id_contact\"]";
    public static String emailField = "//*[@id=\"email\"]";
    public static String orderReference = "//*[@id=\"id_order\"]";
    public static String messageTextArea = "//*[@id=\"message\"]";
    public static String chooseFile = "//*[@id=\"fileUpload\"]";
    public static String sendBtn = "//*[@id=\"submitMessage\"]/span";
    public static String goHome = "//ul[@class='footer_links clearfix']//a[@class='btn btn-default button button-small']";

    //Getters
    public static WebElement getSubjectHeading(WebDriver wd){
        return wd.findElement(By.xpath(subjectHeading));
    }
    public static WebElement getEmailField(WebDriver wd){
        return wd.findElement(By.xpath(emailField));
    }
    public static WebElement getOrderReference(WebDriver wd){
        return wd.findElement(By.xpath(orderReference));
    }
    public static WebElement getMessageTextArea(WebDriver wd){
        return wd.findElement(By.xpath(messageTextArea));
    }
    public static WebElement getChooseFile(WebDriver wd){
        return wd.findElement(By.xpath(chooseFile));
    }
    public static WebElement getSendBtn(WebDriver wd){
        return wd.findElement(By.xpath(sendBtn));
    }
    public static WebElement getGoHomeBtn(WebDriver wd){
        return wd.findElement(By.xpath(goHome));
    }

    //Click methods
    public static void clickSubjectHeading(WebDriver wd){
        getSubjectHeading(wd).click();
    }
    public static void clickSendBtn(WebDriver wd){
        getSendBtn(wd).click();
    }
    public static void clickGoHome(WebDriver wd){
        getGoHomeBtn(wd).click();
    }

    //Methods
    public static void dropdownSubject(WebDriver wd,String size){
        clickSubjectHeading(wd);
        Select dropdown = new Select(wd.findElement(By.xpath(subjectHeading)));
        dropdown.selectByValue(size);
    }
    public static void sendPicture(WebDriver wd) throws InterruptedException {
        getChooseFile(wd).sendKeys("C:\\Users\\Uros\\Desktop\\solidBlue.png");
    }
}
