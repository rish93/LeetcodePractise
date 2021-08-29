package com.blind75.binarytree;


public class TreeNode {
    TreeNode root;

    // TreeNode TreeNode
    Object data;
    TreeNode left, right;

    TreeNode() {
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    TreeNode(Object data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // Function to insert nodes in level order
    public TreeNode insertLevelOrder(Object[] arr, TreeNode root,
                                     int i) {
        // Base case for recursion
        if (i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            // insert left child
            root.left = insertLevelOrder(arr, root.left,
                    2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right,
                    2 * i + 2);
        }
        return root;
    }

    // Function to print tree nodes in InOrder fashion
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    // Driver program to test above function


}
