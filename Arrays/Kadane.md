# Kadane's algorithm


```java

/*

    Question: Implement Kadane's Algorithm to find the maximum sum of a contiguous subarray in an array of integers.

    Algorithm: Kadane's Algorithm is a dynamic programming approach that efficiently finds the maximum sum of a contiguous subarray in linear time. The idea is to iterate through the array while maintaining the maximum sum of the subarray ending at the current position.

    */


import java.util.Arrays;

public class KadanesAlgorithm {

    public static int maxSum(int [] nums){
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for(int i = 0; i < nums.length; i++) {
            maxEndingHere = Math.max(0, maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{4,-1,2, -7,3,4})); // Output: 6

        System.out.println(Arrays.toString(getMaxSumLeftAndRight(new int[]{4,-1,2, -7,3,4})));
    }

    public static int[] getMaxSumLeftAndRight(int[] nums) {

        int[] result = new int[2];
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        int maxLeftIndex = 0;
        int maxRightIndex = 0;


        for (rightIndex = 0; rightIndex < nums.length; rightIndex++) {
            maxEndingHere += nums[rightIndex];

            if (maxEndingHere < 0) {
                maxEndingHere = 0;
                leftIndex = rightIndex + 1; // Reset left index
            }

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                maxLeftIndex = leftIndex; // Update left index
                maxRightIndex = rightIndex; // Update right index
            }

        }
        result[0] = maxLeftIndex;
        result[1] = maxRightIndex;
        return result;
    }
}





```
