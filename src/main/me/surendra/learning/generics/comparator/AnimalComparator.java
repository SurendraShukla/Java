package me.surendra.learning.generics.comparator;

import java.util.Comparator;

class AnimalComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.size - o2.size;
    }
    //in this way, all sub classes of Animal can use this comparator.
}

