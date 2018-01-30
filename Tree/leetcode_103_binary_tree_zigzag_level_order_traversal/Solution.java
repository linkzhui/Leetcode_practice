package Google.Tree.leetcode_103_binary_tree_zigzag_level_order_traversal;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root==null)
        {
            return result;
        }

        Deque<TreeNode> dequeue = new ArrayDeque<>();
        dequeue.offerLast(root);
        boolean odd = true;
        while(!dequeue.isEmpty())
        {
            int size = dequeue.size();
            List<Integer> part_result = new LinkedList<>();

            for(int i = 0;i<size;i++)
            {
                if(odd)
                {
                    TreeNode temp = dequeue.pollFirst();
                    part_result.add(temp.val);
                    if(temp.left!=null)
                    {
                        dequeue.offerLast(temp.left);
                    }
                    if(temp.right!=null)
                    {
                        dequeue.offerLast(temp.right);
                    }
                }
                else{
                    TreeNode temp = dequeue.pollLast();
                    part_result.add(temp.val);
                    if(temp.right!=null)
                    {
                        dequeue.offerFirst(temp.right);
                    }
                    if(temp.left!=null)
                    {
                        dequeue.offerFirst(temp.left);
                    }
                }
            }
            odd = !odd;
            result.add(part_result);
        }
        return result;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x)
    {
        val = x;
    }
}