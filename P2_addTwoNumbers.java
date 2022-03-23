import leetcode.ListNode;
import leetcode.LinkedList;

/**
 * solutions to leetcode problem 2: add two numbers.
 * 
 * result:
 *    Runtime: 3 ms, faster than 72.72% of Java online submissions for Add Two Numbers.
 *    Memory Usage: 48.3 MB, less than 16.43% of Java online submissions for Add Two Numbers.
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-03-23
 */

 public class P2_addTwoNumbers {
    public static void main(String[] args) {
        P2_addTwoNumbers p2_addTwoNumbers = new P2_addTwoNumbers();

        p2_addTwoNumbers.test();
    }

    public void test() {
        // test case 1:
        // int[] num1 = {3, 4, 2};
        // int[] num2 = {4, 6, 5};

        // test case 2:
        // int[] num1 = {0};
        // int[] num2 = {0};

        // test case 3:
        int[] num1 = {9, 9, 9, 9, 9, 9, 9};
        int[] num2 = {9, 9, 9, 9};

        LinkedList ll1 = new LinkedList(num1);
        LinkedList ll2 = new LinkedList(num2);

        ListNode ln1 = ll1.getHead();
        ListNode ln2 = ll2.getHead();

        ll1.printList();
        ll2.printList();

        ListNode ln_result = addTwoNumbers(ln1, ln2);

        LinkedList ll_result = new LinkedList(ln_result);
        ll_result.printList();

    }

     /**
      * Problem #:      2
      * Problem:        add two numbers
      * Difficulty:     medium
      * 
      * You are given two non-empty linked lists representing two non-negative integers. 
      * The digits are stored in reverse order, and each of their nodes contains a single digit. 
      * Add the two numbers and return the sum as a linked list.
      * 
      * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
      * 
      * Example 1:
      * Input: l1 = [2,4,3], l2 = [5,6,4]
      * Output: [7,0,8]
      * Explanation: 342 + 465 = 807.
      * 
      * Example 2:
      * Input: l1 = [0], l2 = [0]
      * Output: [0]
      *
      * Example 3:
      * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
      * Output: [8,9,9,9,0,0,0,1]
      *
      * Constraints:
      *   - The number of nodes in each linked list is in the range [1, 100].
      *   - 0 <= Node.val <= 9
      *   - It is guaranteed that the list represents a number that does not have leading zeros.
      */
  
    /**
     *    - linear traversal over the LinkedList
     *    - time complexity: O(n)
     * 
     * @param l1 head of one integer list
     * @param l2 head of another integer list
     * @return head of the result integer list
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        ListNode node = null;

        int carry = 0;
        int sum = 0;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;

            curr.val = (sum - 10) >= 0 ? (sum - 10) : sum; // ??
            carry = (sum - 10) >= 0 ? 1 : 0;   // ??
           
            
            if (l1.next != null && l2.next != null) {
                node = new ListNode(); 
                curr.next = node;
                curr = curr.next; 
            } 

            l1 = l1.next;
            l2 = l2.next;
        };

        while (l1 != null) {
            if (l1 != null) {
                node = new ListNode();
                curr.next = node;
                curr = curr.next;
            } 

            sum = l1.val + carry;

            curr.val = (sum - 10) >= 0 ? (sum - 10) : sum;  // ??
            carry = (sum - 10) >= 0 ? 1 : 0;   // ??        
                
            l1 = l1.next;
        }

        while (l2 != null) {
            if (l2 != null) {
                node = new ListNode();
                curr.next = node;
                curr = curr.next;
            } 

            sum = l2.val + carry;

            curr.val = (sum - 10) >= 0 ? (sum - 10) : sum;  // ??
            carry = (sum - 10) >= 0 ? 1 : 0;   // ??
                
            l2 = l2.next; 
        }

        if (carry != 0) {
            node = new ListNode(carry);
            curr.next = node;
        }

        return head;
    }
}

