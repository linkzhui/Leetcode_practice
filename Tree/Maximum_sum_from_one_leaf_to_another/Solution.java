package Google.Tree.Maximum_sum_from_one_leaf_to_another;

import Google.Tree.TreeNode;

public class Solution {
    public int max_sum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int[] max = new int[1];
        helper(root, max);
        return max[0];
    }

    private int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left_child = helper(root.left,max);
        int right_child = helper(root.right,max);
        if (root.left!=null && root.right!=null) {
            //这里需要判断下左右孩子是不是为null
            //因为有可能左边有孩子，path sum == 0的情况
            max[0] = Math.max(max[0],root.val+left_child+right_child);
            return root.val+Math.max(left_child,right_child);
        }

        //如果少一个孩子，就不用比较max，直接return
        return root.left == null? (root.val + right_child) : (root.val+left_child);
    }
}
