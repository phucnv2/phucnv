package com.anhtester.common;

import com.anhtester.locator.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.time.Duration;

import static com.anhtester.locator.LocatorsCRM.*;

public class BaseTest {

    public WebDriver driver;
    public String URL = "https://crm.anhtester.com/admin/authentication";
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
    public void login(){
        driver.get(URL);
        Assert.assertTrue(driver.findElement(By.xpath(headerLoginPage)).isDisplayed(),"Fail!");
        setText(inputEmail,Username);
        setText(inputPassword,Password);
        clickElement(buttonLogin);
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

        driver.get(URL);
        Assert.assertTrue(driver.findElement(By.xpath(headerLoginPage)).isDisplayed(),"Fail!");
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
    public void getAttribute(String locator, String text){
        driver.findElement(By.xpath(locator)).getAttribute(text);
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
    }
}
