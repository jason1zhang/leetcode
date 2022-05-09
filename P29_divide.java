import leetcode.*;

/**
 * solutions to leetcode problem 29: Divide Two Integers
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-05-08
 */

 public class P29_divide {
    public static void main(String[] args) {
        P29_divide p29_divide = new P29_divide();

        p29_divide.test();
    }

    public void test() {
        // test case 1        
        // int dividend = 10, divisor = 3;

        // test case 2
        // int dividend = 7, divisor = -3;

        // test case 3, expected 2147483647
        // int dividend = -2147483648, divisor = -1;

        // test case 4
        int dividend = 2147483647, divisor = 2;   

        System.out.printf("The quotient of the integer {%d} divided by integer {%d} is {%d}.\n", dividend, divisor, divide(dividend, divisor));
    }

     /**
      * Problem #:      29
      * Problem:        Divide Two Integers
      * Difficulty:     Medium
      * 
      * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
      *
      * The integer division should truncate toward zero, which means losing its fractional part. 
      * For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
      *
      * Return the quotient after dividing dividend by divisor.
      *
      * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. 
      * For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, 
      * and if the quotient is strictly less than -231, then return -231.
      * 
      * Example 1:
      * Input: dividend = 10, divisor = 3
      * Output: 3
      * Explanation: 10/3 = 3.33333.. which is truncated to 3.
      * 
      * Example 2:
      * Input:  dividend = 7, divisor = -3
      * Output: -2
      * Explanation: 7/-3 = -2.33333.. which is truncated to -2.
      *
      * Constraints:
      *     - -2^31 <= dividend, divisor <= 2^31 - 1
      *     - divisor != 0
      */  

    /**
     * 
     * Solution 1: 
     * 
     * Result:
     *    - Runtime: Time Limit Exceeded
     * 
     *    - time complexity:    O()
     *    - space complexity:   O()
     * 
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the quotient after dividing dividend by divisor.
     */
    public static int divide(int dividend, int divisor) {  
        long count = 0;
        boolean isNegative = false;

        long absDividend = dividend < 0 ? Math.abs((long)dividend) : dividend;
        long absDivisor = divisor < 0 ? Math.abs((long)divisor) : divisor;

        if ((absDividend == dividend && absDivisor != divisor) 
                || (absDividend != dividend && absDivisor == divisor)) {
            isNegative = true;
        }

        while (absDividend >= absDivisor) {
            absDividend -= absDivisor;
            count++;
        }

        if (count >= Integer.MAX_VALUE) {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        return isNegative ? -(int)count : (int)count;
    }
}