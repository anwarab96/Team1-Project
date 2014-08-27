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
    public void search() throws InterruptedException {

        System.out.print("Hello");
        findId_InputValue("blq-search-q","politics");
        sleep(10);
//        driver.findElement(By.id("blq-search-btn")).submit();
        pressEnter("blq-search-btn");
        sleep(10);


    }
}
