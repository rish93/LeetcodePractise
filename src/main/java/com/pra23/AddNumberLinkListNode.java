package com.pra23;

public class AddNumberLinkListNode {



    public static void main(String[] args) {
       ListNode l1 = new ListNode(9);
        ListNode l1a = new ListNode(9,l1);
        ListNode l1b = new ListNode(9,l1a);

        ListNode l2 = new ListNode(9);
        ListNode l2a = new ListNode(9,l2);
        ListNode l2b = new ListNode(9,l2a);
        ListNode l2c = new ListNode(9,l2b);

       System.out.println( addTwoNumbers(l1b, l2c));
    }
  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                ListNode dummyHead = new ListNode(0);
                ListNode tail = dummyHead;
                int carry = 0;

                while (l1 != null || l2 != null || carry != 0) {
                    int digit1 = (l1 != null) ? l1.val : 0;
                    int digit2 = (l2 != null) ? l2.val : 0;

                    int sum = digit1 + digit2 + carry;
                    int digit = sum % 10;
                    carry = sum / 10;

                    ListNode newNode = new ListNode(digit);
                    tail.next = newNode;
                    tail = tail.next;

                    l1 = (l1 != null) ? l1.next : null;
                    l2 = (l2 != null) ? l2.next : null;
                }

                ListNode result = dummyHead.next;
                dummyHead.next = null;
                return result;
            }
    }
