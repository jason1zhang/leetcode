import leetcode.*;

/**
 * solutions to leetcode problem 34: Find First and Last Position of Element in Sorted Array
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-05-13
 */

 public class P34_searchRange {
    public static void main(String[] args) {
        P34_searchRange p34_searchRange = new P34_searchRange();

        p34_searchRange.test();
    }

    public void test() {
        // test case 1        
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        // test case 2
        // int[] nums = {5, 7, 7, 8, 8, 10};
        // int target = 6;

        // test case 3
        // int[] nums = {};
        // int target = 0;

        int[] result = searchRange(nums, target);
        System.out.printf("the starting and ending position of a given target value is [%d, %d].\n", result[0], result[1]);
    }

     /**
      * Problem #:      34
      * Problem:        Find First and Last Position of Element in Sorted Array
      * Difficulty:     Medium
      * 
      * Given an array of integers nums sorted in non-decreasing order, 
      * find the starting and ending position of a given target value.
      * 
      * If target is not found in the array, return [-1, -1].
      * 
      * You must write an algorithm with O(log n) runtime complexity.
      * 
      * Example 1:
      * Input: nums = [5,7,7,8,8,10], target = 8
      * Output: [3,4]
      * 
      * Example 2:
      * Input:  nums = [5,7,7,8,8,10], target = 6
      * Output: [-1,-1]
      *
      * Example 3:
      * Input:  nums = [], target = 0
      * Output: [-1,-1]
      *
      * Constraints:
      *     - 0 <= nums.length <= 10^5
      *     - -10^9 <= nums[i] <= 10^9
      *     - nums is a non-decreasing array.
      *     - -10^9 <= target <= 10^9
      */  

    /**
     * 
     * Solution 1: a revision of classical binary search, with recursive calls
     * 
     * Result:
     *    - Runtime: 1 ms, faster than 30.95% of Java online submissions for Find First and Last Position of Element in Sorted Array.
     *    - Memory Usage: 47.5 MB, less than 22.49% of Java online submissions for Find First and Last Position of Element in Sorted Array.
     * 
     *    - time complexity:    O(log(n))
     *    - space complexity:   O(1)
     * 
     * @param nums a rotated sorted array
     * @param target the target number to search for
     * @return the starting and ending position of a given target value.
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = nums.length - 1;
        int[] range = {Integer.MAX_VALUE, Integer.MIN_VALUE};

        return search(nums, left, right, target, range);
    }

    private static int[] search(int[] nums, int left, int right, int target, int range[]) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                int[] rangeLeft = search(nums, left, mid - 1, target, range);
                int[] rangeRight = search(nums, mid + 1, right, target, range);
                
                range[0] = rangeLeft[0] == -1 ? Math.min(mid, range[0]) : Math.min(rangeLeft[0], range[0]);
                range[1] = rangeRight[1] == -1 ? Math.max(mid, range[1]) : Math.max(rangeRight[1], range[1]);

                return range;

            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}