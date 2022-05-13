import leetcode.*;

/**
 * solutions to leetcode problem 33: Search in Rotated Sorted Array
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-05-10
 */

 public class P33_search {
    public static void main(String[] args) {
        P33_search p33_search = new P33_search();

        p33_search.test();
    }

    public void test() {
        // test case 1        
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        // test case 2
        // int[] nums = {4, 5, 6, 7, 0, 1, 2};
        // int target = 3;

        // test case 3
        // int[] nums = {1};
        // int target = 0;

        // test case 4
        // int[] nums = {5, 1, 3};
        // int target = 0;

        System.out.printf("The index of the target {%d} in the array is {%d}.\n", target, search(nums, target));
    }

     /**
      * Problem #:      33
      * Problem:        Search in Rotated Sorted Array
      * Difficulty:     Medium
      * 
      * There is an integer array nums sorted in ascending order (with distinct values).
      * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) 
      * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
      * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
      *
      * Given the array nums after the possible rotation and an integer target, 
      * return the index of target if it is in nums, or -1 if it is not in nums.
      *
      * You must write an algorithm with O(log n) runtime complexity.
      * 
      * Example 1:
      * Input: nums = [4,5,6,7,0,1,2], target = 0
      * Output: 4
      * 
      * Example 2:
      * Input:  nums = [4,5,6,7,0,1,2], target = 3
      * Output: -1
      *
      * Example 3:
      * Input:  nums = [1], target = 0
      * Output: -1
      *
      * Constraints:
      *     - 1 <= nums.length <= 5000
      *     - -10^4 <= nums[i] <= 10^4
      *     - All values of nums are unique.
      *     - nums is an ascending array that is possibly rotated.
      *     - -10^4 <= target <= 10^4
      */  

    /**
     * 
     * Solution 1: a revision of classical binary search
     * 
     * Result:
     *    - Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
     *    - Memory Usage: 42.1 MB, less than 71.35% of Java online submissions for Search in Rotated Sorted Array.
     * 
     *    - time complexity:    O(log(n))
     *    - space complexity:   O(1)
     * 
     * @param nums a rotated sorted array
     * @param target the target number to search for
     * @return the index of target if it is in nums, or -1 if it is not in nums.
     */
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {  // find the target
                return mid;
            }
            
            if (nums[left] <= nums[mid]) {   // left half is sorted
                if (target >= nums[left] && target < nums[mid]) {    
                    right = mid - 1;    // search in the right sorted half
                } else {
                    left = mid + 1;
                }
            } else {    // right half is sorted, nums[mid] <= nums[right]
                if (target > nums[mid] && target <= nums[right]) {    
                    left = mid + 1;    // search in the left sorted half
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;  // not found
    }
}