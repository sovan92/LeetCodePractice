# Kadane's algorithm


```java

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
    }
}



```
