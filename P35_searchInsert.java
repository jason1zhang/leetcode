import leetcode.*;

/**
 * solutions to leetcode problem 35: Search Insert Position
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-05-15
 */

 public class P35_searchInsert {
    public static void main(String[] args) {
        P35_searchInsert p35_searchInsert = new P35_searchInsert();

        p35_searchInsert.test();
    }

    public void test() {
        // test case 1        
        // int[] nums = {1, 3, 5, 6};
        // int target = 5;

        // test case 2
        // int[] nums = {1, 3, 5, 6};
        // int target = 2;

        // test case 3
        int[] nums = {1, 3, 5, 6};
        int target = 7;

        System.out.printf("The index of the search insert is %d.\n", searchInsert(nums, target));
    }

     /**
      * Problem #:      35
      * Problem:        Search Insert Position
      * Difficulty:     Easy
      * 
      * Given a sorted array of distinct integers and a target value, return the index if the target is found. 
      * If not, return the index where it would be if it were inserted in order.
      * 
      * You must write an algorithm with O(log n) runtime complexity.
      * 
      * Example 1:
      * Input: nums = [1,3,5,6], target = 5
      * Output: 2
      * 
      * Example 2:
      * Input: nums = [1,3,5,6], target = 2
      * Output: 1
      *
      * Example 3:
      * Input: nums = [1,3,5,6], target = 7
      * Output: 4
      *
      * Constraints:
      *     - 1 <= nums.length <= 10^4
      *     - 10^4 <= nums[i] <= 10^4
      *     - nums contains distinct values sorted in ascending order.
      *     - -10^4 <= target <= 10^4
      */  

    /**
     * 
     * Solution 1: classical binary search algorithm
     * 
     * Result:
     *    - Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
     *    - Memory Usage: 43.9 MB, less than 22.85% of Java online submissions for Search Insert Position.
     * 
     *    - time complexity:    O(log(n))
     *    - space complexity:   O(1)
     * 
     * @param nums a rotated sorted array
     * @param target the target number to search for
     * @return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}