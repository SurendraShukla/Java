package me.surendra.leetcode.array;

/**
 * @see <a href="https://leetcode.com/problems/utf-8-validation/">UTF-8 Validation</a>
 */
public class Utf8Validator {

    /*
        Time complexity: O(n)
        Space complexity: O(1)
     */
    public boolean validUtf8UsingRange(final int[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] >= 248) {
                return false;
            }
            if (data[i] >= 1 && data[i] < 128) {
                continue;
            }
            if (data[i] >= 128 && data[i] < 192) {
                return false;
            }
            if (data[i] >= 192 && data[i] < 224) {
                if (!validUtf8(data, i, 1)) {
                    return false;
                }
                i += 1;
            }
            if (data[i] >= 224 && data[i] < 240) {
                if (!validUtf8(data, i, 2)) {
                    return false;
                }
                i += 2;
            }
            if (data[i] >= 240 && data[i] < 248) {
                if (!validUtf8(data, i, 3)) {
                    return false;
                }
                i += 3;
            }
        }
        return true;
    }

    private boolean validUtf8(final int[] data, int idx, int k) {
        idx++;
        while (idx < data.length && k != 0) {
            if (data[idx] < 128 || data[idx] > 192) {
                return false;
            }
            idx++;
            k--;
        }
        return k == 0;
    }


    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public boolean validUtf8(final int[] data) {

        // Number of bytes in the current UTF-8 character
        int numberOfBytesToProcess = 0;

        // For each integer in the data array.
        for (int i = 0; i < data.length; i++) {

            // Get the binary representation. We only need the least significant 8 bits
            // for any given number.
            String binRep = Integer.toBinaryString(data[i]);
            binRep = binRep.length() >= 8
                    ? binRep.substring(binRep.length() - 8)
                    : "00000000".substring(binRep.length() % 8) + binRep;

            // If this is the case then we are to start processing a new UTF-8 character.
            if (numberOfBytesToProcess == 0) {

                // Get the number of 1s in the beginning of the string.
                for (int j = 0; j < binRep.length(); j++) {
                    if (binRep.charAt(j) == '0') {
                        break;
                    }

                    numberOfBytesToProcess += 1;
                }

                // 1 byte characters
                if (numberOfBytesToProcess == 0) {
                    continue;
                }

                // Invalid scenarios according to the rules of the problem.
                if (numberOfBytesToProcess > 4 || numberOfBytesToProcess == 1) {
                    return false;
                }

            } else {

                // Else, we are processing integers which represent bytes which are a part of
                // a UTF-8 character. So, they must adhere to the pattern `10xxxxxx`.
                if (!(binRep.charAt(0) == '1' && binRep.charAt(1) == '0')) {
                    return false;
                }
            }

            // We reduce the number of bytes to process by 1 after each integer.
            numberOfBytesToProcess -= 1;
        }

        // This is for the case where we might not have the complete data for
        // a particular UTF-8 character.
        return numberOfBytesToProcess == 0;
    }

}
