/**
 * solutions to leetcode problem 6: Zigzag conversion.
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-03-30
 */

 public class P6_zigzagConversion {
    public static void main(String[] args) {
        P6_zigzagConversion p6_zigzagConversion = new P6_zigzagConversion();

        p6_zigzagConversion.test();
    }

    public void test() {
        // test case 1
        // String s = "PAYPALISHIRING";
        // int n = 3;

        // test case 2
        // String s = "PAYPALISHIRING";
        // int n = 4;

        // test case 3
        // String s = "A";
        // int n = 1;

        // test case 3
        String s = "AB";
        int n = 1;

        System.out.printf("The zigzag result for {%s} in {%d} rows is: {%s}\n ", s, n, convert(s, n));

    }

     /**
      * Problem #:      6
      * Problem:        Zigzag Conversion.
      * Difficulty:     medium
      * 
      * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
      * (you may want to display this pattern in a fixed font for better legibility).
      * 
      * P   A   H   N
      * A P L S I I G
      * Y   I   R
      *
      * And then read line by line: "PAHNAPLSIIGYIR"
      * 
      * Write the code that will take a string and make this conversion given a number of rows:
      * 
      * Example 1:
      * Input: s = "PAYPALISHIRING", numRows = 3
      * Output: "PAHNAPLSIIGYIR"
      * 
      * Example 2:
      * Input: s = "PAYPALISHIRING", numRows = 4
      * Output: "PINALSIGYAHRPI"
      * Explanaton:
      * P     I    N
      * A   L S  I G
      * Y A   H R
      * P     I
      *
      * Example 3:
      * Input: s = "A", numRows = 1
      * Output: “A”
      *   
      * Constraints:
      *   - 1 <= s.length <= 1000
      *   - s consists of English letters (lower-case and upper-case), ',' and '.'.
      *   - 1 <= numRows <= 1000
      */  

    /**
     * 
     * Solution 1: use StringBuilder
     * 
     * Result:
     *    - Runtime: 10 ms, faster than 69.67% of Java online submissions for Zigzag Conversion.
     *    - Memory Usage: 51.1 MB, less than 39.48% of Java online submissions for Zigzag
     * 
     *    - time complexity:    O(n)
     *    - space complexity:   O(n)
     * 
     * @param s a string
     * @param numRows number of rows
     * @return converted string
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] sbArray = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            sbArray[i] = new StringBuilder();
        }

        int row = 0;                // row index tracker
        boolean isRowDown = true;   // flag for row direction

        for (char ch : s.toCharArray()) {
            sbArray[row].append(ch);

            if (row == numRows - 1) {
                isRowDown = false;
            }

            if (row == 0) {
                isRowDown = true;
            }

            if (isRowDown) {
                row++;
            } else {
                row--;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(sbArray[i].toString());
        }

        return result.toString();
    } 
}

