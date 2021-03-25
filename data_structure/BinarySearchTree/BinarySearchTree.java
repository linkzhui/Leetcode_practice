package Google.data_structure.BinarySearchTree;

public class BinarySearchTree {
    TreeNode root;
    public BinarySearchTree(){

    }

    boolean delete(TreeNode node, int val) {
        //case 1: this node only have one child
        //case 2: this node have two children
        //case 3: this node have no children
        TreeNode cur = find (node, val);
        if (cur == null) {
            return false;
        }
        if (cur.left == null && cur.right == null) {
            cur = null;
        } else if(cur.left == null || cur.right == null) {
            cur = cur.left == null? cur.right:cur.left;
        } else {
            int leftBiggest = findRightBiggest(cur);
            cur.val = leftBiggest;
            delete(cur.left, leftBiggest);
        }
        return true;

    }

    TreeNode find (TreeNode node, int val) {
        while (node != null) {
            if (node.val == val) {
                return node;
            } else if (node.val < val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }

    private int findRightBiggest (TreeNode node) {
        while(node.right != null) {
            node = node.right;
        }
        return node.val;
    }

    void insert (int val) {
        if (root == null) {
            root = new TreeNode(val);
        }
        TreeNode cur = root;
        boolean finish = false;
        while (!finish) {
            if (val > cur.val) {
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    finish = true;
                } else {
                    cur = cur.right;
                }
            } else if (val < cur.val){
                cur = cur.left;
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    finish = true;
                } else {
                    cur = cur.left;
                }
            } else {
                finish = true;
            }
        }
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
