package com.blind75.binarytree;

public class HeightBinaryTree {

    public static void main(String args[]) {
        TreeNode t2 = new TreeNode();
        Object arr[] = {3, 9, 20, null, null, 15, 7};
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        t2.inOrder(t2.root);
/*                1
             2     3
           4   5   7  6
          6  6*/
        //Print the Tree in order
        System.out.println("Max Depth -->"+maxDepth(t2));
    }

    public static int maxDepth(TreeNode root) {

        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int height = 0;
        if (left > right)
            height = left + 1;
        else height = right + 1;
        return height;

    }


}
