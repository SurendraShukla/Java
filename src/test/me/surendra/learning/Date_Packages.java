package me.surendra.learning;

import com.sun.tools.javac.util.Pair;
//import org.joda.time.DateTime;

import java.util.Calendar;
import java.util.Date;

public class Date_Packages {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 30);
        Date d = c.getTime();
        System.out.println("30 days after today is: " + d);


        Date d1 = new Date();
        d1.setTime(d1.getTime() + 30L * 24 * 60 * 60 * 1000);
        System.out.println("30 days after today is: " + d1);


//        System.out.println(DateTime.now().plusDays(30));


        Pair<String,String> pairs = new Pair<>("width", "height");
        System.out.println(pairs);
    }

}
