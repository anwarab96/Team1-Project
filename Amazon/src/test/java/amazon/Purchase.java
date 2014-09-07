package amazon;

import common.CommonApi;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by Abuhena on 9/7/2014.
 */
public class Purchase extends CommonApi {

    @Test
    public void candy() throws InterruptedException {
        search("candy", "twotabsearchtextbox");
        countdown(2);
//        driver.findElement(By.cssSelector("#result_0 > h3:nth-child(3) > a:nth-child(1)")).click();
        clickByCss("#result_0 > h3:nth-child(3) > a:nth-child(1)");
        countdown(2);
        //Add to cart
        clickByCss("#add-to-cart-button");
        //Checkout
        clickByCss("html.a-ws.a-js.a-audio.a-video.a-canvas.a-drag-drop.a-geolocation.a-history.a-autofocus.a-input-placeholder.a-textarea-placeholder.a-local-storage.a-touch-scrolling.a-text-shadow.a-box-shadow.a-border-radius.a-border-image.a-opacity.a-transform.a-transition body div#a-page div#cart-page-wrap div#hlb-page-container div#hl-feedback.a-row.a-spacing-base div#hl-feedback-details.a-row div#hl-cart.a-column.a-span8.a-span-last div#huc-msg-boxs.a-row div.a-box.a-color-alternate-background div.a-box-inner div.a-row div#hlb-next-steps.a-column.a-span7.a-text-right.a-span-last span#hlb-ptc-btn.a-button.a-button-primary.hlb-checkout-button span.a-button-inner a.a-button-text.a-text-center");
        countdown(10);

    }
}

