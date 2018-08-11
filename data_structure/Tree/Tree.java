package Google.data_structure.Tree;

import Google.Tree.TreeNode;

public class Tree {

    public TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    public TreeNode insert_iterative(TreeNode root, int target) {
        TreeNode newnode = new TreeNode(target);
        if (root == null) {
            return newnode;
        }
        TreeNode cur = root;
        while (cur.val != target) {
            if (cur.val > target) {
                if (cur.left == null) {
                    cur.left = newnode;
                    break;
                } else {
                    cur = cur.left;
                }
            } else {
                //cur.val<target
                if (cur.right == null) {
                    cur.right = newnode;
                    break;
                } else {
                    cur = cur.right;
                }
            }
        }
        return root;
    }

    public TreeNode insert_recursion(TreeNode root, int target)
    {
        if(root == null)
        {
            return new TreeNode(target);
        }
        insert_recusrsion_helper(root,target);
        return root;
    }

    private void insert_recusrsion_helper(TreeNode root, int target)
    {
        if(root.val==target)
        {
            return;
        }
        else if(root.val<target)
        {
            if(root.right==null){
                root.right = new TreeNode(target);
            }
            else{
                insert_recusrsion_helper(root.right,target);
            }
        }
        else{
            if(root.left==null){
                root.left = new TreeNode(target);
            }
            else{
                insert_recusrsion_helper(root.left,target);
            }
        }
    }



}
