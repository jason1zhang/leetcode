import java.util.*;

/**
 * solutions to leetcode problem 18: 4Sum
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-04-19
 */

 public class P18_4Sum {
    public static void main(String[] args) {
        P18_4Sum p18_4Sum = new P18_4Sum();

        p18_4Sum.test();
    }

    public void test() {
        // test case 1
        // int[] nums = {1, 0, -1, 0, -2, 2};
        // int target = 0;

        // test case 2
        // int[] nums = {2,2,2,2,2};
        // int target = 8;      

        // test case 3, expected [[-3,-1,2,4]]
        int[] nums = {-3, -1, 0, 2, 4, 5};
        int target = 2;      

        System.out.printf("The 4Sum quadruplets for the given array is: ");
        System.out.println(fourSum(nums, target));
    }

     /**
      * Problem #:      18
      * Problem:        4Sum
      * Difficulty:     Medium
      * 
      * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
      *     - 0 <= a, b, c, d < n
      *     - a, b, c, and d are distinct.
      *     - nums[a] + nums[b] + nums[c] + nums[d] == target
      *
      * You may return the answer in any order.
      * 
      * Example 1:
      * Input: nums = [1,0,-1,0,-2,2], target = 0
      * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
      * 
      * Example 2:
      * Input:  nums = [2,2,2,2,2], target = 8
      * Output: [[2,2,2,2]]
      *
      * Constraints:
      *     - 1 <= nums.length <= 200
      *     - -10^9 <= nums[i] <= 10^9
      *     - -10^9 <= target <= 10^9
      */  

    /**
     * 
     * Solution 1: two pointers approach
     * 
     * Result:
     *    - Runtime: 297 ms, faster than 9.81% of Java online submissions for 4Sum.
     *    - Memory Usage: 117 MB, less than 9.80% of Java online submissions for 4Sum.
     * 
     *    - time complexity:    O(n^3)
     *    - space complexity:   O(1)
     * 
     * @param nums an array of integers
     * @param target target number
     * @return quadruplets
     */

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        int low;    // left index moving forward
        int high;   // right index moving backward
        int sum;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                low = j + 1;
                high = nums.length - 1;

                while (low < high) {
                    sum = nums[i] + nums[j] + nums[low] + nums[high];
                    
                    if (sum == target) {
                        List<Integer> quadruplets = new ArrayList<>();

                        quadruplets.add(nums[i]);
                        quadruplets.add(nums[j]);
                        quadruplets.add(nums[low]);
                        quadruplets.add(nums[high]);

                        result.add(quadruplets);   
                        
                        low++;  // either low++ or high--

                    } else if (sum < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }

        return new ArrayList<>(result);
    } 
}