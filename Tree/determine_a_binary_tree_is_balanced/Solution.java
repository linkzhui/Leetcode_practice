package Google.Tree.determine_a_binary_tree_is_balanced;

//solution 2 provide a beeter solution
//use return -1 to instead of return the false

public class Solution {

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        TreeNode cur = root;
        cur.left = null;
        cur.right = new TreeNode(2);
        cur = cur.right;
        cur.left = null;
        cur.right = new TreeNode(3);
        Solution sol = new Solution();
        System.out.println(sol.isBalanced(root));

    }
    public boolean isBalanced(TreeNode root)
    {
        if(root == null)
        {
            return true;
        }
        return helper(root,0).is_balanced;

    }

    private Solution_set helper(TreeNode root, int height)
    {
        if(root==null)
        {
            Solution_set result = new Solution_set(height,true);
            return result;
        }
        Solution_set leftchild = helper(root.left,height+1);
        Solution_set rightchild = helper(root.right,height+1);
        if(leftchild.is_balanced==false&&rightchild.is_balanced==false)
        {
            return new Solution_set(height,false);
        }
        else if(Math.abs(leftchild.height-rightchild.height)>1)
        {
            return new Solution_set(height,false);
        }
        else
        {
            return new Solution_set(Math.max(leftchild.height,rightchild.height),true);
        }

    }
}

class Soltion_2{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        TreeNode cur = root;
        cur.left = null;
        cur.right = new TreeNode(2);
        cur = cur.right;
        cur.left = null;
        cur.right = new TreeNode(3);
        Solution sol = new Solution();
        System.out.println(sol.isBalanced(root));
    }
    public boolean isBalanced(TreeNode root)
    {
        if(root == null)
        {
            return true;
        }
        return helper(root,0)!=-1;

    }

    private int helper(TreeNode root, int height)
    {
        if(root==null)
        {
            return height;
        }
        int leftchild = helper(root.left,height+1);
        int rightchild = helper(root.right,height+1);
        if(leftchild==-1||rightchild==-1)
        {
            return -1;
        }
        else if(Math.abs(leftchild-rightchild)>1)
        {
            return -1;
        }
        else
        {
            return Math.max(leftchild,rightchild)+1;
        }

    }
}
class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode (int value)
    {
        this.value = value;
    }
}

class Solution_set{
    int height;
    boolean is_balanced;
    Solution_set(int height, boolean is_balanced)
    {
        this.height = height;
        this.is_balanced = is_balanced;
    }
}