import leetcode.*;

/**
 * solutions to leetcode problem 21: Merge Two Sorted Lists
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-04-21
 */

 public class P21_mergeTwoLists {
    public static void main(String[] args) {
        P21_mergeTwoLists p21_mergeTwoLists = new P21_mergeTwoLists();

        p21_mergeTwoLists.test();
    }

    public void test() {
        // test case 1        
        // int[] list1 ={1, 2, 4}, list2 = {1, 3, 4};

        // test case 2
        // int[] list1 = {}, list2 = {};

        // test case 3
        // int[] list1 = {}, list2 = {0};

        // test case 4, expected [1,2,4,5]
        // int[] list1 = {5}, list2 = {1, 2, 4};

        // test case 5, expected [-9,-7,-7,-7,-6,-6,-5,-3,-3,-3,-1,2,2,3,4]
        int[] list1 = {-9, -7, -3, -3, -1, 2, 3}, list2 = {-7, -7, -6, -6, -5, -3, 2, 4};

        LinkedList ll_1 = new LinkedList(list1);
        LinkedList ll_2 = new LinkedList(list2);
        ListNode ll_head_1 = ll_1.getHead();
        ListNode ll_head_2 = ll_2.getHead();

        System.out.printf("After merge two sorted lists: ");
        ListNode ll_new_head = mergeTwoLists_1(ll_head_1, ll_head_2);
        
        ll_1.setHead(ll_new_head);
        ll_1.printList();
    }

     /**
      * Problem #:      21
      * Problem:        Merge Two Sorted Lists
      * Difficulty:     Easy
      * 
      * You are given the heads of two sorted linked lists list1 and list2.
      * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
      * Return the head of the merged linked list.
      * 
      * Example 1:
      * Input: list1 = [1,2,4], list2 = [1,3,4]
      * Output: [1,1,2,3,4,4]
      * 
      * Example 2:
      * Input:  list1 = [], list2 = []
      * Output: []
      *
      * Example 3:
      * Input:  list1 = [], list2 = [0]
      * Output: [0]

      * Constraints:
      *     - The number of nodes in both lists is in the range [0, 50].
      *     - -100 <= Node.val <= 100
      *     - Both list1 and list2 are sorted in non-decreasing order.
      */  

    /**
     * 
     * Solution 1: two pointers approach, but with extra space
     * 
     * Result:
     *    - Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
     *    - Memory Usage: 41.7 MB, less than 90.71% of Java online submissions for Merge Two Sorted Lists.
     * 
     *    - time complexity:    O(n)
     *    - space complexity:   O(n)
     * 
     * @param s a string
     * @return true if the input string is valid, false otherwise
     */
    public static ListNode mergeTwoLists_1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }


        ListNode newHead = new ListNode();
        ListNode cur = newHead;

        while (list1 != null && list2 != null) {
            ListNode node = new ListNode();
            if (list1.val < list2.val) {
                node.val = list1.val;
                list1 = list1.next;

            } else {
                node.val = list2.val;
                list2 = list2.next;
            }

            cur.next = node;
            cur = cur.next;            
        }

        // if one list is longer, append the rest of that list to the result
        if (list1 == null) {
            cur.next = list2;
        }

        if (list2 == null) {
            cur.next = list1;
        }

        return newHead.next;    // return head.next because it's the dummy head
    } 

    /**
     * 
     * Solution 2: use recursion with no extra space
     * 
     * Note: 
     *  The solution involves using recursion to merge the two sorting algorithms from the last pointers. 
     *  The issue with this code is that it requires a lot of stack space and hence it cannot be used for large values.
     *  Time complexity : O(n + m), where n and m are sizes of the given linkedlists list1 and list2.
     *  The solution does not use any dummy node, and rather uses the linked list given. 
     *  It effectively merges the two, and hence improves the space complexity.
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
    public static ListNode mergeTwoLists_2(ListNode list1, ListNode list2) {
        return null;
    }
}