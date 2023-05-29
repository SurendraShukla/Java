package me.surendra.tdd.RadixConverter;


public class NumberConverter {
    private static final String[] VALUES = { "0", "1", "2", "3", "4", "5", "6",
            "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
            "X", "Y", "Z" };

    // Iterative
    public static String convert(int number, int base) {
        StringBuilder builder = new StringBuilder();
        while (number != 0) {
            builder.append(VALUES[number % base]);
            number = number / base;
        }
        return builder.reverse().toString();
    }
    // Recursive
    public static String convertRecursive(int number, int base) {
        if (number == 0) {
            return "";
        }
        return convertRecursive(number / base, base) + VALUES[number % base];
    }
}

