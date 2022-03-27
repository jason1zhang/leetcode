/**
 * solutions to leetcode problem 5: longest palindromic substring.
 * 
 * note: the solution to this problem needs to be further improved.
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-03-26
 */

 public class P5_longestPalindromicSubstring {
    public static void main(String[] args) {
        P5_longestPalindromicSubstring p5_longestPalindromicSubstring = new P5_longestPalindromicSubstring();

        p5_longestPalindromicSubstring.test();
    }

    public void test() {
        // test case 1
        String s = "babad";

        // test case 2
        // String s = "cbbd";

        // test case 3
        // String s = "a";

        // test case 4
        // String s = "bb";

        // System.out.printf("Is the strng {%s} a palindrome? {%b}\n", s, isPalindrome(s));
        System.out.printf("The longest palindromic substring for {%s} is: {%s}\n ", s, longestPalindrome_1(s));

    }

     /**
      * Problem #:      5
      * Problem:        longest palindromic substring.
      * Difficulty:     medium
      * 
      * Given a string s, return the longest palindromic substring in s.
      * 
      * Example 1:
      * Input: s = "babad"
      * Output: "bab"
      * Explanation: "aba" is also a valid answer.
      * 
      * Example 2:
      * Input: "cbbd"
      * Output: "bb"
      *
      *
      * Constraints:
      *   - 1 <= s.length <= 1000
      *   - s consist of only digits and English letters.
      */  

    /**
     * 
     * Solution 1: brute force
     *    - enumerate all the substring, check if they are palindrom, and then pick the longest one.
     * 
     * Result:
     *    - Runtime: Time Limit Exceeded
     *    - Memory Usage: 
     * 
     *    - time complexity:    O(n^3)
     *    - space complexity:   O(1)
     * 
     * @param s a string
     * @return longest palindromic substring
     */
    public static String longestPalindrome_1(String s)  {
        int len = s.length();
        int maxLen = 0;

        String maxSubStr = null;
        String subStr = null;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                subStr = s.substring(i, j + 1);     // startIndex : starting index is inclusive; endIndex : ending index is exclusive
                
                if (isPalindrome(subStr) && subStr.length() > maxLen) {
                    maxLen = subStr.length();
                    maxSubStr = subStr;
                }
            }
        }
        
        return maxSubStr;
    }

    public static boolean isPalindrome(String s) {
        int len = s.length();

        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 
     * Solution 2: longest common substring
     *    - reverse the string, and find the longest common substring.
     *    - to find the longest common substring, the method of dynamic programming will be used.
     * 
     * Result:
     *    - Runtime: 
     *    - Memory Usage: 
     * 
     *    - time complexity:    O(n^2)
     *    - space complexity:   O(n^2)
     * 
     * @param s a string
     * @return longest palindromic substring
     */
    public static String longestPalindrome_2(String s)  {
        int len = s.length();
        int maxLen = 0;

        String maxSubStr = null;
        String subStr = null;

       
        return maxSubStr;
    }

}

