package com.anhtester.baitap.commom;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static com.anhtester.baitap.locators.LocatorsCMS.*;
import org.openqa.selenium.JavascriptExecutor;


public class BaseTestBT {

    public static WebDriver driver;
    public String URL_CRM = "https://crm.anhtester.com/admin/authentication";
    public String URL_CMS = "https://cms.anhtester.com/login";
    String Username = "admin@example.com";
    String Password = "123456";
    //@BeforeMethod //Chạy trước mỗi @Test
    public void createBrowser(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void createBrowser(@Optional("chrome") String browserName){
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        if(browserName.equals("chrome")){
            driver = new ChromeDriver();
        }
        if(browserName.equals("edge")){
            driver = new EdgeDriver();
        }
        if(browserName.equals("firefox")){
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get(URL_CMS);
        Assert.assertTrue(checkDisplayElement(headerLoginPage),"Fail!");
        setText(inputEmail,Username);
        setText(inputPassword,Password);
        clickElement(buttonLogin);
    }

    @AfterMethod
    public void closeBrowser(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    public void sleep(double second){
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void captureScreenImage(String imageName) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        //Get size screen browser
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize);
        //Khởi tạo kích thước khung hình với kích cỡ trên
        Rectangle screenRectangle = new Rectangle(screenSize);
        //Tạo hình chụp với độ lớn khung đã tạo trên
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        //Lưu hình vào dạng file với dạng png
        File file = new File(imageName + ".png");
        try {
            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void clickElement(String locator){
        driver.findElement(By.xpath(locator)).click();
    }
    public void setText(String locator, String text){
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }
    public void setTextHasEnter(String locator, String text){
        driver.findElement(By.xpath(locator)).sendKeys((text), Keys.ENTER);
    }
    public void getAttribute(String locator, String attributeName){
        driver.findElement(By.xpath(locator)).getAttribute(attributeName);
    }
    public void clickDropdown(String locator, String locator_text, String text){
        driver.findElement(By.xpath(locator)).click();
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }
    public void clickDropdownEnter(String locator, String locator_text, String text){
        driver.findElement(By.xpath(locator)).click();
        driver.findElement(By.xpath(locator_text)).sendKeys((text), Keys.ENTER);
    }
    public void clickDropdownHasEnterAndClick(String locator, String locator_text, String text){
        driver.findElement(By.xpath(locator)).click();
        driver.findElement(By.xpath(locator_text)).sendKeys((text), Keys.ENTER);
        driver.findElement(By.xpath(locator)).click();
    }    public void clickDropdownHasEnterAndClick1(String locator, String locator_text, String text){
        driver.findElement(By.xpath(locator)).click();
        driver.findElement(By.xpath(locator_text)).sendKeys((text), Keys.ENTER);
        Actions action = new Actions(driver);
        //Ctrl + a để bôi đen
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.DELETE).build().perform();
//        action.keyDown( Keys.CONTROL ).sendKeys( "a" ).build().perform();
    }
    public void chooseDropdown(String locator, String text){
        Select select_parent = new Select(driver.findElement(By.xpath(locator)));
        select_parent.selectByVisibleText(text);
    }

    public String getText(String locator){
        return driver.findElement(By.xpath(locator)).getText();
    }
    public Boolean checkDisplayElement(String locator){
        return driver.findElement(By.xpath(locator)).isDisplayed();
    }
    public void clearText(String locator){
        driver.findElement(By.xpath(locator)).clear();
    }
    public static void scrollToElementWithJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement element = driver.findElement(By.xpath(locator));
//        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("window.scrollTo(0,500)");
    }

    /**
     * Wait for Page loaded
     * Chờ đợi trang tải xong (Javascript tải xong)
     */
    public static void waitForPageLoaded(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            System.out.println("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }
    }
}
