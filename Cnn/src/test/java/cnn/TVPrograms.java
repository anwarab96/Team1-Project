package cnn;

import common.CommonApi;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Abuhena on 9/7/2014.
 */
public class TVPrograms extends CommonApi {

    @Test
    public void login() throws InterruptedException {
        clickByCss("html body#cnnMainPage.cnn_touch div#cnn_hdr div#cnn_hdr-main div.hdr-wrap div#hdr-auth ul li.no-border.no-pad-right a");
        String popupWindow = driver.getWindowHandle();
        driver.switchTo().window(popupWindow);
        clickByCss("div.overlay_close");
        countdown(4);
    }

    @Test
    public void navigation(){
        List<WebElement> program = getXWebElement("/html/body/div[8]/div/div[9]/div/div[1]/h4/form/select");
        for (int i=0; i<program.size(); i++){
            System.out.println(program.get(i).getText());
        }
    }

}

