package Google.Tree.leetcode_93_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by raymon on 6/25/17.
 */
public class stack_solution {
    public static void main(String[] args)
    {
        List<String> result = new LinkedList<>();
        result = restoreIpAddresses("25525511135");
        for(int i = 0;i<result.size();i++)
        {
            System.out.println(result.get(i));
        }
    }
    public static List<String> restoreIpAddresses(String s){
        List<String> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(new TreeNode(4,12,-1,0,""));
        String[] array = new String[5];
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            //op at node
            array[node._height] = node._cur;
            if(node._height==4)
            {
                StringBuilder sb = new StringBuilder();
                String prefix = "";
                for(int i = 1;i<5;i++)
                {
                    sb.append(prefix+array[i]);
                    prefix = ".";
                }
                result.add(sb.toString());
            }

            //push the children
            int startchild = node._end+1;
            int minchild = node._min-1;
            int maxchild = node._max-3;
            for(int endchild = startchild; endchild<startchild+3;endchild++)
            {
                int remainlength = s.length()-endchild-1;
                if(remainlength<=maxchild&&remainlength>=minchild
                        &&Integer.valueOf(s.substring(startchild,endchild+1))<256
                        &&(startchild==endchild||s.charAt(startchild)!='0'))
                {
                    stack.push(new TreeNode(minchild,maxchild,endchild,node._height+1,s.substring(startchild,endchild+1)));
                }
            }
        }
        return result;
    }

    public static class TreeNode{
        int _min;
        int _max;
        String _cur;
        int _end;
        int _height;
        TreeNode(int min, int max, int end, int height, String cur)
        {
            _min = min;
            _max = max;
            _end = end;
            _height = height;
            _cur = cur;
        }

    }
}
