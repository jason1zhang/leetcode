import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * solutions to leetcode problem 3: longest substring withtout repeating characters.
 * 
 * note:
 *    - useful link: https://www.code-recipe.com/post/longest-substring-without-repeating-characters 
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-03-25
 */

 public class P3_longestSubString {
    public static void main(String[] args) {
        P3_longestSubString p3_longestSubString = new P3_longestSubString();

        p3_longestSubString.test();
    }

    public void test() {
        // test case 1
        String s = "abcabcbb";

        // test case 2
        // String s = "bbbbb";

        // test case 3
        // String s = "pwwkew";

        // test case 4
        // String s = " ";

        // test case 5
        // String s = "dvdf";

        // test case  6
        // String s = "aab";

        // System.out.printf("The length of the longest substring {%s} is: %d\n ", s, lengthOfLongestSubstring_1(s));
        System.out.printf("The length of the longest substring {%s} is: %d\n ", s, lengthOfLongestSubstring_2(s));

    }

     /**
      * Problem #:      3
      * Problem:        longest substring without repeating characters
      * Difficulty:     medium
      * 
      * Given a string s, find the length of the longest substring without repeating characters.
      * 
      * Example 1:
      * Input: s = "abcabcbb"
      * Output: 3
      * Explanation: The answer is "abc", with the length of 3.
      * 
      * Example 2:
      * Input: s = "bbbbb"
      * Output: 1
      * Explanation: The answer is "b", with the length of 1.
      *
      * Example 3:
      * Input: s = "pwwkew"
      * Output: 3
      * Explanation: The answer is "wke", with the length of 3.
      * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
      *
      * Constraints:
      *   - 0 <= s.length <= 5 * 104
      *   - s consists of English letters, digits, symbols and spaces.
      */
  
    /**
     * 1st solution:
     * 
     * Result:
     *    - Runtime: 224 ms, faster than 9.92% of Java online submissions for Longest Substring Without Repeating Characters.
     *    - Memory Usage: 118.3 MB, less than 5.48% of Java online submissions for Longest Substring Without Repeating Characters.
     * 
     *    - time complexity: O(n^2) ?
     * 
     * @param s a string
     * @return the length of longest substring
     */
    public static int lengthOfLongestSubstring_1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int maxLen = 0;
        int len = 0;
        char ch;

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);

            if (!map.containsKey(ch)) {
                map.put(ch, i);
                len++;

            } else {
                int index = map.get(ch);

                i--;    // important!!

                // remove the mapping, whose indexes are before the repeating character, from the HashMap
                Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();

                while (iterator.hasNext()) {
        
                    Map.Entry<Character, Integer> entry = iterator.next();

                    if (entry.getValue() <= index) {
                        iterator.remove();
                    }

                    // re-position the loop index
                    if (entry.getValue() - 1 == index) {
                        i = entry.getValue() - 1;   // re-position the loop index i
                    }
                }

                maxLen = len > maxLen ? len : maxLen;
                len = 0;

                map.clear();    // clear the mapping in the map
            }
        }

        return len > maxLen ? len : maxLen;
    }

    /**
     * 2nd solution: sliding window approach
     * 
     * Result:
     *    - Runtime: 5 ms, faster than 86.51% of Java online submissions for Longest Substring Without Repeating Characters.
     *    - Memory Usage: 42.2 MB, less than 90.98% of Java online submissions for Longest Substring Without Repeating Characters.
     * 
     *    - time complexity:    O(n)
     *    - space complexity:   O(1)
     * 
     * @param s a string
     * @return the length of longest substring
     */
    public static int lengthOfLongestSubstring_2(String s) {
        int n = s.length();        
        int maxLen = 0;

        // Map to store visited characters along with their index
        HashMap<Character, Integer> map = new HashMap<>();
        
        // start indicates the start of current substring
        int start = 0;
        char ch;

        // Iterate through the string and slide the window each time you find a duplicate.
	    // The end index indicates the end of current substring.
        for (int end = 0; end < n; end++) {
            ch = s.charAt(end);

            // Check if the current character is a duplicate
            if (map.containsKey(ch)) {
                //  Update the result for the substring in the current window before we found duplicate character
                maxLen = maxLen > (end - start) ? maxLen : (end - start);

                // Remove all characters before the new
                for (int i = start; i < map.get(ch); i++) {
                    map.remove(s.charAt(i));
                }

                // Slide the window since we have found a duplicate character
                start = map.get(ch) + 1;
            }

            // Add the current character to hashmap
            map.put(s.charAt(end), end);
        }

        // Update the result for last window
	    // For a input like "abc" the execution will not enter the above if statement for checking duplicates
        maxLen = maxLen > (n - start) ? maxLen : (n - start);

        return maxLen;
    }
}

