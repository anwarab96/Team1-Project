package common;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * common
 * Created by: Abuhena Azad
 * On: 8/14/2014, 7:06 PM
 */
public class CommonApi {

    public WebDriver driver = null;

    @Parameters({"url"})
    @BeforeMethod
    public void setup(String url){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void shutdown(){
        driver.quit();
    }

    public void sleep(int seconds) throws InterruptedException{
        Thread.sleep(seconds*1000);
    }

    public void goBack(){
        driver.navigate().back();
    }

    public void refresh(){
        driver.navigate().refresh();
    }

    public void goForward(){
        driver.navigate().forward();
    }

    public List<WebElement> getWebElement (String locator){
        List<WebElement> elementList = new LinkedList<>();
        elementList = driver.findElements(By.cssSelector(locator));
        return elementList;
    }

    public void findIdInputValue(String locator,String value){
        driver.findElement(By.id(locator)).sendKeys(value);
    }

    public void pressEnter(String locator){
        driver.findElement(By.id(locator)).sendKeys(Keys.ENTER);
    }


}
