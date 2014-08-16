package bbc;

import common.CommonApi;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

/**
 * bbc
 * Created by: Abuhena Azad
 * On: 8/15/2014, 1:49 AM
 */
public class Search extends CommonApi {

    @Test
    public void Search() throws InterruptedException {

        System.out.print("Hello");
        findIdInputValue("blq-search-q","politics");
        sleep(30*1000);
        driver.findElement(By.id("blq-search-btn")).submit();
        sleep(30*1000);


    }
}
