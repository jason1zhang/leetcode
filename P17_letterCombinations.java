import java.util.List;

/**
 * solutions to leetcode problem 17: Letter Combinations of a Phone Number
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-04-17
 */

 public class P17_letterCombinations {
    public static void main(String[] args) {
        P17_letterCombinations p17_letterCombinations = new P17_letterCombinations();

        p17_letterCombinations.test();
    }

    public void test() {
        // test case 1
        String digits = "23";

        // test case 2
        // String digits = "";      


        // test case 3
        // String digits = "2";      

        System.out.printf("The letter combinations for the string {%s} is \n", letterCombinations(digits));
    }

     /**
      * Problem #:      17
      * Problem:        Letter Combinations of a Phone Number
      * Difficulty:     Medium
      * 
      * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. 
      * Return the answer in any order.
      *
      * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
      * 
      * Example 1:
      * Input: digits = "23"
      * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
      * 
      * Example 2:
      * Input:  digits = ""
      * Output: []
      *
      * Example 3:
      * Input:  digits = "2"
      * Output: ["a","b","c"]

      * Constraints:
      *     - 0 <= digits.length <= 4
      *     - digits[i] is a digit in the range ['2', '9'].
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
     * @param digits a string containing digits from 2-9 inclusive
     * @return all possible letter combinations that the number could represent
     */

    public static List<String> letterCombinations(String digits) {

        return null;
    } 
}