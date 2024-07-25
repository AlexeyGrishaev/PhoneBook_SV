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
            logger.info("Before method finish logout");
        }


    }



    @Test
    public void loginSuccess(){
       // logger.info("Start loginSuccess");
        logger.info("Test data --> email:'locker@gmail.com password:''Qwerty1234!'");
        User user = User.builder()
                .email("locker@gmail.com")
                .password("Qwerty1234!")
                .build();

        app.getHelperUser().openLoginRegostrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Signed out' present");

    }
    @Test
    public void loginSuccessModel(){
        logger.info("Test data --> email:'locker@gmail.com password:''Qwerty1234!'");
        User user = User.builder()
                .email("locker@gmail.com")
                .password("Qwerty1234!")
                .build();
        app.getHelperUser().openLoginRegostrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Signed out' present");
    }
    @Test
    public void loginWrongEmail(){
        logger.info("Test data --> email:'lockergmail.com password:''Qwerty1234!'");
        User user = User.builder()
                .email("lockergmail.com")
                .password("Qwerty1234!")
                .build();
        app.getHelperUser().openLoginRegostrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Allert present with error text 'Wrong email or password'");
    }
    @Test
    public void loginWrongPassword(){
        logger.info("Test data --> email:'locker@gmail.com password:''werty1234!'");
        User user = User.builder()
                .email("locker@gmail.com")
                .password("werty1234!")
                .build();
        app.getHelperUser().openLoginRegostrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Allert present with error text 'Wrong email or password'");
    }
    @Test
    public void loginUnregisteredUser(){
        logger.info("Test data --> email:'Mocker@gmail.com password:''Qwerty1234!'");
        User user = User.builder()
                .email("Mocker@gmail.com")
                .password("Qwerty1234!")
                .build();
        app.getHelperUser().openLoginRegostrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Allert present with error text 'Wrong email or password'");
    }
}
