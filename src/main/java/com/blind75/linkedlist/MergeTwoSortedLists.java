package com.blind75.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode elem3 = new ListNode(4);
        ListNode elem2 = new ListNode(2, elem3);
        ListNode elem1 = new ListNode(1, elem2);
        ListNode elem6 = new ListNode(4);
        ListNode elem5 = new ListNode(3, elem6);
        ListNode elem4 = new ListNode(1, elem5);

        //ListNode output = mergeTwoLists(elem1, elem4);
        ListNode output = mergeTwoListsBestApproach(elem1, elem4);
        while (output != null) {
            System.out.println(output.val);
            output = output.next;
        }
    }

    public static ListNode mergeTwoListsBestApproach(ListNode l1, ListNode l2) {
        ListNode tempNode = new ListNode(0);
        ListNode currentnode = tempNode;
//1234   1289    11223489
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                currentnode.next = l1;
                l1 = l1.next;
            } else {
                currentnode.next = l2;
                l2 = l2.next;
            }
            currentnode = currentnode.next;
        }
        if (l1 != null) {
            currentnode.next = l1;
            l1 = l1.next;
        }
        if (l2 != null) {
            currentnode.next = l2;
            l2 = l2.next;
        }
        return tempNode.next;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> listelement = new ArrayList<>();
        ListNode l3 = null;
        if (l1 == null && l2 == null)
            return l3;

        while (l1 != null) {
            listelement.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            listelement.add(l2.val);
            l2 = l2.next;
        }
        Collections.sort(listelement);

        if (listelement.size() > 0) {
            l3 = new ListNode(listelement.get(listelement.size() - 1), null);
            for (int i = listelement.size() - 2; i >= 0; i--) {
                l3 = new ListNode(listelement.get(i), l3);
            }
        }
        return l3;
    }
}
