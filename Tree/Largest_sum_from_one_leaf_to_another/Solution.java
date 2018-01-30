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
        int max = Integer.MIN_VALUE;
         return(helper(root,max));
    }

    private Integer helper(TreeNode root,int max)
    {
        if(root == null)
        {
            return 0;
        }

        int left_child = helper(root.left,max);
        int right_child = helper(root.right,max);
        if(root.left!=null && root.right!=null)
        {
            //if the root is full node, there must exist a path from one leaf
            //to another leaf node
            max = Math.max(max,root.val+left_child+right_child);
            return Math.max(left_child,right_child)+root.val;
        }

        //node is not a full node
        return root.left!=null? right_child+root.val:left_child+root.val;

    }
}
