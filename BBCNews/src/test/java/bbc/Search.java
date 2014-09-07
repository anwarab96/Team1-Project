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

        System.out.print("Top Headlines\n");
        findId_InputValue("blq-search-q","politics");
        sleep(2);

        pressEnter("blq-search-btn");
        sleep(2);

        driver.findElement(By.xpath("//*[@id=\"orb-modules\"]/section[2]/header/ol/li[2]/a")).click();
        LinkedList<String> topResult = new LinkedList<>();

        List<WebElement> result = getCSSWebElement("#orb-modules > section.search-content > ol li");

        for (int i=0; i<result.size(); i++){
            String headline = result.get(i).findElement(By.tagName("h1")).getText();
            topResult.add(headline);
            System.out.println(topResult.get(i));
        }

        sleep(10);

    }
}
