package com.blind75.linkedlist;

public class LinkedListCycle {


    public static void main(String[] args) {
        ListNode elem4 = new ListNode(-4);
        ListNode elem3 = new ListNode(0, elem4);
        ListNode elem2 = new ListNode(2, elem3);
        ListNode elem1 = new ListNode(3, elem2);
        elem4.next = elem2;

      /*  while (elem1.next!=null)
        {
            System.out.println(elem1.val);
            elem1 = elem1.next;
        }*/
        System.out.println(hasCycle(elem1));

    }
//TODO Intuition- let's say 2 people are running in a circular track, one person is running slowly and another person is running faster(2 times the speed of first person)
//
//After a certain period of time person 2 again meet or overtake person 1,
//
//In that case we can conclude that the track is circular ( replace running track with our Linked list)
    public static boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {  //Since fast runs faster
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
