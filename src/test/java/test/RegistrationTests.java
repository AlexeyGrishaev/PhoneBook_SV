package test;

import moodels.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccess(){

//        Random random = new Random();
//        int i = random.nextInt(1000)+1000;
        int z = (int) (System.currentTimeMillis()/1000)%3600;
        app.getHelperUser().openLoginRegostrationForm();
        app.getHelperUser().fillRegistrationForm("locker"+z+"@gmail.com","Qwerty1234!");
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLogged());

    }
    @Test
    public void registrationSuccessModel(){

//        Random random = new Random();
//        int i = random.nextInt(1000)+1000;
        int z = (int) (System.currentTimeMillis()/1000)%3600;

        User user = new User().setEmail("locker"+z+"@gmail.com").setPassword("Qwerty1234!");
        app.getHelperUser().openLoginRegostrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLogged());

    }
    @Test
    public void registrationWrongEmail(){

//        Random random = new Random();
//        int i = random.nextInt(1000)+1000;
        int z = (int) (System.currentTimeMillis()/1000)%3600;

        User user = new User().setEmail("locker"+z+"gmail.com").setPassword("Qwerty1234!");
        app.getHelperUser().openLoginRegostrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));

    }
    @Test
    public void registrationWrongPassword(){

//        Random random = new Random();
//        int i = random.nextInt(1000)+1000;
        int z = (int) (System.currentTimeMillis()/1000)%3600;

        User user = new User().setEmail("locker"+z+"@gmail.com").setPassword("Qwerty123");
        app.getHelperUser().openLoginRegostrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));

    }

}
