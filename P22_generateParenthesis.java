import java.util.*;

/**
 * solutions to leetcode problem 22: Generate Parentheses
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-04-23
 */

 public class P22_generateParenthesis {
    public static void main(String[] args) {
        P22_generateParenthesis p22_generateParenthesis = new P22_generateParenthesis();

        p22_generateParenthesis.test();
    }

    public void test() {
        // test case 1        
        int n = 3;

        // test case 2
        // int n = 1;
        
        System.out.printf("Generated {%d} pairs of well-formed parentheses: ", n);
        System.out.println(generateParenthesis(n));
    }

     /**
      * Problem #:      22
      * Problem:        Generate Parentheses
      * Difficulty:     Medium
      * 
      * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
      * 
      * Example 1:
      * Input: n = 3
      * Output: ["((()))","(()())","(())()","()(())","()()()"]
      * 
      * Example 2:
      * Input:  n = 1
      * Output: ["()"]
      *
      * Constraints:
      *     - 1 <= n <= 8
      */  

    /**
     * 
     * Solution 1: two pointers approach, but with extra space
     * 
     * Result:
     *    - Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
     *    - Memory Usage: 41.7 MB, less than 90.71% of Java online submissions for Merge Two Sorted Lists.
     * 
     *    - time complexity:    O(n)
     *    - space complexity:   O(n)
     * 
     * @param s a string
     * @return true if the input string is valid, false otherwise
     */
    public static List<String> generateParenthesis(int n) {
        return null;
    } 
}