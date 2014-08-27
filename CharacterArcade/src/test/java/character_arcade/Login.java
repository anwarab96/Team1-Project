package character_arcade;

import common.CommonApi;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Created by Abuhena on 8/24/2014.
 */
public class Login extends CommonApi {

    @Test
    public void login() throws InterruptedException {
        driver.findElement(By.cssSelector(".login_btn")).click();
        WebElement outerIframe = driver.findElement(By.cssSelector("#surf-xdm iframe:nth-child(1)"));
        driver.switchTo().frame(outerIframe);
        WebElement innerIframe = driver.findElement(By.cssSelector("#display-frame"));
        driver.switchTo().frame(innerIframe);
        findId_InputValue("input_username","test1");
        sleep(5);
        findId_InputValue("input_password","password");
        sleep(5);
        driver.findElement(By.id("show_password")).click();
        sleep(5);
        driver.findElement(By.id("button_submit")).click();
        driver.switchTo().defaultContent();
    }
}
