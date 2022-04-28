import leetcode.*;

/**
 * solutions to leetcode problem 24: Swap Nodes in Pairs
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-04-25
 */

 public class P24_swapPairs {
    public static void main(String[] args) {
        P24_swapPairs p24_swapPairs = new P24_swapPairs();

        p24_swapPairs.test();
    }

    public void test() {
        // test case 1        
        int[] list = {1, 2, 3, 4};

        // test case 2
        // int[] list = {};

        // test case 3
        // int[] list = {1};

        // test case 4, expected [2, 1, 3]
        // int[] list = {1, 2, 3};

        LinkedList ll = new LinkedList(list);
        ListNode ll_head = ll.getHead();

        System.out.printf("After swapping the pairs in the list: ");
        ListNode ll_new_head = swapPairs_1(ll_head);
        
        ll.setHead(ll_new_head);
        ll.printList();        
    }

     /**
      * Problem #:      24
      * Problem:        Swap Nodes in Pairs
      * Difficulty:     Medium
      * 
      * Given a linked list, swap every two adjacent nodes and return its head. 
      * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
      * 
      * Example 1:
      * Input: head = [1,2,3,4]
      * Output: [2,1,4,3]
      * 
      * Example 2:
      * Input:  head = []
      * Output: []
      *
      * Example 3:
      * Input:  head = [1]
      * Output: [1]

      * Constraints:
      *     - The number of nodes in the list is in the range [0, 100].
      *     - 0 <= Node.val <= 100
      */  

    /**
     * 
     * Solution 1: use three pointers
     * 
     * Result:
     *    - Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
     *    - Memory Usage: 41.7 MB, less than 57.21% of Java online submissions for Swap Nodes in Pairs.
     * 
     *    - time complexity:    O(n)
     *    - space complexity:   O(1)
     * 
     * @param s a string
     * @return true if the input string is valid, false otherwise
     */
    public static ListNode swapPairs_1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;
        ListNode prev = first;

        head = first.next;

        while (first != null && second != null) {
            first.next = second.next;
            second.next = first;

            prev = first;
        
            first = first.next;

            if (first == null) {
                break;
            }

            second = first.next;

            if (second != null) {
                prev.next = second;
            }
        }

        return head;
    } 

    /**
     * 
     * Solution 2: recursive
     * 
     * Result:
     *    - Runtime: 
     * 
     *    - time complexity:    O()
     *    - space complexity:   O()
     * 
     * @param s a string
     * @return true if the input string is valid, false otherwise
     */
    public static ListNode swapPairs_2(ListNode head) {
        return null;
    }
}