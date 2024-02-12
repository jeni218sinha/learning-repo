package variableSlidingWindow;

import java.util.*;

public class LongestSubstringWithoutRepeatingChars {

    public static String getLongestSubstringWithoutRepeatingChars(String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        int start = 0, end = 0, maxStart = -1, maxEnd = -1, maxLength = 0;
        Map<Character, Integer> windowCharCounts = new HashMap<>();
        while (end < string.length()) {
            char ch = string.charAt(end);
            if (windowCharCounts.get(ch) == null) {
                // not present we can add remembering its index
                windowCharCounts.put(ch, end);
                if (end - start + 1 > maxLength) {
                    maxLength = end - start + 1;
                    maxStart = start;
                    maxEnd = end;
                }
            } else {
                // only one count of a char can be present in window
                start = windowCharCounts.get(ch) + 1;
                windowCharCounts.put(ch, end);
            }
            end++;
        }
        return maxEnd == -1 ? null : string.substring(maxStart, maxEnd + 1);
    }

    public static void main(String[] args) {
        String string = "ABDEFGABEF";
        String result = getLongestSubstringWithoutRepeatingChars(string);
        System.out.println("Longest substring in :" + string + " without any repeating chars = " + result);
    }
}
