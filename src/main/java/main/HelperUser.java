package main;

import moodels.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HelperUser extends HelperBase{
    public boolean isLogged(){
        return  isElementPresent(By.xpath("//button[text()='Sign Out']"));
    };


    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegostrationForm(){
//        WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login']"));
//        loginTab.click();
        click(By.cssSelector("a[href='/login']"));
    }


    public void fillRegistrationForm(String email,String password){
        type(By.xpath("//*[@name='email']"),email);
        type(By.xpath("//*[@name='password']"),password);
    }
//    public void fillRegistrationForm(User user){
//        type(By.xpath("//*[@name='email']"), user.getEmail());
//        type(By.xpath("//*[@name='la']"), user.getPassword());
//    }
    public void fillRegistrationForm(User user){
        type(By.xpath("//*[@name='email']"), user.getEmail());
        type(By.xpath("//*[@name='password']"), user.getPassword());
    }
    public void submitLogin(){
//        WebElement submitBtn = wd.findElement(By.xpath("//button[@type='submit']"));
//        submitBtn.click();
        click(By.xpath("//button[@type='submit']"));
    }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));

    }

    public void submitRegistration() {
        click(By.xpath("//button[@name='registration']"));
    }


    public void login(User user) {
        openLoginRegostrationForm();
        fillRegistrationForm(user);
        submitLogin();
    }
}
