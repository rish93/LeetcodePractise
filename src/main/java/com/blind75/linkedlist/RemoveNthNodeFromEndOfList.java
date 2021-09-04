package com.blind75.linkedlist;

public class RemoveNthNodeFromEndOfList {

    /*
    *  Remove Nth Node From End of List
Given the head of a linked list, remove the nth node from the end of the list and return its head.
Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
    * */

    /*
    * Hint:
    * 1) Take two pointer on head slow/fast/{ take previous to remove nth last node}TODO {else to find nth element two pointer are sufficient}
    * 2) Forward the fast pointer to nth node
    * 3) Now increase each pointer one at a time till fast.next ==null
    * 4) now slow .value will be your output result
    *
    * */

    public static void main(String[] args) {
        int[] inputArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9,10};

        LinkedListNode head = new LinkedListNode(inputArray[inputArray.length - 1]);
        for (int i = inputArray.length - 2; i >= 0; i--) {
            head = new LinkedListNode(inputArray[i], head);
        }

        int nthNode = 4;
        LinkedListNode output = removeNthFromEnd(head, nthNode);
        while (output != null) {
            System.out.println(output.val);
            output = output.next;
        }
    }

   private static LinkedListNode removeNthFromEnd(LinkedListNode head, int n){
       int count=node_Count(head);
       if(count==1)
           return null;
       if(count==n)
           return head.next;


       LinkedListNode prev=null,slow=head, fast=head;
        int i=1;
       while(i<n){
           fast = fast.next;
           i++;
       }

       while (fast.next!=null){
           fast = fast.next;
           prev = slow;
           slow = slow.next;
       }

       prev.next = slow.next;

    return head;
   }


    public static int node_Count(LinkedListNode head){
        if(head.next == null)
            return 1;
        return 1+node_Count(head.next);
    }

}

class LinkedListNode {
    int val;
    LinkedListNode next;

    LinkedListNode(int val) {
        this.val = val;
    }

    LinkedListNode(int val, LinkedListNode next) {
        this.val = val;
        this.next = next;
    }
}
