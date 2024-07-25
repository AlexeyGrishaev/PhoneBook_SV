package test;

import moodels.User;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RemoveContactTests extends  TestBase{
    @BeforeMethod
    public void preCondition(){
        User user = User.builder()
                .email("locker@gmail.com")
                .password("Qwerty1234!")
                .build();
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(user);

        }
        app.getHelperContact().providerContacts();
    }
    @Test
    public void removeFirstContact(){
        Assert.assertEquals(app.getHelperContact().removeOneContact(),1);
    }
    @Test
    public void removeAllContacts(){
        app.getHelperContact().removeAllContacts();
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());
    }
}
