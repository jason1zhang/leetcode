import java.util.*;
import java.util.LinkedList;
import java.util.stream.Collectors;

import leetcode.*;

/**
 * solutions to leetcode problem 39: Combination Sum
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-05-19
 */

 public class P39_combinationSum {
    public static void main(String[] args) {
        P39_combinationSum p39_combinationSum = new P39_combinationSum();

        p39_combinationSum.test();
    }

    public void test() {
        // test case 1        
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        System.out.printf("The list of all unique combinations.\n");

        System.out.println(combinationSum(candidates, target));
    }

     /**
      * Problem #:      39
      * Problem:        Combination Sum
      * Difficulty:     Medium
      * 
      * Given an array of distinct integers candidates and a target integer target, 
      * return a list of all unique combinations of candidates where the chosen numbers sum to target. 
      * You may return the combinations in any order.
      *
      * The same number may be chosen from candidates an unlimited number of times. 
      * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
      *
      * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
      * 
      * Example 1:
      * Input: candidates = [2,3,6,7], target = 7
      * Output: [[2,2,3],[7]]
      * Explanation:
      *     2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
      *     7 is a candidate, and 7 = 7.
      *     These are the only two combinations.
      * 
      * Example 2:
      * Input: candidates = [2,3,5], target = 8
      * Output: [[2,2,2,2],[2,3,3],[3,5]]
      *
      * Example 3:
      * Input: candidates = [2], target = 1
      * Output: []      
      *
      * Constraints:
      *     - 1 <= candidates.length <= 30
      *     - 1 <= candidates[i] <= 200
      *     - All elements of candidates are distinct.
      *     - 1 <= target <= 500
      */  

    /**
     * 
     * Solution 1: 
     * 
     * Result:
     *    - Runtime: 25 ms, faster than 7.76% of Java online submissions for Combination Sum.
     *    - Memory Usage: 50.8 MB, less than 6.72% of Java online submissions for Combination Sum.
     * 
     *    - time complexity:    O()
     *    - space complexity:   O()
     * 
     * @param candidates an array of distinct integers 
     * @param target a target integer
     * @return a list of all unique combinations of candidates where the chosen numbers sum to target
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        backtrack2(candidates, 0, target, new LinkedList<Integer>(), result);

        Set<List<Integer>> set = result.stream().collect(Collectors.toSet());

        return set.stream().collect(Collectors.toList());
    }

    private static void backtrack(int[] candidates, int index, int target, LinkedList<Integer> currList, List<List<Integer>>  result) {
        if (target == 0) {
            result.add(new LinkedList<Integer>(currList));
        } else if (target < 0) {
            return;
        }

        if (index >= candidates.length) {
            return;
        }

        int candidate = candidates[index];

        backtrack(candidates, index + 1, target, currList, result); // skip current candidate

        currList.addLast(candidate);

        backtrack(candidates, index, target - candidate, currList, result); // use the current candidate multiple times

        currList.removeLast();  // remove added candidate to backtrack and try other options
    }

    private static void backtrack2(int[] candidates, int index, int target, LinkedList<Integer> currList, List<List<Integer>>  result) {
        if (target == 0) {
            result.add(new LinkedList<Integer>(currList));
        } else if (target < 0) {
            return;
        }

        if (index >= candidates.length) {
            return;
        }

        /* Decision 1 - Pick current number if it's not greater than target 
        and can be part of combination */
        if( candidates[index] <= target ) {
            // Add the current number to the subset
            currList.add( candidates[index]);
            
            /* Call the function again by reducing the target while keeping 
            keeping the index (to check if current number can be picked again) */
            backtrack(candidates, index, target - candidates[index], currList, result); 
            
            // Restore the original subset by removing the current number
            currList.remove(currList.size() - 1);
        } 
        
        // Decision 2 - Do not pick current number 
        backtrack2(candidates, index + 1, target, currList, result); 
    }
}