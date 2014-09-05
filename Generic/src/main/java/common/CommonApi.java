package common;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
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

    @Parameters({"url", "useSauceLabs","username", "key", "os", "browser", "browserVersion"})
    @BeforeMethod
    public void setup(@Optional("http://www.google.com") String url,
                      @Optional("false") boolean useSauceLabs,
                      @Optional("aazad01") String username,
                      @Optional("f4fbe71d-d579-4a04-8040-101c386892fb") String key,
                      @Optional("Windows 8.1") String os,
                      @Optional("firefox") String browser,
                      @Optional("31.0") String browserVersion) throws Exception {

        if(useSauceLabs==true){
            //Run in saucelabs
            getSauceLabDriver(os, browser, browserVersion, username, key);
        }
        else
        {
            driver = new FirefoxDriver();
//            driver.navigate().to(url);
        }
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    public WebDriver getSauceLabDriver(String os,
                                       String browser,
                                       String browserVersion,
                                       String username,
                                       String key)throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setCapability("platform", os);
        capabilities.setVersion(browserVersion);
        // Create the connection to Sauce Labs to run the tests
        this.driver = new RemoteWebDriver(
                new URL("http://" + username + ":" + key + "@ondemand.saucelabs.com:80/wd/hub"),
                capabilities);
        return driver;
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

    public void findId_InputValue(String locator,String value){
        if(driver.findElement(By.id(locator)).isDisplayed()){
            driver.findElement(By.id(locator)).sendKeys(value);
        }
        else if(driver.findElement(By.cssSelector(locator)).isDisplayed()){
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        }
        else {
            return;
        }

    }

    public void pressEnter(String locator){
        if(driver.findElement(By.id(locator)).isDisplayed()){
            driver.findElement(By.id(locator)).sendKeys(Keys.ENTER);
        }
        else if(driver.findElement(By.cssSelector(locator)).isDisplayed()){
            driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
        }
        else {
            return;
        }
    }

    //Handle Alerts and Pop-ups
    public void okAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void cancelAlert(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
}
