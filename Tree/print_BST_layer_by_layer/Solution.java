package Google.Tree.print_BST_layer_by_layer;

import Google.Tree.leetcode_93_Restore_IP_Addresses.stack_solution;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public void print_BST(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i =0;i<size;i++)
            {
                TreeNode node = queue.poll();
                System.out.print(node.val+" ");
                if(node.left!=null)
                {
                    queue.offer(node.left);
                }
                if(node.right!=null)
                {
                    queue.offer(node.right);
                }

            }
            System.out.println();
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}