package com.blind75.linkedlist;/*
package com.blind75.linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {

        //create linked list
        //20->10->5->null
        int[] arr = new int[]{1, 2, 3, 4, 5};
        Node head = new Node(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            head = new Node(arr[i], head);
        }
        Solution solution = new Solution();
        Node nodeReverse = solution.reverseList(head);
    }

}

class Solution {
    public Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;                //1
        while (curr != null) {
            Node nextTemp = curr.next;      //2
            curr.next = prev;              //null
            prev = curr;                   //1
            curr = nextTemp;               // 2
        }
        return prev;
    }
}

class Node {
    int val;
    Node next;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
*/


public class ReverseLinkedList {
    public static void main(String[] args) {
        int[] inputArray = new int[]{1, 2, 3, 4, 5};

        Node head = new Node(inputArray[inputArray.length - 1]);
        for (int i = inputArray.length - 2; i >= 0; i--) {
            head = new Node(inputArray[i], head);
        }
        Node output = reverseLinkedList(head);
        while (output.next != null) {
            System.out.println(output.value);
            output=output.next;
        }

    }

    static Node reverseLinkedList(Node head) {
        Node prev= null;
        while (head.next!=null)
        {
            Node nextNode = head.next;
            head.next=prev;
            prev=head;       //1 step
            head=nextNode;  //2nd step
        }
        return prev;
    }

}


class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

}

