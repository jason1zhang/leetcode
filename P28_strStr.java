import leetcode.*;

/**
 * solutions to leetcode problem 28: Implement strStr()
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-05-07
 */

 public class P28_strStr {
    public static void main(String[] args) {
        P28_strStr p28_strStr = new P28_strStr();

        p28_strStr.test();
    }

    public void test() {
        // test case 1        
        String haystack = "hello", needle = "ll";

        // test case 2
        // String haystack = "aaaaa", needle = "bba";

        // test case 3
        // String haystack = "a", needle = "a";

        // test case 4       
        // String haystack = "mississippi", needle = "issip";        

        System.out.printf("The index of the first occurrence of {%s} in {%s} is {%d}.\n", needle, haystack, strStr1(haystack, needle));
    }

     /**
      * Problem #:      28
      * Problem:        Implement strStr()
      * Difficulty:     Easy
      * 
      * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, 
      * or -1 if needle is not part of haystack.
      *
      * Clarification:
      *     What should we return when needle is an empty string? This is a great question to ask during an interview.
      *     For the purpose of this problem, we will return 0 when needle is an empty string. 
      *     This is consistent to C's strstr() and Java's indexOf().
      * 
      * Example 1:
      * Input: haystack = "hello", needle = "ll"
      * Output: 2
      * 
      * Example 2:
      * Input:  haystack = "aaaaa", needle = "bba"
      * Output: -1
      *
      * Constraints:
      *     - 1 <= haystack.length, needle.length <= 10^4
      *     - haystack and needle consist of only lowercase English characters.
      */  


    /**
     * 
     * Solution 1: brute force.
     * 
     * Result:
     *    - Runtime: 1 ms, faster than 74.86% of Java online submissions for Implement strStr().
     *    - Memory Usage: 41.9 MB, less than 66.57% of Java online submissions for Implement strStr().
     * 
     *    - time complexity:    O(n * m)
     *    - space complexity:   O(1)
     * 
     * @param haystack the original string
     * @param needle the substring to search for.
     * @return he index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     */
    public static int strStr1(String haystack, String needle) {       
        int n = needle.length();
        if (needle == null || n == 0) {return 0;}

        int m = haystack.length();
        
        int i = 0;
        int j = 0;
        for (; (i + n <= m); i++) {
            int k = i;

            j = 0;
            for (; j < n; j++) {
                if (haystack.charAt(k) != needle.charAt(j)) {
                    break;
                } else {
                    k++;
                }
            }

            if (j == n ) {
                break;
            }
        }
        
        return j == n  ? i : -1;
    }

    /**
     * 
     * Solution 2: use three pointers.
     * Note: this solution failed at test case 4
     * 
     * Result:
     *    - Runtime: 
     * 
     *    - time complexity:    O()
     *    - space complexity:   O()
     * 
     * @param haystack the original string
     * @param needle the substring to search for.
     * @return he index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     */
    public static int strStr2(String haystack, String needle) {        
        int n = needle.length();
        if (needle == null || n == 0) {return 0;}

        int m = haystack.length();
        if (m < n) {return -1;}

        int i = 0;
        int j = 0;
        int index = -1;

        while (i < m) {
            if (haystack.charAt(i) != needle.charAt(j)) {                
                j = 0;                
                index = i;

            } else {            
                j++;
                
                if (j == n) {
                    break;
                }
            }

            i++;
        }

        return j < n ? -1 : (index + 1);
    }

    /**
     * 
     * Solution 3: start from the end, and move backwards
     * Note: still have the same problem as the solution 2
     * 
     * Result:
     *    - Runtime: 
     * 
     *    - time complexity:    O()
     *    - space complexity:   O()
     * 
     * @param haystack the original string
     * @param needle the substring to search for.
     * @return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     */
    public static int strStr3(String haystack, String needle) { 
        int n = needle.length();
        if (needle == null || n == 0) {return 0;}

        int m = haystack.length();
        if (m < n) {return -1;}

        int i = m - 1;
        int j = n - 1;

        while (i >= 0) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j--;

                // found the needle in the haystack
                if (j == -1) {
                    break;
                }

            } else {
                j = n - 1;
            }

            i--;
        }

        return j == -1 ? i : -1;
    }
}