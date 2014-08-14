package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

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
    public void startUp(String url){
        driver = new FirefoxDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void shutdown(){
        driver.close();
    }

}
