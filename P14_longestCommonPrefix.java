/**
 * solutions to leetcode problem 14: Longest Common Prefix
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-04-14
 */

 public class P14_longestCommonPrefix {
    public static void main(String[] args) {
        P14_longestCommonPrefix p14_longestCommonPrefix = new P14_longestCommonPrefix();

        p14_longestCommonPrefix.test();
    }

    public void test() {
        // test case 1
        // String[] strs = {"flower", "flow", "flight"};

        // test case 2
        // String[] strs = {"dog", "racecar", "car"};      

        // test case 3
        String[] strs = {"cir", "car"}; 

        System.out.printf("The longest common prefix is {%s}\n ", longestCommonPrefix(strs));
    }

     /**
      * Problem #:      14
      * Problem:        Longest Common Prefix
      * Difficulty:     Easy
      * 
      * Write a function to find the longest common prefix string amongst an array of strings.
      * If there is no common prefix, return an empty string "".
      * 
      * Example 1:
      * Input: strs = ["flower","flow","flight"]
      * Output: "fl"
      * 
      * Example 2:
      * Input:  strs = ["dog","racecar","car"]
      * Output: ""
      * Explanation: 
      *    There is no common prefix among the input strings.
      *
      * Constraints:
      *     - 1 <= strs.length <= 200
      *     - 0 <= strs[i].length <= 200
      *     - strs[i] consists of only lower-case English letters.
      */  

    /**
     * 
     * Solution 1: 
     * 
     * Result:
     *    - Runtime: 1 ms, faster than 81.90% of Java online submissions for Longest Common Prefix.
     *    - Memory Usage: 40.4 MB, less than 86.50% of Java online submissions for Longest Common Prefix.
     * 
     *    - time complexity:    O(n^2)
     *    - space complexity:   O(1)
     * 
     * @param strs an array of strings
     * @return longest common prefix
     */
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        boolean isFound = true;
        int len = Integer.MAX_VALUE;    // the common length of all the strings in the input String array
        
        for (int i = 0; i < strs.length; i++) {
            len = Math.min(len, strs[i].length());
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (j + 1 < strs.length && strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    isFound = false;
                    break;  // break out the inner loop
                }
            }

            if (isFound) {
                sb.append(strs[0].charAt(i));
            } else {
                break;  // break out the outer loop
            }
        }

        return sb.toString();
    } 
}