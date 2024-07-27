package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EventListener;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    //WebDriver wd;
    HelperUser helperUser;
    HelperContact helperContact;
    EventFiringWebDriver wd;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    public void init(){
        //wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://telranedu.web.app/home");
        logger.info("All tests run in Chrome Browser");
        logger.info("The link--->"+ wd.getCurrentUrl());
        helperUser = new HelperUser(wd);
        helperContact=new HelperContact(wd);
        wd.register(new ListenerWD(logger));
    }


    public HelperContact getHelperContact() {
        return helperContact;
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public void stop(){
        wd.quit();

    }
}
