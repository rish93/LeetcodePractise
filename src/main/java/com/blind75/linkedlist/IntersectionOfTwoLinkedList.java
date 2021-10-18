package com.blind75.linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count1 = 0,count2 = 0;
        int diff = 0;

        //finding the lengths of the linked lists
        ListNode curr = headA;
        while(curr != null){
            count1++;
            curr = curr.next;
        }

        ListNode temp;

        curr = headB;
        while(curr != null){
            count2++;
            curr = curr.next;
        }

        //finding the bigger list
        if(count1 > count2){
            curr = headA;
            temp = headB;
        }
        else{
            curr = headB;
            temp = headA;
        }

        //Traversing the bigger list until lengths of both the lists become same
        diff = Math.abs(count1-count2);
        for(int i=0;i<diff; i++){
            if(curr != null){
                curr = curr.next;
            }
        }

        //comparing nodes of both lists
        while(curr != null && temp != null){
            if(curr == temp){
                return curr;
            }
            curr = curr.next;
            temp = temp.next;
        }
        return null;
    }
}
