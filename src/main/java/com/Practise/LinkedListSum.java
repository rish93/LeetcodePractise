package com.Practise;

    public class LinkedListSum {

        public static void main(String []args){
            ListNode listNode = new ListNode(4);

           ListNode listNode2  =listNode.next;
            listNode2.val=6;

            ListNode listNode3=listNode2.next;
            listNode3.val=9;


            System.out.println(listNode.val);
            System.out.println(listNode.next.val);
            System.out.println(listNode.next.next.val);

        }
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    class Solution{

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode p = l1, q = l2, curr = dummyHead;
            int carry = 0;
            while (p != null || q != null) {
                int x = (p != null) ? p.val : 0;
                int y = (q != null) ? q.val : 0;
                int sum = carry + x + y;
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (p != null) p = p.next;
                if (q != null) q = q.next;
            }
            if (carry > 0) {
                curr.next = new ListNode(carry);
            }
            return dummyHead.next;
        }
    }
