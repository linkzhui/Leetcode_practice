package Google.Tree.leetcode_22_generate_parentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by raymon on 6/23/17.
 */
public class Stack_solution {
    public static void main(String[] argv){
        List<String> result = generateParenthesis(4);
        for(int i  = 0;i<result.size();i++)
        {
            System.out.println(result.get(i));
        }
    }
    public static List<String> generateParenthesis(int n) {
        char[] array = new char[2*n];
        List<String> result  = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(new TreeNode(1,0,0,'('));
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            //op at node
            array[node._height] = node._c;
            //base case
            if(node._left==n&&node._right==n)
            {
                result.add(new String(array));
            }
            //push the children
            if(node._left<n)
            {
                stack.push(new TreeNode(node._left+1,node._right,node._height+1,'('));
            }
            if(node._right<node._left)
            {
                stack.push(new TreeNode(node._left,node._right+1,node._height+1,')'));
            }

        }
        return result;


    }

    static class TreeNode {
        int _left;
        int _right;
        int _height;
        char _c;

        public TreeNode(int left, int right, int height, char c) {
            _left = left;
            _right = right;
            _height = height;
            _c = c;
        }
    }

}


