/**
 * solutions to leetcode problem 7: Reverse Integer
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-03-31
 */

 public class P7_reverseInteger {
    public static void main(String[] args) {
        P7_reverseInteger p7_reverseInteger = new P7_reverseInteger();

        p7_reverseInteger.test();
    }

    public void test() {
        // test case 1
        // int x = 123;

        // test case 2
        // int x = -123;

        // test case 3        
        // int x = 120;

        // test case 4
        // int x = 901000;

        // test case 5
        int x = 1534236469;

        int x2 = (int)(Math.pow(2, 31) - 1);
        int x3 = -(int)Math.pow(2, 31);
        int x4 = Integer.MAX_VALUE;
        int x5 = Integer.MIN_VALUE;

        System.out.printf("x => {%d}\n", x);
        System.out.printf("x2 => {%d}\n", x2);
        System.out.printf("x3 => {%d}\n", x3);
        System.out.printf("x4 => {%d}\n", x4);
        System.out.printf("x5 => {%d}\n", x5);

        System.out.printf("x < x2 ? {%b}\n", x < x2);

        System.out.printf("The reversed integer for {%d} is: {%d}\n ", x, reverse(x));
    }

     /**
      * Problem #:      7
      * Problem:        Reverse Integer
      * Difficulty:     medium
      * 
      * Given a signed 32-bit integer x, return x with its digits reversed. 
      * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
      * 
      * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
      * 
      * Example 1:
      * Input: x = 123
      * Output: 321
      * 
      * Example 2:
      * Input: x = -123
      * Output: -321
      *
      * Example 3:
      * Input: x = 120
      * Output: 21
      *   
      * Constraints:
      *   - -2^31 <= x <= 2^31 - 1
      */  

    /**
     * 
     * Solution 1: 
     * 
     * Result:
     *    - Runtime: 2 ms, faster than 67.94% of Java online submissions for Reverse Integer.
     *    - Memory Usage: 42.1 MB, less than 14.75% of Java online submissions for Reverse Integer.
     * 
     *    - time complexity:    O(long10(n))
     *    - space complexity:   O(1)
     * 
     * @param x an integer
     * @return reversed integer
     */
    public static int reverse(int x) {
        long result = 0;    // set result type to long first
        int remainder;

        while (x != 0) {
            remainder = x % 10;
            x = x / 10;

            result = result * 10 + remainder;

        }

        // check the range
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
 
        return (int)result; // cast result type back to int
    } 
}

