package com.adp.puzzle;


import java.util.HashSet;
import java.util.Set;
public class Car {

       private static final int CAPACITY = 5;
       private Set<Person> personSet = new HashSet<Person>();
       
       public synchronized void add(Person person) {
               if (personSet.size() >= CAPACITY) {
                     throw new IllegalStateException("I'm full");
               } else {
                      boolean isPersonAdded = personSet.add(person);
               }
        }
        public synchronized void done() {
               if (personSet.size() == 10) {
                  // The goal is to reach this line
                  System.out.println(" Car can accomodate 10 person(s) !");
                }
        }
} 