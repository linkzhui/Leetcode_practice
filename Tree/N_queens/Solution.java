package Google.Tree.N_queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List> N_Queen(int n)
    {
        List<List> result = new ArrayList<>();
        if(n<0 || n == 0)
        {
            return result;
        }
        for(int i = 0;i<n;i++)
        {
            helper(new int[n],0,0,n,result);
        }

        return result;
    }

    private void helper(int[] path, int level, int index, int n, List<List> result)
    {
        //cur level we should add the previous coordinate into the path array
        path[level] = index;
        if(level == n-1)
        {
            result.add(new ArrayList<>(Arrays.asList(path)));
        }
        for(int i = 0;i<n;i++)
        {
            if(!meet(path, level+1,index,n))
            {
                helper(path,level+1,index,n,result);
            }
        }
    }

    private boolean meet(int[] path, int level, int index, int n)
    {
        for(int i = 0;i<level;i++)
        {
            if(path[i]==index || path[i] - index == i-level || path[i] - index == level - i)
            {
                return true;
            }
        }
        return false;
    }
}
