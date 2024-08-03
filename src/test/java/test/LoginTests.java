package test;

import main.DataProviderUser;
import moodels.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class LoginTests extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            logger.info("Before method finish logout");
        }


    }



    @Test(dataProvider = "loginData",dataProviderClass = DataProviderUser.class)
    public void loginSuccess(String email,String passwor){
       // logger.info("Start loginSuccess");
        logger.info("Test data --> email:'locker@gmail.com password:''Qwerty1234!'");
        User user = new User()
                .setEmail("locker@gmail.com")
                .setPassword("Qwerty1234!");


        app.getHelperUser().openLoginRegostrationForm();
        app.getHelperUser().fillRegistrationForm(email,passwor);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Signed out' present");

    }
    @Test(dataProvider = "loginFile",dataProviderClass = DataProviderUser.class)
    public void loginSuccessFile(User user){
        // logger.info("Start loginSuccess");
        logger.info("Test data --> email:'locker@gmail.com password:''Qwerty1234!'");

        app.getHelperUser().openLoginRegostrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Signed out' present");

    }
    @Test(dataProvider = "loginModels",dataProviderClass = DataProviderUser.class)
    public void loginSuccessModel(User user){
        logger.info("Test data --> email:'locker@gmail.com password:''Qwerty1234!'");

        app.getHelperUser().openLoginRegostrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Signed out' present");
    }
    @Test(groups = "smoke")
    public void loginWrongEmail(){
        logger.info("Test data --> email:'lockergmail.com password:''Qwerty1234!'");
        User user = new User()
                .setEmail("lockergmail.com")
                .setPassword("Qwerty1234!");

        app.getHelperUser().openLoginRegostrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Allert present with error text 'Wrong email or password'");
    }
    @Test
    public void loginWrongPassword(){
        logger.info("Test data --> email:'locker@gmail.com password:''werty1234!'");
        User user = new User()
                .setEmail("locker@gmail.com")
                .setPassword("werty1234!");

        app.getHelperUser().openLoginRegostrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Allert present with error text 'Wrong email or password'");
    }
    @Test
    public void loginUnregisteredUser(){
        logger.info("Test data --> email:'Mocker@gmail.com password:''Qwerty1234!'");
        User user = new User()
                .setEmail("Mocker@gmail.com")
                .setPassword("Qwerty1234!");

        app.getHelperUser().openLoginRegostrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Allert present with error text 'Wrong email or password'");
    }
}
