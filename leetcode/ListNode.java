package leetcode;

/**
 * ListNode class.
 * 
 * @author Jason Zhang
 * @version 1.0
 * @since 2022-03-23
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}
    
    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val; 
        this.next = next;
    }
}
