package Google.Tree.BST_Iterative_traversal.preorder_tree_traversal;

import Facebook.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

//we always print the root first, then root can be eliminate from the stack
//we traverse left sub tree first, therefore, we need to push right sub tree into stack first
// then left sub tree.
public class Solution {
    public void preOrder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerLast(root);
        while(!stack.isEmpty())
        {
            TreeNode cur = stack.pollLast();
            System.out.println(cur.val);
            if(cur.right!=null)
            {
                stack.offerLast(cur.right);
            }
            if(cur.left!=null)
            {
                stack.offerLast(cur.left);
            }
        }
    }
}
