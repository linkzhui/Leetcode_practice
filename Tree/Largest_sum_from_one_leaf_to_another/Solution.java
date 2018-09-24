package Google.Tree.Largest_sum_from_one_leaf_to_another;

import Google.Tree.TreeNode;


//time complexity: O(n)
//space: O(1)
public class Solution {
    public Integer largest_sum(TreeNode root)
    {
        if(root==null)
        {
            return null;
        }
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
         return(helper(root,max));
    }

    private Integer helper(TreeNode root,int[] max)
    {
        if (root == null) {
            return null;
        }
        Integer left_child = helper(root.left, max);
        Integer right_child = helper(root.right, max);
        int cur_max;
        if (left_child == null && right_child == null)
        {
            //reach the left node
            cur_max = root.val;
        } else if (left_child == null || right_child == null) {
            cur_max = left_child != null? left_child : right_child;
        } else{
            cur_max = Math.max(left_child, right_child);
        }
        max[0] = Math.max(max[0],cur_max);
        return cur_max;
    }
}
