package Google.Tree.all_permutation_of_blocks;


//Question: Given a integer n, print all possible if blocks for it.
//if n = 2
//example:
//if{
// }
//if{
//}


//if{
//  if{
//  }
// }

import java.util.LinkedList;

import java.util.List;

public class Solution {

    public static void main(String[] args)
    {
        Solution sol = new Solution();
        sol.permutation_blocks(3);
    }
    void permutation_blocks(int n)
    {
        if(n<=0)
        {
            return;
        }
        List<List<Character>> result = new LinkedList<>();
        valid_permutation(n,0,0,new LinkedList<Character>(),result);
        print(result);

    }

    private void valid_permutation(int n, int left, int right, List<Character> path, List<List<Character>> result)
    {
        if(left==right && left == n)
        {
            result.add(new LinkedList<>(path));
            return;
        }

        if(left<n)
        {
            path.add('(');
            valid_permutation(n,left+1,right,path, result);
            path.remove(path.size()-1);
        }

        if(right<left)
        {
            path.add(')');
            valid_permutation(n,left, right+1, path, result);
            path.remove(path.size()-1);
        }

    }

    void print(List<List<Character>> result)
    {
        char space = ' ';
        for(List<Character> child:result)
        {
            int index = 0;
            for(Character element:child)
            {
                if(element == '(')
                {
                    for(int i = 0;i<index;i++)
                    {
                        System.out.print(space);
                    }
                    System.out.println("if{");
                    index+=3;
                }
                else{
                    index-=3;
                    for(int i = 0;i<index;i++)
                    {
                        System.out.print(space);
                    }
                    System.out.println("}");
                }
            }
            System.out.println();
        }
    }
}
