package Google.Tree.Invert_Binary_Tree_226;

import Google.Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        //iterative way, invert the current node's left child and right child, then push it's new left child and right child to queue
        //keep iterate whole the tree to finish the invert
        if(root==null)
        {
            return root;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while(!queue.isEmpty())
        {
            TreeNode temp = queue.pollFirst();
            TreeNode temp_left = temp.left;
            temp.left = temp.right;
            temp.right = temp_left;
            if(temp.left!=null)
            {
                queue.offerLast(temp.left);
            }
            if(temp.right!=null)
            {
                queue.offerLast(temp.right);
            }
        }
        return root;
    }
}
