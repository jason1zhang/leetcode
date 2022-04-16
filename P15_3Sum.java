import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

/**
 * solutions to leetcode problem 15: 3Sum
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-04-15
 */

 public class P15_3Sum {
    public static void main(String[] args) {
        P15_3Sum p15_3Sum = new P15_3Sum();

        p15_3Sum.test();
    }

    public void test() {
        // test case 1
        // int[] nums = {-1, 0, 1, 2, -1, -4};

        // test case 2
        // int[] nums = {};      

        // test case 3
        // int[] nums = {0}; 

        // test case 4
        int[] nums = {0, 0, 0}; 

        System.out.printf("The 3Sum triples for the given array is: ");
        System.out.println(threeSum(nums));
    }

     /**
      * Problem #:      15
      * Problem:        3Sum
      * Difficulty:     Medium
      * 
      * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
      * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
      * 
      * Notice that the solution set must not contain duplicate triplets.
      * 
      * Example 1:
      * Input: nums = [-1,0,1,2,-1,-4]
      * Output: [[-1,-1,2],[-1,0,1]]
      * 
      * Example 2:
      * Input:  nums = []
      * Output: []
      *
      * Example 3:
      * Input:  nums = [0]
      * Output: []

      * Constraints:
      *     - 0 <= nums.length <= 3000
      *     - -10^5 <= nums[i] <= 10^5
      */  

    /**
     * 
     * Solution 1: 
     *      use the algorithm from page 190 of the book "Algorithms Fourth Edition by Sedgewick", 
     *      but it fails at the case of input [0, 0, 0]
     * 
     * Result:
     *    - Runtime: 
     * 
     *    - time complexity:    O(n^2 * log(n))
     *    - space complexity:   O(1)
     * 
     * @param strs an array of strings
     * @return longest common prefix
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j + 1 < nums.length) {
                    int k = Arrays.binarySearch(nums, j + 1, nums.length, -(nums[i] + nums[j]));
                    
                    // System.out.printf("\n ... i = {%d}, j = {%d}, k = {%d} ...\n", i, j, k);
                    
                    if (k >= j + 1 && k < nums.length) {
                        List<Integer> tripleList = new ArrayList<>();
                        tripleList.add(nums[i]);
                        tripleList.add(nums[j]);
                        tripleList.add(nums[k]);
                        result.add(tripleList);
                    }
                }
            }
        }

        return new ArrayList<>(result);
    } 
}