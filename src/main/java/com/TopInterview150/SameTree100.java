package com.TopInterview150;

public class SameTree100 {
    public static void main(String[] args) {
       TreeNode left = new TreeNode(9, null, null);
       TreeNode right = new TreeNode(20, new TreeNode(15,null, null), new TreeNode(7,null, null));
       TreeNode root = new TreeNode(3, left, right);


        TreeNode left2 = new TreeNode(9, null, null);
        TreeNode right2 = new TreeNode(20, new TreeNode(15,null, null), new TreeNode(7,null, null));
        TreeNode root2 = new TreeNode(3, left2, right2);

        System.out.print(isSameTree(root, root2));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);

        // Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        // Queue<TreeNode> queue2 = new LinkedList<TreeNode>();

        // queue1.add(p);
        // queue2.add(q);

        // while(!queue1.empty() && !queue2.empty()){

        //   int size1=queue1.size();
        //   int size2=queue2.size();

        //   TreeNode frontQueue1= queue1.pop();
        //   TreeNode frontQueue2= queue2.pop();
        //}
    }


    static class TreeNode {
        int val;
        com.TopInterview150.SameTree100.TreeNode left;
        com.TopInterview150.SameTree100.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,  com.TopInterview150.SameTree100.TreeNode left,  com.TopInterview150.SameTree100.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
