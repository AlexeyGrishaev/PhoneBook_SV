package main;

import moodels.Contact;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContacts  {

    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactSuccess() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                Contact.builder()
                        .name("Tony")
                        .lastName("Soprano")
                        .phone("123456789101")
                        .email("Tony@gmail.com")
                        .address("NY")
                        .description("Friend")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("koony")
                        .lastName("Soprano")
                        .phone("123456789333")
                        .email("Kony@gmail.com")
                        .address("LA")
                        .description("Friend")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Pony")
                        .lastName("Soprano")
                        .phone("444456789444")
                        .email("Pony@gmail.com")
                        .address("OL")
                        .description("Friend")
                        .build()
        });
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> contactWrongPhone() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                Contact.builder()
                        .name("Molly")
                        .lastName("Soprano")
                        .phone("1234")
                        .email("Tony@gmail.com")
                        .address("NY")
                        .description("Friend")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Lenny")
                        .lastName("Soprano")
                        .phone("1234987")
                        .email("Kony@gmail.com")
                        .address("LA")
                        .description("Friend")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Kony")
                        .lastName("Soprano")
                        .phone("444444")
                        .email("Pony@gmail.com")
                        .address("OL")
                        .description("Friend")
                        .build()
        });
        return list.iterator();
    }
}
