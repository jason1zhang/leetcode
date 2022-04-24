import leetcode.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * solutions to leetcode problem 23: Merge k Sorted Lists
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-04-24
 */

 public class P23_mergeKLists {
    public static void main(String[] args) {
        P23_mergeKLists p23_mergeKLists = new P23_mergeKLists();

        p23_mergeKLists.test();
    }

    public void test() {
        // test case 1        
        int[] list1 ={1, 4, 5}, list2 = {1, 3, 4}, list3 = {2, 6};

        // test case 2
        // int[] list1 = {};

        LinkedList ll_1 = new LinkedList(list1);
        LinkedList ll_2 = new LinkedList(list2);
        LinkedList ll_3 = new LinkedList(list3);

        ListNode ll_head_1 = ll_1.getHead();
        ListNode ll_head_2 = ll_2.getHead();
        ListNode ll_head_3 = ll_3.getHead();

        ListNode[] lists = {ll_head_1, ll_head_2, ll_head_3};

        System.out.printf("After merge K sorted lists: ");
        ListNode ll_new_head = mergeKLists(lists);
        
        ll_1.setHead(ll_new_head);
        ll_1.printList();        
    }

     /**
      * Problem #:      23
      * Problem:        Merge k Sorted Lists
      * Difficulty:     Hard
      * 
      * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
      * Merge all the linked-lists into one sorted linked-list and return it.
      * 
      * Example 1:
      * Input: lists = [[1,4,5],[1,3,4],[2,6]]
      * Output: [1,1,2,3,4,4,5,6]
      * 
      * Example 2:
      * Input:  lists = []
      * Output: []
      *
      * Example 3:
      * Input:  lists = [[]]
      * Output: []

      * Constraints:
      *     - k == lists.length
      *     - 0 <= k <= 10^4
      *     - 0 <= lists[i].length <= 500
      *     - -10^4 <= lists[i][j] <= 10^4
      *     - lists[i] is sorted in ascending order.
      *     - The sum of lists[i].length will not exceed 10^4.
      */  

    /**
     * 
     * Solution 1: Brute Force
     *      - Traverse all the linked lists and collect the values of the nodes into an array.
     *      - Sort and iterate over this array to get the proper value of nodes.
     *      - Create a new sorted linked list and extend it with the new nodes.
     * 
     * Result:
     *    - Runtime: 7 ms, faster than 53.85% of Java online submissions for Merge k Sorted Lists.
     *    - Memory Usage: 47.9 MB, less than 23.98% of Java online submissions for Merge k Sorted Lists.
     * 
     *    - time complexity:    O(n*log(n))
     *    - space complexity:   O(n)
     * 
     * @param s a string
     * @return true if the input string is valid, false otherwise
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ArrayList<Integer> tempList = new ArrayList<>();

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }

            ListNode node = lists[i];
            while (node != null) {
                tempList.add(node.val);
                node = node.next;
            }
        }

        Object[] arrObj = tempList.toArray();

        if (arrObj.length == 0) {
            return null;
        }

        int length = arrObj.length;
        int arrInt[] = new int[length];

        for (int i = 0; i < length; i++) {
           arrInt[i] = (int) arrObj[i];
        }

        Arrays.sort(arrInt);

        ListNode head = new ListNode(arrInt[0]);
        ListNode current = head;

        for (int i = 1; i < arrInt.length; i++) {
            ListNode node = new ListNode(arrInt[i]);
            current.next = node;
            current = current.next;
        }

        return head;
    } 
}