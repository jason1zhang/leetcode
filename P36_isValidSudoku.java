import java.util.HashSet;
import leetcode.*;

/**
 * solutions to leetcode problem 36: Valid Sudoku
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-05-15
 */

 public class P36_isValidSudoku {
    public static void main(String[] args) {
        P36_isValidSudoku p36_isValidSudoku = new P36_isValidSudoku();

        p36_isValidSudoku.test();
    }

    public void test() {
        // test case 1        
        char[][] board = {
                    {'5','3','.','.','7','.','.','.','.'}
                   ,{'6','.','.','1','9','5','.','.','.'}
                   ,{'.','9','8','.','.','.','.','6','.'}
                   ,{'8','.','.','.','6','.','.','.','3'}
                   ,{'4','.','.','8','.','3','.','.','1'}
                   ,{'7','.','.','.','2','.','.','.','6'}
                   ,{'.','6','.','.','.','.','2','8','.'}
                   ,{'.','.','.','4','1','9','.','.','5'}
                   ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.printf("The board is a valid Sudolu board? %b.\n", isValidSudoku2(board));
    }

     /**
      * Problem #:      36
      * Problem:        Valid Sudoku
      * Difficulty:     Medium
      * 
      * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
      * 
      *     1. Each row must contain the digits 1-9 without repetition.
      *     2. Each column must contain the digits 1-9 without repetition.
      *     3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
      *
      * Note:
      *     - A Sudoku board (partially filled) could be valid but is not necessarily solvable.
      *     - Only the filled cells need to be validated according to the mentioned rules.
      * 
      * Example 1:
      * Input: board = 
      *             [["5","3",".",".","7",".",".",".","."]
      *             ,["6",".",".","1","9","5",".",".","."]
      *             ,[".","9","8",".",".",".",".","6","."]
      *             ,["8",".",".",".","6",".",".",".","3"]
      *             ,["4",".",".","8",".","3",".",".","1"]
      *             ,["7",".",".",".","2",".",".",".","6"]
      *             ,[".","6",".",".",".",".","2","8","."]
      *             ,[".",".",".","4","1","9",".",".","5"]
      *             ,[".",".",".",".","8",".",".","7","9"]]
      * Output: true
      * 
      * Example 2:
      * Input: board = 
      *             [["8","3",".",".","7",".",".",".","."]
      *             ,["6",".",".","1","9","5",".",".","."]
      *             ,[".","9","8",".",".",".",".","6","."]
      *             ,["8",".",".",".","6",".",".",".","3"]
      *             ,["4",".",".","8",".","3",".",".","1"]
      *             ,["7",".",".",".","2",".",".",".","6"]
      *             ,[".","6",".",".",".",".","2","8","."]
      *             ,[".",".",".","4","1","9",".",".","5"]
      *             ,[".",".",".",".","8",".",".","7","9"]]
      * Output: false
      * Explanation: 
      *     Same as Example 1, except with the 5 in the top left corner being modified to 8. 
      *     Since there are two 8's in the top left 3x3 sub-box, it is invalid.
      *
      * Constraints:
      *     - board.length == 9
      *     - board[i].length == 9
      *     - board[i][j] is a digit 1-9 or '.'.
      */  

    /**
     * 
     * Solution 1: use HashSet - 9 each for rows, columns and squares
     * 
     * Result:
     *    - Runtime: 6 ms, faster than 55.16% of Java online submissions for Valid Sudoku.
     *    - Memory Usage: 47.4 MB, less than 39.92% of Java online submissions for Valid Sudoku.
     * 
     *    - time complexity:    O(n^2)
     *    - space complexity:   O(n^2)
     * 
     * @param board the two dimensional Sudoku board
     * @return true if it's a valid Sudoku board, false otherwise
     */
    public static boolean isValidSudoku1(char[][] board) {
        int size = board.length;

        HashSet<Character>[] hsRow = new HashSet[size];
        HashSet<Character>[] hsCol = new HashSet[size];
        HashSet<Character>[] hsSquare = new HashSet[size];

        for (int i = 0; i < size; i++) {
            hsRow[i] = new HashSet<>();
            hsCol[i] = new HashSet<>();
            hsSquare[i] = new HashSet<>();
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                char ch = board[i][j];

                if (ch == '.') {
                    continue;
                } else if (hsRow[i].contains(ch) || hsCol[j].contains(ch) || hsSquare[(i / 3) * 3 + j / 3].contains(ch)) {
                    return false;
                } else {
                    hsRow[i].add(ch);
                    hsCol[j].add(ch);
                    hsSquare[(i / 3) * 3 + j / 3].add(ch);
                }
            }
        }

        return true;
    }

    /**
     * 
     * Solution 2: use one HashSet
     * 
     * Result:
     *    - Runtime: 29 ms, faster than 11.05% of Java online submissions for Valid Sudoku.
     *    - Memory Usage: 54.3 MB, less than 5.31% of Java online submissions for Valid Sudoku.
     * 
     *    - time complexity:    O(n^2)
     *    - space complexity:   O(n^2)
     * 
     * @param board the two dimensional Sudoku board
     * @return true if it's a valid Sudoku board, false otherwise
     */
    public static boolean isValidSudoku2(char[][] board) {
        HashSet<String> hs = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char ch = board[i][j];

                if (ch != '.') {
                    if (!hs.add(String.format("row %d: {%c}", i, ch)) 
                        || !hs.add(String.format("col %d: {%c}", j, ch))
                        || !hs.add(String.format("square %d: {%c}", (i / 3) * 3 + j / 3, ch))){
                            return false;
                    }
                }
            }
        }

        return true;
    }
}