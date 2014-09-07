package facebook;

import common.CommonApi;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Abuhena on 9/7/2014.
 */
public class Homepage extends CommonApi {
    @Parameters({"username","password"})
    @Test
    public void login(String username, String password) throws InterruptedException {
        findId_InputValue("email",username);
        findId_InputValue("pass",password);
        countdown(2);
        clickByCss("#loginbutton");
        countdown(2);
    }

    @Test
    public void about(){
        clickByXpath("/html/body/div/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[9]/a");
        try {
            countdown(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
