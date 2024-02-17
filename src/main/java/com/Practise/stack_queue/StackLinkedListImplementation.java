package com.Practise.stack_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StackLinkedListImplementation {
    static Node top = null;
    static List<Integer> input= List.of(3,4,5,6,77);

    static class Node {
        int data;
        Node next;


        Node(int data){
            this.data =data;
            next=null;
       }
       Node( int data, Node next){
           this.data = data;
           this.next = next;
       }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input: \n 1. Push  \n 2. Pop  \n 3. Display \n 9. Exit");

        boolean flag=true;
        do {
            System.out.println("Enter selection menu");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                {
                    System.out.println("Enter input");
                    int input=sc.nextInt();
                    pushToStack(input);
                    break;
                }
                case 2:
                {
                    System.out.println("Remove from stack");
                    popFromStack();
                    break;
                }
                case 3:
                {
                    displayLinkedList();
                    break;
                }
                case 9:
                {
                    //displayLinkedList();
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("Menu option not in list, please enter again");
                    num = sc.nextInt();
                    break;
                }
            }
        } while(flag);



  //    Node  head =   createLinkedList();

    //  displayLinkedList(head);
    }

    private static void pushToStack(int num){
        Node newNode = new Node(num);
        if(top ==null) {
            top = newNode;
        } else{
            newNode.next = top;
            top = newNode;
        }
    }

    private static void popFromStack(){
        top = top.next;
    }

    private static void displayLinkedList(){
        Node temp=null;
        if(top == null)
            System.out.print("Nothing to display please add element ");
        else
            temp = top;

        while(temp!=null){
                System.out.print(temp.data+", ");
            temp= top.next;
            }
    }

    private static Node createLinkedList() {
        //Node head = new Node();
        Node head = null;

        for(int i: input){
            Node newNode = new Node(i);
            if(head == null) {
                head = newNode;
            }
            else {
                newNode.next = head;
                head = newNode;
            }
        }
        return head;
    }

}
