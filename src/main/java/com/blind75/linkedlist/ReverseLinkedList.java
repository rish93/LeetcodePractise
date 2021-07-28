package com.blind75.linkedlist;

public class ReverseLinkedList {
    public static void main(String []args) {

        //create linked list

        ListNode node1= new ListNode(5);

        ListNode node2= new ListNode(10,node1);

        ListNode node3= new ListNode(20,node2);
        Solution solution = new Solution();
       ListNode listNodeReverse= solution.reverseList(node3);
    }

}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
