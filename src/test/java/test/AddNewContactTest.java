package test;

import main.DataProviderContacts;
import moodels.Contact;
import moodels.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContactTest extends TestBase{
    @BeforeMethod
    public void preCondition(){
        User user = new User()
                .setEmail("locker@gmail.com")
                .setPassword("Qwerty1234!");
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(user);

        }
    }


    @Test
    public void addNewContactSuccessAllFields(){
        int i = new Random().nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("Max"+i)
                .lastName("Antena")
                .email("MaxAntena"+i+"@Gmail.com")
                .phone("123456789"+i)
                .address("NY")
                .description("Friend")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().createNewContact(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screenAllFields"+i+".png");
        app.getHelperContact().addContact();

        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
    }
    @Test(dataProvider = "ContactCSV",dataProviderClass = DataProviderContacts.class)
    public void addNewContactSuccessAllFieldsCSV(Contact contact){
        int i = new Random().nextInt(1000)+1000;

        app.getHelperContact().openContactForm();
        app.getHelperContact().createNewContact(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screenAllFields"+i+".png");
        app.getHelperContact().addContact();

        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
    }
    @Test(dataProvider = "contactSuccess",dataProviderClass = DataProviderContacts.class)
    public void addNewContactSuccessReqFields(Contact contact){
        int i = new Random().nextInt(1000)+1000;

        app.getHelperContact().openContactForm();
        app.getHelperContact().createNewContact(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screenReqFields"+i+".png");
        app.getHelperContact().addContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
    }


    @Test
    public void addNewContactWrongName(){
        int i = new Random().nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("")
                .lastName("Antena")
                .email("MaxAntena@Gmail.com")
                .phone("1444567894444")
                .address("NY")
                .description("Wrong name")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().createNewContact(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screenWrongName"+i+".png");
        app.getHelperContact().addContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }
    @Test
    public void addNewContactWrongLastName(){
        int i = new Random().nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("Max")
                .lastName("")
                .email("MaxAntena@Gmail.com")
                .phone("1444567894444")
                .address("NY")
                .description("Wr last name")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().createNewContact(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screenLastName"+i+".png");
        app.getHelperContact().addContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }
    @Test(dataProvider = "contactWrongPhone",dataProviderClass = DataProviderContacts.class)
    public void addNewContactWrongPhone(Contact contact){
        int i = new Random().nextInt(1000)+1000;

        app.getHelperContact().openContactForm();
        app.getHelperContact().createNewContact(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screenWrongPhone"+i+".png");
        app.getHelperContact().addContact();
        Assert.assertTrue(app.getHelperContact().isAlertPresent(" Phone"));

    }
    @Test
    public void addNewContactWrongEmail(){
        int i = new Random().nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("Max")
                .lastName("Antena")
                .email("MaxAntenaGmail.com")
                .phone("144456789111")
                .address("NY")
                .description("Wr email")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().createNewContact(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screenWrongEmail"+i+".png");
        app.getHelperContact().addContact();
        Assert.assertTrue(app.getHelperContact().isAlertPresent("Email"));

    }
    @Test
    public void addNewContactWrongAddress(){
        int i = new Random().nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("Max")
                .lastName("Antena")
                .email("MaxAntena@Gmail.com")
                .phone("144456789111")
                .address("")
                .description("wr Address")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().createNewContact(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screenWrongAddress"+i+".png");
        app.getHelperContact().addContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }
//    @AfterMethod
//    public void postCondition(){
//        if(app.getHelperUser().isLogged()){
//            app.getHelperUser().logout();
//        }
//    }
}
