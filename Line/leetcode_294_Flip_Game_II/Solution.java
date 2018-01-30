package Google.Line.leetcode_294_Flip_Game_II;


//You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
//Write a function to determine if the starting player can guarantee a win.
//For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".


//还没有做出来
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        System.out.println(sol.canWin("++++"));
    }
    public boolean canWin(String s) {
        if(s==null || s.length()<2)
        {
            return false;
        }
        return helper(s,0,0);
    }

    private boolean helper(String s, int start, int flip)
    {
        if(start>s.length()-2)
        {
            if(flip==0)
            {
                return false;
            }
            return !(flip%2==0);
        }
        boolean result = false;
        int i = start;
        for(;i<=s.length()-2;i++)
        {
            if(s.substring(i,i+2).equals("++"))
            {
                String temp = s.substring(0,i)+"--"+s.substring(i+2,s.length());
                result = helper(temp,i+2,flip+1) || result;
            }
        }
        if(i==start)
        {
            if(flip==0)
            {
                return false;
            }
            return flip%2!=0;
        }
        return result;

    }
}
