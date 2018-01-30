package Google.Tree.leetcode_101_Symmertic_Tree;

//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

import Google.Tree.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        return helper(root.left,root.right);

    }

    private boolean helper(TreeNode left, TreeNode right)
    {
        if(left!=right)
        {
            return false;
        }
        else if(left == null && right == null)
        {
            return true;
        }
        else if(left == null || right == null)
        {
            return false;
        }
        return helper(left.left,right.right) && helper(left.right,right.left);
    }
}
