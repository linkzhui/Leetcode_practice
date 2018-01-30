package Google.Tree.Symmertic_transform_a_tree;

import Google.Tree.TreeNode;


//Question: 把一个binary tree以root作为轴心，做轴对称
public class Solution {
    TreeNode tree_sysm_trans_1(TreeNode root)
    {
        if(root==null)
        {
            return null;
        }
        helper(root);
        return root;
    }

    private void helper(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        helper(root.left);
        helper(root.right);
    }

    public TreeNode tree_sym_trans_2(TreeNode root)
    {
        if(root==null)
        {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        helper(root.left);
        helper(root.right);
        return root;
    }




}



