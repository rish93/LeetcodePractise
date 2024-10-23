package com.GraphAndTree;

// Java program to search in
// a BST.
class Node {
    int data;
    Node left, right;

    public Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}

public class BinarySearchTree_searchelement {
    static boolean searchWithIteration(Node root, int x) {
        while(root!=null) {
            if (x == root.data){
                return true;
            }
            if(x>root.data){
                root = root.right;
            }else root=root.left;
        }
        return false;
    }

    static boolean searchWithRecursion(Node root, int x) {
        if(root ==null || root.data==x)
            return true;

        if(x<root.data) {
           return searchWithRecursion(root.left,x);
        }
        return searchWithRecursion(root.right,x);
    }
    public static void main(String[] args) {
        // Create a hard coded BST.
        //        20
        //       /  \
        //      8   22
        //     / \
        //   4   12
        //       /  \
        //     10   14
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);

        int x = 12;
        System.out.println(searchWithRecursion(root, x));

        System.out.println(searchWithIteration(root, 14));

    }
}
