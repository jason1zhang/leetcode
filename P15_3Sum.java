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
        System.out.println(threeSum2(nums));
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
     *      but it fails at the case of input [0, 0, 0]. 
     * 
     *      And should use this version of Arrays.binarySearch => binarySearch(long[] a, int fromIndex, int toIndex, long key)
     *      Using the above method, pay attend to the return value if key cannot be found.
     * 
     * Result:
     *    - Runtime: 626 ms, faster than 15.58% of Java online submissions for 3Sum.
     *    - Memory Usage: 47.2 MB, less than 80.44% of Java online submissions for 3Sum.
     * 
     *    - time complexity:    O(n^2 * log(n))
     *    - space complexity:   O(1)
     * 
     * @param strs an array of strings
     * @return longest common prefix
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j + 1 < nums.length) {
                    int k = Arrays.binarySearch(nums, j + 1, nums.length, -(nums[i] + nums[j]));
                    
                    // System.out.printf("\n ... i = {%d}, j = {%d}, k = {%d} ...\n", i, j, k); // for test purpose
                    
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

    /**
     * 
     * Solution 2: 
     *      use two pointers approach
     * 
     * Result:
     *    - Runtime: 440 ms, faster than 20.89% of Java online submissions for 3Sum.
     *    - Memory Usage: 46.9 MB, less than 79.62% of Java online submissions for 3Sum.
     * 
     *    - time complexity:    O(n^2)
     *    - space complexity:   O(1)
     * 
     * @param nums an array of integers
     * @return the triples
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        int low;    // left index moving forward
        int high;   // right index moving backward
        int sum;

        for (int i = 0; i < nums.length; i++) {
            low = i + 1;
            high = nums.length - 1;

            while (low < high) {
                sum = nums[i] + nums[low] + nums[high];
                
                if (sum == 0) {
                    List<Integer> tripleList = new ArrayList<>();

                    tripleList.add(nums[i]);
                    tripleList.add(nums[low]);
                    tripleList.add(nums[high]);

                    result.add(tripleList);   
                    
                    low++;  // either low++ or high--

                } else if (sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return new ArrayList<>(result);
    }
}