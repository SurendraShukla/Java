package me.surendra.learning.generics;

import java.util.ArrayList;

/**
 * Generics provides Type Safety at compile. Provides Flexibility.
 */
class GenericClass<T> {

    // Method belongs to GenericMethodOnly Class so return <T> before return type is not required.
    public void createArray(T sample){
        ArrayList<T> list = new ArrayList<T>();
        list.add(sample);
    }

}
