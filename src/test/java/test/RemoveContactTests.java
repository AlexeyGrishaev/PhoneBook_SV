package test;

import moodels.User;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RemoveContactTests extends  TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        User user = new User()
                .setEmail("locker@gmail.com")
                .setPassword("Qwerty1234!");
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(user);

        }
        app.getHelperContact().providerContacts();
    }
    @Test(groups = "smoke")
    public void removeOneContact(){
        Assert.assertEquals(app.getHelperContact().removeOneContact(),1);
    }
    @Test
    public void removeAllcontacts(){
        app.getHelperContact().removeAllContacts();

        Assert.assertTrue(app.getHelperContact().isNoContactsHereDisplayed());
    }
}
