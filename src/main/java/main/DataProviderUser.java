package main;

import moodels.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> example()  {
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> loginFile() throws IOException{
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/login.csv")));
        String line = reader.readLine();
        while(line!=null){
            String[]all = line.split(",");
            list.add(new Object[]{new User().setEmail(all[0]).setPassword(all[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> loginData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"locker@gmail.com", "Qwerty1234!"});
        list.add(new Object[]{"mara@gmail.com", "Mmar123456$"});
        list.add(new Object[]{"sonya@gmail.com", "Ss12345$"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> loginModels() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setEmail("locker@gmail.com").setPassword("Qwerty1234!")});
        list.add(new Object[]{new User().setEmail("mara@gmail.com").setPassword("Mmar123456$")});
        list.add(new Object[]{new User().setEmail("sonya@gmail.com").setPassword("Ss12345$")});
        return list.iterator();
    }
}
