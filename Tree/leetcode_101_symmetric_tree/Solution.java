package Google.Tree.leetcode_101_symmetric_tree;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
        {
            return true;
        }
        return helper(root.left,root.right);
    }
    boolean helper(TreeNode left, TreeNode right)
    {
        if(left==null && right == null)
        {
            return true;
        }
        else if(left == null || right == null)
        {
            return false;
        }
        else if(left.val != right.val)
        {
            return false;
        }

        return helper(left.left, right.right) && helper(left.right,right.left);
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }