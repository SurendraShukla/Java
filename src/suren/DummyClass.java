package suren;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

enum Status {
    DISABLE,
    ACTIVE,
    INACTIVE
}


public class DummyClass {

    public String getUsername(String email) {
        return email.replace("@cdk.com" , "");
//        int start = email.indexOf("@cdk.com");
//        String returnStr = email;
//
//        if (start > 0) {
//            returnStr = email.substring(0, start);
//        }
//
//        return returnStr;
    }

    @Test
    public void test1() {
//        System.out.println(Status.valueOf("DISABLE"));
        System.out.println(Status.values()[new Random().nextInt(Status.values().length)]);

        DummyClass unit = new DummyClass();
        Assert.assertEquals("surendra.shukla@adp.com", unit.getUsername("surendra.shukla@adp.com"));

        Assert.assertEquals("surendra.shukla", unit.getUsername("surendra.shukla@cdk.com"));
        Assert.assertEquals("surendra.shukla", unit.getUsername("surendra.shukla"));


        List<String> cities = Arrays.asList("Milan", "London", "New York", "San Francisco");
        System.out.println(String.join(",", cities));
    }

}
