package variableSlidingWindow;

import java.util.Arrays;

public class LargestSubArrayWithSumK {
    public static int getLargestSubArrayWithSumK(int[] array, int sumk) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int start = 0, end = 0, windowSum = 0, maxLength = 0;

        while(end < array.length) {
            windowSum += array[end];

            if (windowSum < sumk) {
                end++;
            } else if (windowSum == sumk) {
                // found a subarray
                if (end - start + 1 > maxLength) {
                    maxLength = end - start + 1;
                }
                end++;
            } else {
                while(windowSum > sumk) {
                    windowSum -= array[start];
                    start++;
                }
                if(windowSum == sumk){
                    if (end - start + 1 > maxLength) {
                        maxLength = end - start + 1;
                    }
                }
                end++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] array = new int[] {4, 1, 1, 1, 2, 3, 5};
        int sumk = 5;
        int result = getLargestSubArrayWithSumK(array, sumk);
        System.out.println("Largest Sum Subarray for sum " + sumk + " from "+ Arrays.toString(array) + " = "+ result);
    }
}
