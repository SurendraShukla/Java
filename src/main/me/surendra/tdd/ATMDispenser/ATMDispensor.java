package me.surendra.tdd.ATMDispenser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by deyv on 24/03/16.
 */
public class ATMDispensor {

    private static final Integer[] availableDemominations = new Integer[] {500, 100, 20, 10};

    public static ATMDispensor create() {
        return new ATMDispensor();
    }

    public Integer[] dispense(int amount) {
        List<Integer> notes = new ArrayList<Integer>();
        for (final Integer denomination : availableDemominations) {
            amount = addNotes(amount, notes, denomination);
        }

        if(amount > 0) {
            throw new IllegalArgumentException();
        }

        return notes.toArray(new Integer[notes.size()]);
    }

    private Integer addNotes(int amount, final List<Integer> notes, final int denomination) {
        int noOfNotes = amount / denomination;
        notes.addAll(Collections.nCopies(noOfNotes, denomination));
        return amount % denomination;
    }

}
