package me.surendra.learning.generics;

import java.util.ArrayList;

public class GenericMethodOnly {

    // Method is generic but Class is not
    public <T> void createArray(T sample){
        ArrayList<T> list = new ArrayList<T>();
        list.add(sample);
    }
}

/*
 https://stackoverflow.com/questions/33754034/generic-method-java-6-t-before-return-type
*/
