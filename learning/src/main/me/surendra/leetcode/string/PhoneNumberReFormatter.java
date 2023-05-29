package me.surendra.leetcode.string;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/reformat-phone-number/">Reformat Phone Number</a>
 */
public class PhoneNumberReFormatter {

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public String reformatNumberUsingString(String number) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            char aChar = number.charAt(i);
            if (aChar == ' ' || aChar == '-') {
                continue;
            } else {
                stringBuilder.append(aChar);
            }
        }
        String tmpStr = stringBuilder.toString();
        StringBuilder returnStringBuilder = new StringBuilder();
        while(tmpStr.length() > 4) {
            returnStringBuilder.append(tmpStr.substring(0, 3) + "-");
            tmpStr = tmpStr.substring(3);
        }
        if(tmpStr.length() == 4) {
            returnStringBuilder.append(tmpStr.substring(0, 2) + "-");
            returnStringBuilder.append(tmpStr.substring(2));
        }else{
            returnStringBuilder.append(tmpStr);
        }
        return returnStringBuilder.toString();
    }

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public String reformatNumberUsingCharacterQueue(String number) {
        final Queue<Character> phoneNumbers = new LinkedList<>();
        for (int i = 0; i < number.length(); i++) {
            char aChar = number.charAt(i);
            if (aChar == ' ' || aChar == '-') {
                continue;
            }else{
                phoneNumbers.add(aChar);
            }
        }
        int counter = 0;
        final StringBuilder stringBuilder = new StringBuilder();
        while(phoneNumbers.size() > 4) {
            while(counter !=3 && !phoneNumbers.isEmpty()) {
                stringBuilder.append(phoneNumbers.poll());
                counter++;
                if (counter % 3 == 0) {
                    stringBuilder.append("-");
                }
            }
            counter = 0;
        }
        if (phoneNumbers.size() == 4) {
            int tmpCounter = 0;
            while(!phoneNumbers.isEmpty()) {
                if (tmpCounter == 2) {
                    stringBuilder.append("-");
                }
                stringBuilder.append(phoneNumbers.poll());
                tmpCounter++;
            }
        }else{
            while(!phoneNumbers.isEmpty()) {
                stringBuilder.append(phoneNumbers.poll());
            }
        }
        return stringBuilder.toString();
    }

}
