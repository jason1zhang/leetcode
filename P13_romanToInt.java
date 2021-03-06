import java.util.HashMap;

/**
 * solutions to leetcode problem 13: Roman to Integer
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-04-10
 */

 public class P13_romanToInt {
    public static void main(String[] args) {
        P13_romanToInt p13_romanToInt = new P13_romanToInt();

        p13_romanToInt.test();
    }

    public void test() {
        // test case 1
        // String s = "III";

        // test case 2
        // String s = "LVIII";      

        // test case 2
        String s = "MCMXCIV";  

        System.out.printf("The integer for Roman numeral {%s} is {%d}\n ", s, romanToInt(s));
    }

     /**
      * Problem #:      13
      * Problem:        Roman to Integer
      * Difficulty:     Easy
      * 
      * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
      *
      * Symbol       Value
      * I             1
      * V             5
      * X             10
      * L             50
      * C             100
      * D             500
      * M             1000
      *
      * For example, 2 is written as II in Roman numeral, just two one's added together. 
      * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
      * 
      * Roman numerals are usually written largest to smallest from left to right. 
      * However, the numeral for four is not IIII. Instead, the number four is written as IV. 
      * Because the one is before the five we subtract it making four. 
      * The same principle applies to the number nine, which is written as IX. 
      * There are six instances where subtraction is used:
      * 
      * I can be placed before V (5) and X (10) to make 4 and 9. 
      * X can be placed before L (50) and C (100) to make 40 and 90. 
      * C can be placed before D (500) and M (1000) to make 400 and 900.
      *
      * Given a roman numral, convert it to an integer.
      * 
      * Example 1:
      * Input: s = "III"
      * Output: 3
      * Explanation: 
      *    III = 3.
      * 
      * Example 2:
      * Input:  s = "LVIII"
      * Output: 58
      * Explanation: 
      *    L = 50, V = 5, III = 3.
      *
      * Example 3:
      * Input:  s = "MCMXCIV"
      * Output: 1994
      * Explanation: 
      *    M = 1000, CM = 900, XC = 90 and IV = 4.      
      *
      * Constraints:
      *     - 1 <= s.length <= 15
      *     - s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
      *     - It is guaranteed that s is a valid roman numeral in the range [1, 3999].
      */  

    /**
     * 
     * Solution 1: 
     * 
     * Result:
     *    - Runtime: 8 ms, faster than 59.55% of Java online submissions for Roman to Integer.
     *    - Memory Usage: 43.1 MB, less than 81.74% of Java online submissions for Roman to Integer.
     * 
     *    - time complexity:    O(n)
     *    - space complexity:   O(1)
     * 
     * @param num an integer
     * @return the Roman representation
     */
    public static int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();

        String[] strRoman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        for (int i = 0; i < values.length; i++) {
            map.put(strRoman[i], values[i]);
        }

        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == 'I' && (i + 1) < s.length() && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X'))
                || (s.charAt(i) == 'X' && (i + 1) < s.length() && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C'))
                || (s.charAt(i) == 'C' && (i + 1) < s.length() && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M'))) {

                result += map.get(s.substring(i, i + 2));   // Be careful with the second argument of subString method
                i++;
                continue;
            }

            result += map.get(s.charAt(i) + "");
        }

        return result;
    } 
}