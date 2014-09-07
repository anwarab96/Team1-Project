package ali_express;

import common.CommonApi;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by Abuhena on 8/27/2014.
 */
public class TopSearch extends CommonApi{


    @Test
    public void topResult() throws InterruptedException {
        sleep(1);
        driver.findElement(By.cssSelector("#newuser-popup-wrapper > .user-action-mod > .user-action-btn > .go-contiune-btn")).click();
        findId_InputValue("search-key", "Toys");
        driver.findElement(By.id("search-cate")).click();
        driver.findElement(By.cssSelector(".sc-box li:nth-child(5)")).click();
        driver.findElement(By.cssSelector("input.search-button")).click();
        pressEnter("linkFreeShip");
        sleep(3);
    }
}
