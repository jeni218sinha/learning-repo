package variableSlidingWindow;

import java.util.*;

public class LongestSubstringWithKDistinctChars {

    public static String getLongestSubstringWithKDistinctChars(String string, int k) {
        if (string == null || string.length() == 0 || k == 0 || k > string.length()) {
            return null;
        }
        int start = 0, end = 0, maxLength = 0, maxStart = -1, maxEnd = -1;
        Map<Character, Integer> windowCharsCounts = new HashMap<>();
        
        while (end < string.length()) {
            char ch = string.charAt(end);
            windowCharsCounts.put(ch, windowCharsCounts.getOrDefault(ch, 0) + 1);
            if (windowCharsCounts.size() < k) {
                end++;
            } else if (windowCharsCounts.size() == k) {
                if (end - start + 1 > maxLength) {
                    maxLength = end - start + 1;
                    maxStart = start;
                    maxEnd = end;
                }
                end++;
            } else {
                while(windowCharsCounts.size() > k) {
                    char startChar = string.charAt(start);
                    windowCharsCounts.put(startChar, windowCharsCounts.get(startChar) - 1);
                    if (windowCharsCounts.get(startChar) == 0) {
                        windowCharsCounts.remove(startChar);
                    }
                    start++;
                }
            }
        }
        return maxStart == -1 ? null : string.substring(maxStart, maxEnd+1);
    }

    public static void main(String[] args) {
        String string = "AABBBCCCDDEEEE";
        int k = 3;
        String longestSubstringWithKDistinctChars = getLongestSubstringWithKDistinctChars(string, k);
        System.out.println("Longest substring for : " + string + " with k : " + k +" distinct chars is");
        System.out.println(longestSubstringWithKDistinctChars);
        string = "AABBCCDD";
        longestSubstringWithKDistinctChars = getLongestSubstringWithKDistinctChars(string, k);
        System.out.println("Longest substring for : " + string + " with k : " + k +" distinct chars is");
        System.out.println(longestSubstringWithKDistinctChars); 
    }
}
