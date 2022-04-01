/**
 * solutions to leetcode problem 8: String to Integer (atoi)
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-04-01
 */

 public class P8_atoi {
    public static void main(String[] args) {
        P8_atoi p8_atoi = new P8_atoi();

        p8_atoi.test();
    }

    public void test() {
        // test case 1
        // String s = "42";

        // test case 2
        // String s = "   -42";

        // test case 3
        // String s = "4193 with words";

        // test case 4
        // String s = "words and 987";     // expected 0

        // test case 5
        // String s = "+-12";       // expected 0
        
        // test case 6
        String s = "-5-";        // expected -5  
        
        System.out.printf("The String {%s} converted to integer is {%d}\n ", s, myAtoi(s));
    }

     /**
      * Problem #:      8
      * Problem:        String to Integer
      * Difficulty:     medium
      * 
      * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
      * 
      * The algorithm for myAtoi(string s) is as follows:
      *   1. Read in and ignore any leading whitespace.
      *
      *   2. Check if the next character (if not already at the end of the string) is '-' or '+'. 
      *      Read this character in if it is either. This determines if the final result is negative or positive respectively. 
      *      Assume the result is positive if neither is present.
      *
      *   3. Read in next the characters until the next non-digit character or the end of the input is reached. 
      *      The rest of the string is ignored.
      *
      *   4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. 
      *      Change the sign as necessary (from step 2).
      *
      *   5. If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1], then clamp the integer so that it remains in the range. 
      *      Specifically, integers less than -231 should be clamped to -2^31, and integers greater than 2^31 - 1 should be clamped to 2^31 - 1.
      *
      *   6. Return the integer as the final result.
      *
      * Note:
      *   - Only the space character ' ' is considered a whitespace character.
      *   - Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
      * 
      * Example 1:
      * Input: s = "42"
      * Output: 42
      * Explanation: 
      *    The underlined characters are what is read in, the caret is the current reader position.
      *     - Step 1: "42" (no characters read because there is no leading whitespace)
      *     - Step 2: "42" (no characters read because there is neither a '-' nor '+')
      *     - Step 3: "42" ("42" is read in)
      *     The parsed integer is 42.
      *     Since 42 is in the range [-231, 231 - 1], the final result is 42.
      * 
      * Example 2:
      * Input: s = "   -42"
      * Output: -42
      * Explanation:
      *     - Step 1: "   -42" (leading whitespace is read and ignored)
      *     - Step 2: "   -42" ('-' is read, so the result should be negative)
      *     - Step 3: "   -42" ("42" is read in)
      *     The parsed integer is -42.
      *     Since -42 is in the range [-231, 231 - 1], the final result is -42.
      *
      * Example 3:
      * Input: "4193 with words"
      * Output: 4193
      * Explanation:
      *     - Step 1: "4193 with words" (no characters read because there is no leading whitespace)
      *     - Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
      *     - Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
      *     The parsed integer is 4193.
      *     Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
      *
      * Constraints:
      *     - 0 <= s.length <= 200
      *     - s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
      */  

    /**
     * 
     * Solution 1: follow the rules
     * 
     * Result:
     *    - Runtime: 1 ms, faster than 100.00% of Java online submissions for String to Integer (atoi).
     *    - Memory Usage: 42.3 MB, less than 85.80% of Java online submissions for String to Integer (atoi).
     * 
     *    - time complexity:    O(n)
     *    - space complexity:   O(1)
     * 
     * @param x an integer
     * @return reversed integer
     */
    public static int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }

        double result = 0.0;
        boolean positive = true;    // flag for positive sign
        boolean leading = true;     // flag for leading whitespace

        for (char ch : s.toCharArray()) {
            if (ch == ' ' & leading) {
                continue;
            } else if (ch == '+') {
                if (leading) {
                    leading = false;
                } else {
                    break;      // important
                }                

              } else if (ch == '-') {
                  if (leading) {
                      leading = false;
                  } else {
                      break;    // important
                  }
                
                positive = false;

            } else if (ch >= '0' && ch <= '9') {
                result = result * 10 + (ch - '0');
                leading = false;

            } else if ((ch < '0' || ch > '9')) {
                if (leading) {
                    return 0;
                } else {
                    break;
                }
            }
        }

        if (!positive) {
            result = -result;
        }

        // clamp the result if out of integer range
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } 
        
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
 
        return (int)result; // cast result type back to int
    } 
}

