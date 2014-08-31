package bbc;

import common.CommonApi;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

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
        sleep(2);
//        driver.findElement(By.id("blq-search-btn")).submit();
        pressEnter("blq-search-btn");
        sleep(2);

        LinkedList<String> topResult = new LinkedList<>();

        List<WebElement> result = getWebElement(".DateList li");

        for (int i=0; i<result.size(); i++){
            String headline = result.get(i).findElement(By.tagName("a")).getText();
            topResult.add(headline);
            System.out.println(topResult.get(i));
        }

        sleep(10);

    }
}
