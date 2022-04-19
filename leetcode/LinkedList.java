package leetcode;

public class LinkedList {
    private ListNode head;

    public LinkedList() {
        head = new ListNode();
    }

    public LinkedList(ListNode head) {
        this.head = head;
    }

    public LinkedList(int[] nums) {
        head = new ListNode();
        buildList(nums);
    }

    public ListNode getHead() {
        return this.head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    /**
     * build the list from an array of integers
     * @param nums an array of integers
     * @return the list
     */
    public void buildList(int[] nums) {
        if (nums.length == 0)
            return;

        ListNode curr = head;
        ListNode node = null;

        head.val = nums[0];
                
        for (int i  = 1; i < nums.length; i++) {
            node = new ListNode(nums[i]);
            curr.next = node;
            curr = curr.next;
        }
    }  

    /**
     * print out the list
     * 
     * @param head the first node of the list
     */
    public void printList() {
        while (this.head != null) {
            System.out.print(head.val + " ");
            this.head = this.head.next;
        }

        System.out.println("\n");
    }
}
