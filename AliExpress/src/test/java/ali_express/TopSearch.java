package ali_express;

import common.CommonApi;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Abuhena on 8/27/2014.
 */
public class TopSearch extends CommonApi{

    @Test
    public void topResult() throws InterruptedException {
        findId_InputValue("search-key","Toys");
        sleep(2);
//        driver.findElement(By.id("blq-search-btn")).submit();
        driver.findElement(By.id("search-cate")).click();
        sleep(2);
        driver.findElement(By.cssSelector(".sc-box li:nth-child(5)")).click();
        sleep(2);
        driver.findElement(By.cssSelector("input.search-button")).click();
        sleep(2);
        pressEnter("linkFreeShip");
        sleep(10);
    }
}
