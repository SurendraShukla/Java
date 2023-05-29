package me.surendra.event;

final class Size {

    /**
     * @param objectArray the array to examine.
     * @param <T>         the type of object in the array.
     * @return the size of the array, or zero if the array is null.
     */
    static <T> int of(final T[] objectArray) {
        return (objectArray != null) ? objectArray.length : 0;
    }


    /**
     * @param string a string to measure (String, StringBuilder, StringBuffer, etc).
     * @return the length of the string, or zero if null.
     */
    static int of(final CharSequence string) {
        return (string != null) ? string.length() : 0;
    }


    /**
     * @param objectArray the array to examine.
     * @param <T>         the type of object in the array.
     * @return true if the array is null or has zero length, false otherwise.
     */
    static <T> boolean isEmpty(final T[] objectArray) {
        return of(objectArray) == 0;
    }

    /**
     * @param string a string to examine (String, StringBuilder, StringBuffer, etc).
     * @return true if the string is null or has zero length, false otherwise.
     */
    static boolean isEmpty(final CharSequence string) {
        return of(string) == 0;
    }
}
