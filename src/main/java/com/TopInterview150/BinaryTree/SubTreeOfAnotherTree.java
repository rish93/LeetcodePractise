package com.TopInterview150.BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SubTreeOfAnotherTree {

    public static void main(String[] args) {

    }


    public boolean isSubtree(TreeNode root, TreeNode subroot){
        boolean ans=false;
        Queue<TreeNode> subqueue = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        subqueue.add(subroot);
        subqueue.add(root.left);
        subqueue.add(root.right);

        queue.add(root);

        while(!queue.isEmpty()){

            if(root.left !=null) queue.add(root.left);
            if(root.right !=null) queue.add(root.right);

            ans= Arrays.equals(queue.toArray(), subqueue.toArray());
            queue.remove();
        }

        return ans;
    }
}


class TreeNode {
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