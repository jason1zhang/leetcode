import leetcode.*;

/**
 * solutions to leetcode problem 19: Remove Nth Node From End of List
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-04-20
 */

 public class P19_removeNthFromEnd {
    public static void main(String[] args) {
        P19_removeNthFromEnd p19_removeNthFromEnd = new P19_removeNthFromEnd();

        p19_removeNthFromEnd.test();
    }

    public void test() {
        // test case 1        
        // int[] head = {1, 2, 3, 4, 5};
        // int n = 2;

        // test case 2
        // int[] head = {1};
        // int n = 1;
        
        // test case 3
        // int[] head = {1,2};
        // int n = 1;

        // test case 4
        int[] head = {1,2};
        int n = 2;        

        LinkedList ll = new LinkedList(head);
        ListNode ll_head = ll.getHead();

        System.out.printf("After Remove {%d}th Node From End of List: ", n);
        ListNode ll_new_head = removeNthFromEnd(ll_head, n);
        
        ll.setHead(ll_new_head);
        ll.printList();
    }

     /**
      * Problem #:      18
      * Problem:        4Sum
      * Difficulty:     Medium
      * 
      * Given the head of a linked list, remove the nth node from the end of the list and return its head.
      * 
      * Example 1:
      * Input: head = [1,2,3,4,5], n = 2
      * Output: [1,2,3,5]
      * 
      * Example 2:
      * Input:  head = [1], n = 1
      * Output: []
      *
      * Example 2:
      * Input:  head = [1,2], n = 1
      * Output: [1]

      * Constraints:
      *     - The number of nodes in the list is sz.
      *     - 1 <= sz <= 30
      *     - 0 <= Node.val <= 100
      *     - 1 <= n <= sz
      */  

    /**
     * 
     * Solution 1: use two points.
     * 
     * Result:
     *    - Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
     *    - Memory Usage: 40.5 MB, less than 84.62% of Java online submissions for Remove Nth Node From End of List.
     * 
     *    - time complexity:    O(n)
     *    - space complexity:   O(1)
     * 
     * @param head head of a linked list
     * @param n Nth node from the end
     * @return new head of the linked list
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head;
        int i = n;

        // right pointer go n steps first
        while (right != null && i > 0) {
            right = right.next;
            i--;
        }

        // left and right pointers move together
        while (right != null && right.next != null) {
            right = right.next;
            left = left.next;
        }

        // right pointer passed the last node
        if (right == null) {
            return head.next;
        }

        left.next = left.next.next;

        return head;
    } 
}