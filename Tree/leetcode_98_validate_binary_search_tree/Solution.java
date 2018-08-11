package Google.Tree.leetcode_98_validate_binary_search_tree;

public class Solution {
    public boolean is_BST(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        return helper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean helper(TreeNode root, int min, int max)
    {
        if(root==null)
        {
            return true;
        }

        if(root.val<max&&root.val>min)
        {
            return helper(root.left,min,root.val)&&helper(root.right,root.val,max);
        }
        else{
            return false;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
