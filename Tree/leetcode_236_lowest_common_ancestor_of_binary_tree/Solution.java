package Google.Tree.leetcode_236_lowest_common_ancestor_of_binary_tree;


import java.util.ArrayDeque;
import java.util.Deque;

//Q1:Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree. (no child)
public class Solution {
    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q ==root )
        {
            return root;
        }

        TreeNode leftchild = lowestCommonAncestor_1(root.left,p,q);
        TreeNode rightchild = lowestCommonAncestor_1(root.right,p,q);

        if(leftchild!=null && rightchild!=null)
        {
            return root;
        }

        return leftchild == null? rightchild:leftchild;

    }

    //Q2: with parent node
    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode a, TreeNode b){
        if(root==null)
        {
            return root;
        }
        boolean find_a = false;
        boolean find_b = false;
        TreeNode node_a = null;
        TreeNode node_b = null;
        int height_a = 0;
        int height_b = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        int height = 0;
        while (!(find_a&&find_b)&&!queue.isEmpty())
        {
            ++height;
            int size = queue.size();
            for(int i = 0;i<size;i++) {
                TreeNode temp = queue.pollFirst();
                if (temp == a) {
                    height_a = height;
                    find_a = true;
                    node_a = temp;
                } else if (temp == b) {
                    height_b = height;
                    find_b = true;
                    node_b = temp;
                } else {
                    if (root.left != null) {
                        queue.offerLast(root.left);
                    }
                    if (root.right != null) {
                        queue.offerLast(root.right);
                    }
                }
            }
        }
        if(find_a && find_b)
        {

            int height_differencce = height_a>height_b? height_a-height_b:height_b-height_a;
            if(height_a>height_b)
            {
                for(int i = 0;i<height_differencce;i++)
                {
                    node_a = node_a.parent;
                }

            }
            else{
                for(int i = 0;i<height_differencce;i++)
                {
                    node_b = node_b.parent;
                }
            }
            if(node_a==node_b)
            {
                return height_a>height_b? node_a:node_b;
            }
            while(node_a.parent != node_b.parent && node_a.parent!=null)
            {
                node_a = node_a.parent;
                node_b = node_b.parent;
            }
            return node_a.parent;
        }
        else{
            return null;
        }

    }

    //Q3: lowest common ancestors of k nodes (no parents node)
    //public TreeNode lowestCommonAncestor_3()
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    TreeNode(int x) {
        val = x;
    }
}