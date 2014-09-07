package common;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
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

    @Parameters({"url", "useSauceLabs","username", "key", "os", "browser", "browserVersion", "name"})
    @BeforeMethod
    public void setup(@Optional("http://www.google.com") String url,
                      @Optional("false") boolean useSauceLabs,
                      @Optional("aazad01") String username,
                      @Optional("f4fbe71d-d579-4a04-8040-101c386892fb") String key,
                      @Optional("Windows 8.1") String os,
                      @Optional("firefox") String browser,
                      @Optional("31.0") String browserVersion,
                      @Optional("Test") String name) throws Exception {

        if(useSauceLabs==true){
            //Run in saucelabs
            getSauceLabDriver(os, browser, browserVersion, username, key, name);
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
                                       String key,
                                       String name)throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setCapability("platform", os);
        capabilities.setVersion(browserVersion);
        capabilities.setCapability("name",name);
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

    public List<WebElement> getCSSWebElement (String locator){
        List<WebElement> elementList = new LinkedList<>();
        elementList = driver.findElements(By.cssSelector(locator));
        return elementList;
    }

    public List<WebElement> getXWebElement (String locator){
        List<WebElement> elementList = new LinkedList<>();
        elementList = driver.findElements(By.xpath(locator));
        return elementList;
    }



    public void search(String value, String locator){
        findId_InputValue(locator,value);
        findId_InputValue(locator,Keys.ENTER);
    }

    private void findId_InputValue(String locator, Keys keys) {
        switch (locatorType(locator)){
            case "id":
                driver.findElement(By.id(locator)).sendKeys(keys);
                break;
            case "css":
                driver.findElement(By.cssSelector(locator)).sendKeys(keys);
                break;
            case "xpath":
                driver.findElement(By.xpath(locator)).sendKeys(keys);
                break;
        }
    }

    public void findId_InputValue(String locator,String value){
        switch (locatorType(locator)){
            case "id":
                driver.findElement(By.id(locator)).sendKeys(value);
                break;
            case "css":
                driver.findElement(By.cssSelector(locator)).sendKeys(value);
                break;
            case "xpath":
                driver.findElement(By.xpath(locator)).sendKeys(value);
                break;
        }
    }


    public void pressEnter(String locator){
        switch (locatorType(locator)){
            case "id":
                driver.findElement(By.id(locator)).sendKeys(Keys.ENTER);
                break;
            case "css":
                driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
                break;
            case "xpath":
                driver.findElement(By.xpath(locator)).sendKeys(Keys.ENTER);
                break;
        }
    }

    public String locatorType (String locator){
        if(driver.findElement(By.id(locator)).isEnabled()){
            System.out.println("locator:" + locator + "id");
            return "id";
        }
        else if(driver.findElement(By.cssSelector(locator)).isEnabled()){
            System.out.println("locator:" + locator + "css");
            return "css";
        }
        else if(driver.findElement(By.xpath(locator)).isEnabled()){
            System.out.println("locator:" + locator + "xpath");
            return "xpath";
        }
        return locator;
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

    //mouse hover
    public void mouseHover(String locator){
        WebElement element = driver.findElement(By.cssSelector(locator));
        Actions build = new Actions(driver);
        Actions hover = build.moveToElement(element);
    }

    //Countdown
    public void countdown(int seconds) throws InterruptedException {
        System.out.print("\n");
        for(int i=seconds; i>=0; i--){
            sleep(1);
            System.out.print(i + " ");
        }
    }

    public void clickByCss(String locator){
        driver.findElement(By.cssSelector(locator)).click();
    }
    public void clickByXpath(String locator){
        driver.findElement(By.xpath(locator)).click();
    }
}
