package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    WebDriver wd;




    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("http://telrane.web.app/");
    }
    public void stop(){
        wd.quit();

    }
}
