/**
 * solutions to leetcode problem 4: median of two sorted arrays.
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-03-26
 */

 public class P4_medianSortedArrays {
    public static void main(String[] args) {
        P4_medianSortedArrays p4_medianSortedArrays = new P4_medianSortedArrays();

        p4_medianSortedArrays.test();
    }

    public void test() {
        // test case 1
        int[] nums1 = {1,3}, nums2 = {2};

        // test case 2
        // int[] nums1 = {1,2}, nums2 = {3, 4};

        System.out.printf("The median of two sorted arrays is: %f\n ", findMedianSortedArrays(nums1, nums2));

    }

     /**
      * Problem #:      4
      * Problem:        median of two sorted arrays
      * Difficulty:     hard
      * 
      * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
      * The overall run time complexity should be O(log (m+n)).
      * 
      * Example 1:
      * Input: nums1 = [1,3], nums2 = [2]
      * Output: 2.00000
      * Explanation: merged array = [1,2,3] and median is 2.
      * 
      * Example 2:
      * Input: nums1 = [1,2], nums2 = [3,4]
      * Output: 2.50000
      * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
      *
      *
      * Constraints:
      *   - nums1.length == m
      *   - nums2.length == n
      *   - 0 <= m <= 1000
      *   - 0 <= n <= 1000
      *   - 1 <= m + n <= 2000
      *   - -10^6 <= nums1[i], nums2[i] <= 10^6
      */  

    /**
     * find the median of two sorted arrays
     * 
     * Result:
     *    - Runtime: 4 ms, faster than 61.06% of Java online submissions for Median of Two Sorted Arrays.
     *    - Memory Usage: 49.6 MB, less than 62.31% of Java online submissions for Median of Two Sorted Arrays.
     * 
     *    - time complexity: 
     * 
     * @param nums1 a sorted array
     * @param nums2 another sorted array
     * @return median of two sorted array
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2)  {
        int m = nums1.length;
        int n = nums2.length;

        int len = m + n;
        int[] nums = new int[len];

        int i = 0;  // index to the array nums1
        int j = 0;  // index to the array nums2
        int k = 0;  // index to the combined array

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                nums[k] = nums1[i];

                i++;
                k++;
                continue;
            } else {
                nums[k] = nums2[j];
                j++;
                k++;
                continue;
            }
        }

        if (i >= m && j < n) {
            for (; j < n; j++) {
                nums[k] = nums2[j];
                k++;
            }
        }

        if (j >= n && i < m) {
            for (; i < m; i++) {
                nums[k] = nums1[i];
                k++;
            }
        }

        int mid = len / 2;

        return (len % 2 == 1) ? nums[mid] : (nums[mid - 1] + nums[mid]) * 1.0 / 2;
    }
}

