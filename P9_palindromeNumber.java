/**
 * solutions to leetcode problem 9: Palindrome Number
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-04-03
 */

 public class P9_palindromeNumber {
    public static void main(String[] args) {
        P9_palindromeNumber p9_palindromeNumber = new P9_palindromeNumber();

        p9_palindromeNumber.test();
    }

    public void test() {
        // test case 1
        int x = 121;
      
        System.out.printf("The number {%d} is a palindrome number? {%b}\n ", x, isPalindrome(x));
    }

     /**
      * Problem #:      9
      * Problem:        Palindrome Number
      * Difficulty:     easy
      * 
      * Given an integer x, return true if x is palindrome integer.
      *
      * An integer is a palindrome when it reads the same backward as forward.
      *     - For example, 121 is a palindrome while 123 is not.
      * 
      * Example 1:
      * Input: x = 121
      * Output: true
      * Explanation: 
      *    121 reads as 121 from left to right and from right to left.
      * 
      * Example 2:
      * Input: x = -121
      * Output: false
      * Explanation:
      *    From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
      *
      * Example 3:
      * Input: x = 10
      * Output: false
      * Explanation:
      *    Reads 01 from right to left. Therefore it is not a palindrome.
      *
      * Constraints:
      *     - 2^31 <= x <= 2^31 - 1
      *
      * Follow up: Could you solve it without converting the integer to a string?
      */  

    /**
     * 
     * Solution 1: 
     * 
     * Result:
     *    - Runtime: 12 ms, faster than 70.21% of Java online submissions for Palindrome Number.
     *    - Memory Usage: 44.6 MB, less than 55.19% of Java online submissions for Palindrome Number.
     * 
     *    - time complexity:    O(long10(n))
     *    - space complexity:   O(1)
     * 
     * @param x an integer
     * @return true if x is a palindrome number, and false otherwise
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        return x == reverse(x);
    } 

    public static int reverse(int x) {
        int result = 0;
        int remainder;

        while (x != 0) {
            remainder = x % 10;
            x = x / 10;

            result = result * 10 + remainder;

        }

        return result;
    } 
}

