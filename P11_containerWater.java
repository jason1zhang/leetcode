/**
 * solutions to leetcode problem 11: Container with Most Water
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-04-07
 */

 public class P11_containerWater {
    public static void main(String[] args) {
        P11_containerWater p11_containerWater = new P11_containerWater();

        p11_containerWater.test();
    }

    public void test() {
        // test case 1
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        // test case 2
        // int[] height = {1, 1};        
        System.out.printf("The maximum amount of water a container can store is {%d}\n ", maxArea1(height));
    }

     /**
      * Problem #:      11
      * Problem:        Container with Most Water
      * Difficulty:     Medium
      * 
      * You are given an integer array height of length n. 
      * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
      *
      * Find two lines that together with the x-axis form a container, such that the container contains the most water.
      * 
      * Return the maximum amount of water a container can store.
      *
      *Notice that you may not slant the container.
      * 
      * Example 1:
      * Input: height = [1,8,6,2,5,4,8,3,7]
      * Output: 49
      * Explanation: 
      *    The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
      *    In this case, the max area of water (blue section) the container can contain is 49.
      * 
      * Example 2:
      * Input: height = [1,1]
      * Output: 1
      *
      *
      * Constraints:
      *     - n == height.length
      *     - 2 <= n <= 105
      *     - 0 <= height[i] <= 104
      */  

    /**
     * 
     * Solution 1: brute force
     * 
     * Result:
     *    - Runtime: Time Limit Exceeded
     * 
     *    - time complexity:    O(n^2)
     *    - space complexity:   O(1)
     * 
     * @param height an array of integers
     * @return the maximum amount of water a container can store
     */
    public static int maxArea1(int[] height) {
        if (height.length == 1) {
            return 0;
        }

        int maxWater = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = (i + 1); j < height.length; j++) {
                maxWater = Math.max(maxWater, (j - i) * Math.min(height[i], height[j]));
            }
        }

        return maxWater;
    } 

    /**
     * 
     * Solution 2: two pointers
     * 
     * Result:
     *    - Runtime: 
     * 
     *    - time complexity:    O(n)
     *    - space complexity:   O(1)
     * 
     * @param height an array of integers
     * @return the maximum amount of water a container can store
     */
    public static int maxArea2(int[] height) {
        return 0;
    }
}