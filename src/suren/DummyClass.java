package suren;

import org.junit.Test;

enum Status {
    DISABLE,
    ACTIVE,
    INACTIVE
}


class SurenStatic {

    public static String name = "Surendra";

    public static void printName() {
//        System.out.println(this);
        System.out.println(SurenStatic.name);
    }

    public void echoName() {
        System.out.println(this.name);
        System.out.println(SurenStatic.name);
    }

}

public class DummyClass extends Object {


    @Test
    public void test1() {

//        SurenStatic.printName();

        SurenStatic obj = new SurenStatic();
        System.out.println((obj instanceof Object));
//        System.out.println(obj.name);
        obj.echoName();
//        obj.printName();


////        System.out.println(Status.valueOf("DISABLE"));
//        System.out.println(Status.values()[new Random().nextInt(Status.values().length)]);
//
//        DummyClass unit = new DummyClass();
//        Assert.assertEquals("surendra.shukla@adp.com", unit.getUsername("surendra.shukla@adp.com"));
//
//        Assert.assertEquals("surendra.shukla", unit.getUsername("surendra.shukla@cdk.com"));
//        Assert.assertEquals("surendra.shukla", unit.getUsername("surendra.shukla"));
//
//
//        List<String> cities = Arrays.asList("Milan", "London", "New York", "San Francisco");
//        System.out.println(String.join(",", cities));
    }


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

}
