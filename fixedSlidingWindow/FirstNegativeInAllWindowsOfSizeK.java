package fixedSlidingWindow;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class FirstNegativeInAllWindowsOfSizeK {
    public static int[] getFirstNegativeInAllWindowsOfSizeK(int[] array, int k) {
        if (array == null || array.length == 0 || k <= 0) {
            return new int[0];
        }
        int[] result = new int[array.length - k + 1];
        int resultIndex = 0;

        Queue<Integer> allNegativeIndices = new LinkedList<>();
        for (int index = 0; index < array.length; index++) {
            if (array[index] < 0) {
                allNegativeIndices.add(index);
            }
        }

        for(int start = 0, end = k - 1; start < array.length - k + 1 && end < array.length; start++, end++) {
            while(!allNegativeIndices.isEmpty() && allNegativeIndices.peek() < start) {
                allNegativeIndices.poll();
            }
            if (!allNegativeIndices.isEmpty() && allNegativeIndices.peek() >= start && allNegativeIndices.peek() <= end) {
                result[resultIndex++] = allNegativeIndices.peek(); 
            } else {
                result[resultIndex++] = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        int[] result = getFirstNegativeInAllWindowsOfSizeK(array, k);
        System.out.println("First negatives for " + Arrays.toString(array));
        System.out.println(Arrays.toString(result));
    }
}
