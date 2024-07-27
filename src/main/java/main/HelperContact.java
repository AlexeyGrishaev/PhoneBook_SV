package main;


import moodels.Contact;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.Random;

public class HelperContact extends HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void createNewContact(Contact contact) {

        type(By.xpath("//input[@placeholder='Name']"), contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contact.getDescription());

    }
    public boolean isAddPageStillDisplayed(){
        return isElementPresent(By.xpath("//a[@href='/add'][@class='active']"));
    }
    public void addContact() {
        click(By.xpath("//button/b[text()='Save']"));
    }

    public void openContactForm() {
        pause(500);
        click(By.xpath("//a[@href='/add']"));
    }

    public void openContactContacts() {
        pause(500);
        click(By.xpath("//a[@href='/contacts']"));
    }

    public boolean isContactAddedByName(String name) {
        List<WebElement> list = wd.findElements(By.xpath("//h2"));
        for(WebElement el:list){
            if(el.getText().equals(name)){
                return true;
            }

        }
        return false;
    }

    public boolean isContactAddedByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.xpath("//h3"));
        for(WebElement el:list){
            if(el.getText().equals(phone)){
                return true;
            }

        }
        return false;
    }









    public void providerContacts() {
        if(countOfContacts()<3)
            for (int i = 0; i < 3; i++) {
                addOneContact();
            }

    }

    private int countOfContacts() {
        pause(500);
        List<WebElement> list = wd.findElements(By.xpath("//*[@class='contact-item_card__2SOIM']"));
        return list.size();
    }

    private void addOneContact() {
        int i = new Random().nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("MAX")
                .lastName("MAX"+i)
                .phone("123456789"+i)
                .email("NETK"+i+"@gmail.com")
                .address("NY")
                .description("SEND")
                .build();
        openContactForm();
        createNewContact(contact);
        addContact();
        pause(100);
    }

    public int removeOneContact() {
        int before = countOfContacts();
        pause(500);
        removeContact();
        pause(500);
        int after = countOfContacts();
        return before-after;
    }

    public void removeContact(){
        click(By.xpath("//div[@class='contact-item_card__2SOIM']"));
        pause(500);
        click(By.xpath("//button[text()='Remove']"));
        pause(500);
    }

    public void removeAllContacts() {
        while (countOfContacts()!=0){
            removeContact();
        }
    }
}

