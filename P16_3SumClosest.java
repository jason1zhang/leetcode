import java.util.Arrays;

/**
 * solutions to leetcode problem 16: 3Sum Closest
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-04-16
 */

 public class P16_3SumClosest {
    public static void main(String[] args) {
        P16_3SumClosest p16_3SumClosest = new P16_3SumClosest();

        p16_3SumClosest.test();
    }

    public void test() {
        // test case 1
        // int[] nums = {-1, 2, 1, -4};
        // int target = 1;

        // test case 2
        // int[] nums = {0, 0, 0};      
        // int target = 1;

        // test case 3, exptected 1
        int[] nums = {1, -3, 3, 5, 4, 1};      
        int target = 1;

        System.out.printf("The 3Sum closest is {%d}\n", threeSumClosest(nums, target));
    }

     /**
      * Problem #:      16
      * Problem:        3Sum Closest
      * Difficulty:     Medium
      * 
      * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
      * Return the sum of the three integers.
      * 
      * You may assume that each input would have exactly one solution.
      * 
      * Example 1:
      * Input: nums = [-1,2,1,-4], target = 1
      * Output: 2
      * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
      * 
      * Example 2:
      * Input:  nums = [0,0,0], target = 1
      * Output: 0
      *
      * Constraints:
      *     - 3 <= nums.length <= 1000
      *     - -1000 <= nums[i] <= 1000
      *     - -10^4 <= target <= 10^4
      */  

    /**
     * 
     * Solution 1: two pointers approach
     * 
     * Result:
     *    - Runtime: 
     * 
     *    - time complexity:    O()
     *    - space complexity:   O()
     * 
     * @param nums an array of integers
     * @param target target integer
     * @return the sum of the three integers
     */
    public static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int left;   // left pointer
        int right;  // right pointer

        Arrays.sort(nums);        

        int minSum = Integer.MAX_VALUE;
        int minToTarget = Integer.MAX_VALUE;        

        for (int i = 0; i < len - 1; i++) {
            left = i + 1;       // left pointer move one step forward
            right = len - 1;    // right pointer reset to the last index

            int sum0 = nums[i] + nums[left] + nums[right];
            int minToTarget0 = Math.abs(sum0 - target);
 
            if (minToTarget0 < minToTarget) {
                minToTarget = minToTarget0;
                minSum = sum0;
            }


            while (left + 1 < right) {
                int sum1 = nums[i] + nums[left + 1] + nums[right];
                int sum2 = nums[i] + nums[left] + nums[right - 1];
                int minToTarget1 = Math.abs(sum1 - target);
                int minToTarget2 = Math.abs(sum2 - target);

                if (minToTarget1 < minToTarget2) {
                    if (minToTarget1 < minToTarget) {
                        minSum = sum1;
                        minToTarget = minToTarget1;
                    }

                    left++;
                } else {
                    if (minToTarget2 < minToTarget) {
                        minSum = sum2;
                        minToTarget = minToTarget2;
                    }

                    right--;
                }
            }
        }

        return minSum;
    } 
}