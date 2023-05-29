package me.surendra.learning.generics.comparator;

import org.junit.Test;

import java.util.Arrays;

public class AnimalComparatorTest {

    @Test
    public void test() {
        Dog d1 = new Dog(2);
        Dog d2 = new Dog(1);
        Dog d3 = new Dog(3);

        Dog[] dogArray = {d1, d2, d3};
        printDogs(dogArray);

        Arrays.sort(dogArray, new AnimalComparator());
        printDogs(dogArray);

        System.out.println();

        //when you have an array of Cat, same Comparator can be used.
        Cat c1 = new Cat(2);
        Cat c2 = new Cat(1);
        Cat c3 = new Cat(3);

        Cat[] catArray = {c1, c2, c3};
        printDogs(catArray);

        Arrays.sort(catArray, new AnimalComparator());
        printDogs(catArray);
    }


    public static void printDogs(Animal[] animals){
        for(Animal a: animals) {
            System.out.print("size="+a.size + " ");
        }
        System.out.println();
    }

}

