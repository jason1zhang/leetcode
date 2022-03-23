import java.util.HashMap;

/**
 * solutions to leetcode problem 1: two sum.
 * 
 * result:
 *    Runtime: 3 ms, faster than 87.57% of Java online submissions for Two Sum.
 *    Memory Usage: 46 MB, less than 23.89% of Java online submissions for Two Sum.
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-03-23
 */

 public class P1_twoSum {
    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        int target = 9;

        int result[] = twoSum_2(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

     /**
      * Problem #:      1
      * Problem:        two sum
      * Difficulty:     easy
      *
      * Given an array of integers nums and an integer target, 
      * return indices of the two numbers such that they add up to target. 

      * You may assume that each input would have exactly one solution, 
      * and you may not use the same element twice. 
      * 
      * You can return the answer in any order.
      * 
      * Example 1:
      * Input: nums = [2,7,11,15], target = 9
      * Output: [0,1] 
      * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
      * 
      * Example 2: 
      * Input: nums = [3,2,4], target = 6 
      * Output: [1,2]
      *
      * Example 3: 
      * Input: nums = [3,3], target = 6 
      * Output: [0,1]
      * 
      * Constraints:
      *     2 <= nums.length <= 10^4 
      *     -10^9 <= nums[i] <= 10^9 
      *     -10^9 <= target <= 10^9 
      *     Only one valid answer exists.
      * 
      * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
      */
  
    /**
     * 1st solution:
     *    - brute force
     *    - time complexity: O(n^2)
     * 
     * @param nums an array of integers
     * @param target an target integer
     * @return indices of the two numbers such that they add up to target
     */
    public static int[] twoSum_1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int result[] = {i, j};
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * 2nd solution:
     *      - use hashmap to store the value and index pair
     *      - time complexity: O(n)
     * 
     * @param nums an array of integers
     * @param target an target integer
     * @return indices of the two numbers such that they add up to target
     */
    public static int[] twoSum_2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                int result[] = {map.get(target - nums[i]), i};
                return result;
            }
        }

        return null;
    }
 }