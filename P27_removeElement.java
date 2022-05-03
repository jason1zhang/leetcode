import leetcode.*;

/**
 * solutions to leetcode problem 27: Remove Element
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-05-03
 */

 public class P27_removeElement {
    public static void main(String[] args) {
        P27_removeElement p27_removeElement = new P27_removeElement();

        p27_removeElement.test();
    }

    public void test() {
        // test case 1        
        // int[] nums = {3, 2, 2, 3};
        // int val = 3;

        // test case 2
        // int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        // int val = 2;

        // test case 3
        int[] nums = {3, 2, 2, 3};
        int val = 3;

        System.out.printf("After Removing the value of {%d} from the Array, there are {%d} numbers remaining.\n", val, removeElement(nums, val));
    }

     /**
      * Problem #:      27
      * Problem:        Remove Element
      * Difficulty:     Easy
      * 
      * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. 
      * The relative order of the elements may be changed.
      *
      * Since it is impossible to change the length of the array in some languages, 
      * you must instead have the result be placed in the first part of the array nums. 
      * More formally, if there are k elements after removing the duplicates, 
      * then the first k elements of nums should hold the final result. 
      * It does not matter what you leave beyond the first k elements.
      * 
      * Return k after placing the final result in the first k slots of nums.
      *
      * Do not allocate extra space for another array. 
      * You must do this by modifying the input array in-place with O(1) extra memory.
      * 
      * Example 1:
      * Input: nums = [3,2,2,3], val = 3
      * Output: 2, nums = [2,2,_,_]
      * Explanation: 
      *     Your function should return k = 2, with the first two elements of nums being 2.
      *     It does not matter what you leave beyond the returned k (hence they are underscores).
      * 
      * Example 2:
      * Input:  nums = [0,1,2,2,3,0,4,2], val = 2
      * Output: 5, nums = [0,1,4,0,3,_,_,_]
      * Explanation: 
      *     Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
      *     Note that the five elements can be returned in any order.
      *     It does not matter what you leave beyond the returned k (hence they are underscores).
      *
      * Constraints:
      *     - 0 <= nums.length <= 100
      *     - 0 <= nums[i] <= 50
      *     - 0 <= val <= 100.
      */  

    /**
     * 
     * Solution 1: use two pointers
     * 
     * Result:
     *    - Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
     *    - Memory Usage: 40.9 MB, less than 84.40% of Java online submissions for Remove Element.
     * 
     *    - time complexity:    O(n)
     *    - space complexity:   O(1)
     * 
     * @param nums an integer array
     * @return the number of integers remained in the array
     */
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int index1 = 0;     // point to the number whose value is the target
        int index2 = 0;     // point to the number whose value is not the target

        while (index1 <= nums.length && index2 <= nums.length) {
            if (nums[index1] != val) {
                index1++;
                index2 = index1 + 1;
                
                continue;
            }

            if (index2 >= nums.length) {
                break;
            }

            if (nums[index2] == val) {
                index2++;
                
                continue;
            }

            exchange(nums, index1, index2);
        }

        return index1;
    } 

    private static void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}