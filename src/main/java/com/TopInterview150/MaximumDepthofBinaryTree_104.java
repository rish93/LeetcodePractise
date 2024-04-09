package com.TopInterview150;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthofBinaryTree_104 {
        /*
        *  Given the root of a binary tree, return its maximum depth.

        *  A binary tree's maximum depth is the number of
        *  nodes along the longest path from the root node
        *  down to the farthest leaf node.

        *  Example 1:

        Input: root = [3,9,20,null,null,15,7]
        Output: 3
        Example 2:

        Input: root = [1,null,2]
        Output: 2

        Constraints:

        The number of nodes in the tree is in the range [0, 104].
        -100 <= Node.val <= 100
    * */

//         3
//     /      \
//   9        20
// /  \       /  \
//null null  15   7
//[3,9,20,null,null,15,7]


    /*
    * why queue is used for BFS
    *
    * A. Queue data structures are considered inherently “fair”. The FIFO concept that underlies a
    * Queue will ensure that those things that were discovered first will be explored first,
    * before exploring those that were discovered subsequently.
    * This “first things first” fairness approach is a fundamental tenet behind BFS. Like waves outward
    *  from a pebble tossed in a pond, a BFS search expands systematically, predictably.
    * Stacks are exactly the opposite of Queues — every datum inserted into a Stack is quite literally
    * “cutting in line” ahead of all others. Who knows when we’ll finally get all the way back to the first
    * element that was inserted into the Stack — maybe never, if new things keep arriving!
    * Stacks give no guarantee of “fairness”. DFS sometimes feels a bit like “going off on a tangent”,
    *  where it is susceptible to getting distracted by the next shiny object that comes along. If you
    * let it, it will pull the leash right out of your hand and chase the squirrel right down a rabbit
    * hole … but in the end it will find everything out there.
    * (I can’t resist ascribing personalities to data structures, hope it helps.)
    *
    * */

    public static void main(String[] args) {
        TreeNode left = new TreeNode(9, null, null);
        TreeNode right = new TreeNode(20, new TreeNode(15,null, null), new TreeNode(7,null, null));
        TreeNode root = new TreeNode(3, left, right);

        System.out.print(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        // If the root is NULL
        // (empty tree), depth is 0
        if (root == null) {
            return 0;
        }

        // Create a queue for
        // level order traversal
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;

        // Push the root node into the queue
        q.add(root);

        // While there are nodes in the queue
        while (!q.isEmpty()) {
            // Get the number of nodes
            // at the current level
            int size = q.size();

            // Process all nodes
            // at the current level
            for (int i = 0; i < size; i++) {
                // Get the front node in the queue
                TreeNode front = q.poll();

                // Enqueue left child if exists
                if (front!=null && front.left != null) {
                    q.add(front.left);
                }

                // Enqueue right child if exists
                if (front.right != null) {
                    q.add(front.right);
                }
            }
            // Increment level to
            // move to the next level
            level++;
        }
        // Return the level, which represents
        // the maximum depth of the tree
        return level;
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
