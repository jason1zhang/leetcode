import java.util.ArrayDeque;

/**
 * solutions to leetcode problem 20: Valid Parentheses
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-04-21
 */

 public class P20_validParentheses {
    public static void main(String[] args) {
        P20_validParentheses p20_validParentheses = new P20_validParentheses();

        p20_validParentheses.test();
    }

    public void test() {
        // test case 1        
        // String s = "()";

        // test case 2
        // String s = "()[]{}";
                
        // test case 3
        // String s = "(]";

        // test case 4
        // String s = "]";

        // test case 5
        String s = "){";

        System.out.printf("The string {%s} is valid? {%b}\n", s, isValid(s));
    }

     /**
      * Problem #:      20
      * Problem:        Valid Parentheses
      * Difficulty:     Easy
      * 
      * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
      * 
      * An input string is valid if:
      *     - Open brackets must be closed by the same type of brackets.
      *     - Open brackets must be closed in the correct order.
      * 
      * Example 1:
      * Input: s = "()"
      * Output: true
      * 
      * Example 2:
      * Input:  s = "()[]{}"
      * Output: true
      *
      * Example 3:
      * Input:  s = "(]"
      * Output: false

      * Constraints:
      *     - 1 <= s.length <= 10^4
      *     - s consists of parentheses only '()[]{}'.
      */  

    /**
     * 
     * Solution 1: use ArrayDeque to represent the stack
     * 
     * Result:
     *    - Runtime: 3 ms, faster than 48.59% of Java online submissions for Valid Parentheses.
     *    - Memory Usage: 41.9 MB, less than 57.28% of Java online submissions for Valid Parentheses.
     * 
     *    - time complexity:    O(n)
     *    - space complexity:   O(n)
     * 
     * @param s a string
     * @return true if the input string is valid, false otherwise
     */
    public static boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() && (ch == ')' || ch == '}' || ch == ']')) {
                return false;
            }

            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;

                case ')':
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }

                    break;

                case '}':
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }

                    break;

                case ']':
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }

                    break;
            }
        }

        return stack.isEmpty();
    } 
}