package fixedSlidingWindow;

import java.util.*;

public class CountOccurrenceOfAnagram {

    public static boolean isValidAnagram(Map<Character, Integer> patternCounts, Map<Character, Integer> currWindowCounts) {
        for(Character ch: patternCounts.keySet()) {
            if (!currWindowCounts.containsKey(ch) || patternCounts.get(ch) != currWindowCounts.get(ch)) {
                return false;
            }
        }
        return true;
    }

    public static int getAnagramCounts(String msg, String pattern) {
        if (msg == null || msg.length() == 0 || pattern == null || pattern.length() == 0) {
            return 0;
        }
        int anagramCount = 0, start = 0, end = 0;
        Map<Character, Integer> patternCounts = new HashMap<>();
        Map<Character, Integer> currWindowCounts = new HashMap<>();

        for (int index = 0; index < pattern.length(); index++) {
            char ch = pattern.charAt(index);
            patternCounts.put(ch, patternCounts.getOrDefault(ch, 0) + 1);
        }

        while(end < msg.length()) {
            char ch = msg.charAt(end);
            currWindowCounts.put(ch, currWindowCounts.getOrDefault(ch, 0)+1);
            if (end - start + 1 == pattern.length()) {
                if (isValidAnagram(patternCounts, currWindowCounts)) {
                    anagramCount++;
                }
                char startChar = msg.charAt(start);
                currWindowCounts.put(startChar, currWindowCounts.get(startChar) - 1);
                if (currWindowCounts.get(startChar) == 0) {
                    currWindowCounts.remove(startChar);
                }
                start++;
            }
            end++;
        }
        return anagramCount;
    }


    public static void main(String[] args) {
        String msg = "forxxorfxdofr";
        String pattern = "for";
        int counts = getAnagramCounts(msg, pattern);
        System.out.println("Anagrams of :" + pattern + " in msg: "+ msg);
        System.out.println(counts);
    }
}
