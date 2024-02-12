package fixedSlidingWindow;
import java.util.Arrays;

public class MaxSumSubarrayOfSizeK {

    public static int[] getMaxSumSubarrayOfSizeK(int[] array, int k) {
        if (array == null || array.length == 0 || k <= 0) {
            return new int[0];
        }

        int maxSum = Integer.MIN_VALUE, start = 0, end = 0, sum = 0;
        int maxSumStartIndex = 0, maxSumEndIndex = 0;        

        while(end < array.length) {
            if (end < k) {
                sum += array[end];
            } else {
                sum += array[end] - array[start];
                start++;
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxSumStartIndex = start;
                maxSumEndIndex = end;
            }
            end++;
        }
        return new int[]{maxSumStartIndex, maxSumEndIndex, maxSum};
    }

    public static void main(String args[]) {
        int[] array = new int[] {2, 6, 8, 1, 10, 3};
        int k = 3;
        int[] result = getMaxSumSubarrayOfSizeK(array, k);
        System.out.println(Arrays.toString(result));
        System.out.println("Max Sum of " + result[2] + " is obtained using following");
        for(int start = result[0]; start <= result[1]; start++) {
            System.out.print(" " + array[start]);
        }
        System.out.println();
    }
}