package Google.Tree.leetcode_93_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by raymon on 6/25/17.
 */
public class queue_solution {
    public static void main(String[] args)
    {
        List<String> result = restoreIpAddresses("25525511135");
        for(int i =0;i<result.size();i++)
        {
            System.out.println(result.get(i));
        }
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(new TreeNode(4,12,-1,""));
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i =0;i<size;i++)
            {
                TreeNode node = queue.remove();
                //op at node
                if(node._min == 0)
                {
                    result.add(node._path);
                }
                int startchild = node._end+1;
                int max = node._max-3;
                int min = node._min-1;
                for(int endchild  = startchild;endchild<startchild+3;endchild++)
                {
                    int remainlength=s.length()-endchild-1;
                    if(remainlength<=max&&remainlength>=min&&Integer.valueOf(s.substring(startchild,endchild+1))<256&& (startchild == endchild || s.charAt(startchild)!='0'))
                    {
                        String resultpath = min==3? "":node._path+".";
                        queue.add(new TreeNode(min,max,endchild,resultpath+s.substring(startchild,endchild+1)));
                    }
                }
            }
        }
        return result;
    }
    private static class TreeNode{
        int _min;
        int _max;
        String _path;
        int _end;
        TreeNode(int min, int max, int end, String path)
        {
            _min = min;
            _max = max;
            _end = end;
            _path = path;
        }

    }
}
