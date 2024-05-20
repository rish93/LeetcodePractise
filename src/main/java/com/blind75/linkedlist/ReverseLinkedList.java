package com.blind75.linkedlist;

/*
* Initialize three pointers prev as NULL, curr as head and next as NULL.
 Iterate through the linked list. In loop, do following.
// Before changing next of current,
// store next node
1) next = curr->next
// Now change next of current
// This is where actual reversing happens
2) curr->next = prev
// Move prev and curr one step forward
3)prev = curr
4)curr = next
* */

public class ReverseLinkedList {
    public static void main(String[] args) {
        int[] inputArray = new int[]{1, 2, 3, 4, 5};

        Node head = new Node(inputArray[inputArray.length - 1]);
        for (int i = inputArray.length - 1; i >= 0; i--) {
            head = new Node(inputArray[i], head);
        }
        Node output = reverseLinkedList(head);
        while (output != null) {
            System.out.println(output.value);
            output=output.next;
        }

    }
// 1step is to make head.next empty  and then shift the previousnode to curent and current to next

    static Node reverseLinkedList(Node current) {
        Node prev= null;
        while (current.next!=null)
        {                                 // [head 1]  -> [ 2] -> [ 3] ->  [ 4] -> [ 5]-> null
            Node nextNode = current.next;    //[next  node]->[2]
            current.next=prev;                   //    [null]<-[2]
            prev=current;       //1 step        //
            current=nextNode;  //2nd step
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

