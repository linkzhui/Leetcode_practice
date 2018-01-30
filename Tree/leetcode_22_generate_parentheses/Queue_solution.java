package Google.Tree.leetcode_22_generate_parentheses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by raymon on 6/25/17.
 */
public class Queue_solution {
    public static void main(String[] argv){
        List<String> result = new ArrayList<>();
        result = solution(3);
        for(int i =0;i<result.size();i++)
        {
            System.out.println(result.get(i));
        }
    }
    private static List<String> solution (int n){
        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(new TreeNode(1,0,"("));
        while(!queue.isEmpty())
        {
            //op at node
            TreeNode node = queue.remove();
            //base case
            if(node._left==node._right&&node._left==n)
            {
                result.add(node._path);
            }
            //push the children to the queue
            if(node._left<n)
            {
                queue.add(new TreeNode(node._left+1,node._right,node._path+"("));
            }
            if(node._right<node._left)
            {
                queue.add(new TreeNode(node._left,node._right+1,node._path+")"));
            }
        }
        return result;
    }
    static class TreeNode{
        int _left;
        int _right;
        String _path;
        public TreeNode(int left,int right, String path){
            _left = left;
            _right = right;
            _path = path;
        }
    }

}
