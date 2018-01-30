package Google.Tree.leetcode_366_find_leaves_of_binary_tree;

import Google.Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

//Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

//we use bfs to find the depth of the cur node, the leaf node will be depth 0,
// if it is leafnode ,we know the depth of this node will be 0, then leadnode's parents' node will be depth 1,
//therefore according to this algorithm, we can add the node into the List<>, the depth of the node will be index of the this node in list.
//list<index> : index is the depth of the node.

public class Solution {
    public List<List<Integer>> findleaves(TreeNode root)
    {
        return null;

    }
    private int height(TreeNode root, List<List<Integer>> result)
    {
        if(root==null)
        {
            return -1;
        }
        int left_child_height = height(root.left,result);
        int right_child_height = height(root.right,result);
        int max_height = Math.max(left_child_height,right_child_height)+1;
        if(result.size()<max_height+1)
        {
            result.add(new LinkedList<>());
        }
        result.get(max_height).add(root.val);
        return max_height;
    }
}
