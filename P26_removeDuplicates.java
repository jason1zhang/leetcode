import leetcode.*;

/**
 * solutions to leetcode problem 26: Remove Duplicates from Sorted Array
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-05-03
 */

 public class P26_removeDuplicates {
    public static void main(String[] args) {
        P26_removeDuplicates p26_removeDuplicates = new P26_removeDuplicates();

        p26_removeDuplicates.test();
    }

    public void test() {
        // test case 1        
        // int[] nums = {1, 1, 2};

        // test case 2
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.printf("After Removing Duplicates from Sorted Array, there are {%d} distinct numbers.\n", removeDuplicates(nums));
    }

     /**
      * Problem #:      26
      * Problem:        Remove Duplicates from Sorted Array
      * Difficulty:     Easy
      * 
      * Given an integer array nums sorted in non-decreasing order, 
      * remove the duplicates in-place such that each unique element appears only once. 
      * The relative order of the elements should be kept the same.
      * 
      * Since it is impossible to change the length of the array in some languages, 
      * you must instead have the result be placed in the first part of the array nums. 
      * More formally, if there are k elements after removing the duplicates, 
      * then the first k elements of nums should hold the final result. 
      * It does not matter what you leave beyond the first k elements.
      * 
      * Return k after placing the final result in the first k slots of nums.
      *
      * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
      * 
      * Example 1:
      * Input: nums = [1,1,2]
      * Output: 2, nums = [1,2,_]
      * Explanation: 
      *     Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
      *     It does not matter what you leave beyond the returned k (hence they are underscores).
      * 
      * Example 2:
      * Input:  nums = [0,0,1,1,1,2,2,3,3,4]
      * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
      * Explanation: 
      *     Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
      *     It does not matter what you leave beyond the returned k (hence they are underscores).
      *
      * Constraints:
      *     - 1 <= nums.length <= 3 * 10^4
      *     - -100 <= nums[i] <= 100
      *     - nums is sorted in non-decreasing order.
      */  

    /**
     * 
     * Solution 1: use two pointers
     * 
     * Result:
     *    - Runtime: 1 ms, faster than 88.59% of Java online submissions for Remove Duplicates from Sorted Array.
     *    - Memory Usage: 43.9 MB, less than 84.44% of Java online submissions for Remove Duplicates from Sorted Array.
     * 
     *    - time complexity:    O(n)
     *    - space complexity:   O(1)
     * 
     * @param nums a sorted array
     * @return the number of distinct integers in the array
     */
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;

        if (len == 0 || len == 1) {
            return len;
        }

        int index = 0;

        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[index]) {
                nums[index + 1] = nums[i];
                index++;
            }
        }

        return (index + 1);
    } 

}