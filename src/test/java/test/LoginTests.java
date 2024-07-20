package test;

import moodels.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }


    }



    @Test
    public void loginSuccess(){

        app.getHelperUser().openLoginRegostrationForm();
        app.getHelperUser().fillRegistrationForm("locker@gmail.com","Qwerty1234!");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }
    @Test
    public void loginSuccessModel(){
        User user = new User().setEmail("locker@gmail.com").setPassword("Qwerty1234!");
        app.getHelperUser().openLoginRegostrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }
    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginRegostrationForm();
        app.getHelperUser().fillRegistrationForm("lockergmail.com","Qwerty1234!");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginRegostrationForm();
        app.getHelperUser().fillRegistrationForm("locker@gmail.com","werty1234!");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
    @Test
    public void loginUnregisteredUser(){
        app.getHelperUser().openLoginRegostrationForm();
        app.getHelperUser().fillRegistrationForm("Mocker@gmail.com","Qwerty1234!");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
}
