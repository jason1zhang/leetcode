/**
 * solutions to leetcode problem 10: Regular Expression Matching
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-04-04
 */

 public class P10_regExpMatch {
    public static void main(String[] args) {
        P10_regExpMatch p10_regExpMatch = new P10_regExpMatch();

        p10_regExpMatch.test();
    }

    public void test() {
        // test case 1
        String s = "aa", p = "a";
      
        System.out.printf("Is regular expression {%s} match string {%s}? {%b}\n ", p, s, isMatch(s, p));
    }

     /**
      * Problem #:      10
      * Problem:        Regular Expression Matching
      * Difficulty:     hard
      * 
      * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
      *     - '.' Matches any single character.​​​​
      *     - '*' Matches zero or more of the preceding element.
      * 
      * The matching should cover the entire input string (not partial).
      * 
      * Example 1:
      * Input: s = "aa", p = "a"
      * Output: false
      * Explanation: 
      *    "a" does not match the entire string "aa".
      * 
      * Example 2:
      * Input: s = "aa", p = "a*"
      * Output: true
      * Explanation:
      *    '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
      *
      * Example 3:
      * Input: s = "ab", p = ".*"
      * Output: true
      * Explanation:
      *    ".*" means "zero or more (*) of any character (.)".
      *
      * Constraints:
      *     - 1 <= s.length <= 20
      *     - 1 <= p.length <= 30
      *     - s contains only lowercase English letters.
      *     - p contains only lowercase English letters, '.', and '*'.
      *     - It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
      */  

    /**
     * 
     * Solution 1: 
     * 
     * Result:
     *    - Runtime: 
     * 
     *    - time complexity:    O()
     *    - space complexity:   O()
     * 
     * @param x an integer
     * @return true if x is a palindrome number, and false otherwise
     */
    public static boolean isMatch(String s, String p) {
        return false;
    } 
}