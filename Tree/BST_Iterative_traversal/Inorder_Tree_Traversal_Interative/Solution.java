package Google.Tree.BST_Iterative_traversal.Inorder_Tree_Traversal_Interative;


//1) Create an empty stack S.
//2) Initialize current node as root
//3) Push the current node to S and set current = current->left until current is NULL
//4) If current is NULL and stack is not empty then
//    a) Pop the top item from stack.
//    b) Print the popped item, set current = popped_item->right
//    c) Go to step 3.
//5) If current is NULL and stack is empty then we are done.

import Google.Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> Inorder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;

        while ( cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offerLast(cur);
                cur = cur.left;
            }
            else{
                TreeNode temp = stack.pollLast();
                result.add(temp.val);
                cur = cur.right;
            }
        }
        return result;
    }
}
