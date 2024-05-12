package com.TopInterview150;

public class InvertBinaryTree_206 {

//Given the root of a binary tree, invert the tree, and return its root.
/*Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]*/
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }


    public static void main(String[] args) {
        InvertBinaryTree_206.TreeNode left = new InvertBinaryTree_206.TreeNode(9, null, null);
        InvertBinaryTree_206.TreeNode right = new InvertBinaryTree_206.TreeNode(20,null, null);

       // InvertBinaryTree_206.TreeNode right = new InvertBinaryTree_206.TreeNode(20, new InvertBinaryTree_206.TreeNode(15,null, null), new InvertBinaryTree_206.TreeNode(7,null, null));
        InvertBinaryTree_206.TreeNode root = new InvertBinaryTree_206.TreeNode(3, left, right);
        invertTree(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

         TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}
