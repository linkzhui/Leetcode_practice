package Google.Tree.leetcode_545_boundary_of_binary_tree;

import Google.Tree.TreeNode;

import java.util.*;

//Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.
//
//        Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.
//
//        The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
//
//        The right-most node is also defined by the same way with left and right exchanged.
//
//        Example 1
//        Input:
//        1
//        \
//        2
//        / \
//        3   4
//
//        Ouput:
//        [1, 3, 4, 2]
//
//        Explanation:
//        The root doesn't have left subtree, so the root itself is left boundary.
//        The leaves are node 3 and 4.
//        The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
//        So order them in anti-clockwise without duplicates and we have [1,3,4,2].
//        Example 2
//        Input:
//        ____1_____
//        /          \
//        2            3
//        / \          /
//        4   5        6
//        / \      / \
//        7   8    9  10
//
//        Ouput:
//        [1,2,4,7,8,9,10,6,3]
//
//        Explanation:
//        The left boundary are node 1,2,4. (4 is the left-most node according to definition)
//        The leaves are node 4,7,8,9,10.
//        The right boundary are node 1,3,6,10. (10 is the right-most node).
//        So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].


//这道题目的难点在于判断一个节点是在left boundary还是right boundary 还是 一个普通的节点
//为了将叶节点加入List中，首先想到要用 DFS 算法。但如果仅仅使用DFS算法，那么 left boundary 和 right boundary 上的节点就无法加入到List中了。
// 因此，需要设计两个包装函数GetLeftPath 和 GetRightPath,在这两个函数中，通过判断选择递归地使用本身函数或者调用DFS算法函数。
// GetLeftPath函数默认传入的节点为 Left boundary 上的节点，并对该节点的 left 节点继续调用GetLeftPath函数，
// 然后对该节点的右节点调用DFS算法函数。GetRightPath道理相同。
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode temp = root;
        temp.left = null;
        temp.right = new TreeNode(2);
        temp = temp.right;
        temp.left = new TreeNode(3);
        temp.right = new TreeNode(4);
        temp.left.left =null;
        temp.left.right = null;
        temp.right.left = null;
        temp.right.right = null;
        System.out.println(Arrays.toString(sol.boundaryOfBinaryTree(root).toArray()));
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root==null)
        {
            return result;
        }
        result.add(root.val);
        if(root.left!= null)
        {
            GetLeftPath(root.left,result);
        }
        if(root.right!= null)
        {
            GetRightPath(root.right,result);
        }
        return result;
    }

    private void GetRightPath(TreeNode root, List<Integer> list) {

        if(root.left != null) {
            if (root.right != null) {
                //root.right == null && root.left!=null
                DFS(root.left, list);
                GetRightPath(root.right, list);
            } else {
                //root.right != null && root.left!=null
                GetRightPath(root.left, list);
            }
        }
        else if (root.right!=null){
            GetRightPath(root.right, list);
        }
        list.add(root.val);

    }
    private void GetLeftPath(TreeNode root, List<Integer> list)
    {
        list.add(root.val);
        if(root.left!=null)
        {
            GetLeftPath(root.left,list);
            if(root.right !=null)
            {
                DFS(root.right,list);
            }
        }
        else if(root.right!=null){
            GetLeftPath(root.right,list);
        }
    }

    private void DFS (TreeNode root, List<Integer> list)
    {
        if(root.left==null && root.right == null)
        {
            list.add(root.val);
        }
        else
        {
            if(root.left!=null)
            {
                DFS(root.left,list);
            }
            if(root.right!=null){
                DFS(root.right,list);
            }
        }
    }

}
