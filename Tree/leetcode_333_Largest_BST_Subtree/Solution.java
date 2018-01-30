package Google.Tree.leetcode_333_Largest_BST_Subtree;

import Google.Tree.TreeNode;

public class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        int[] max = new int[1];
        helper(root, max);
        return max[0];
    }
    private element helper(TreeNode root,int[] max)
    {
        if(root == null)
        {
            return new element(0,true,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        element left_child = helper(root.left,max);
        element right_child = helper(root.right,max);
        if(left_child.isValid && right_child.isValid && root.val>=left_child.max && root.val<=right_child.min)
        {
            int length = left_child.length+right_child.length+1;
            max[0] = Math.max(max[0],length);
            return new element(length,true,left_child.min,right_child.max);
        }
        return new element(1,false,root.val,root.val);


    }
    private class element{
        int length;
        boolean isValid;
        int min;
        int max;
        public element(int length, boolean isValid, int min,int max)
        {
            this.length = length;
            this.isValid = isValid;
            this.min = min;
            this.max = max;
        }
    }
}
