package Google.DP.Jump_game;
//Given an a array of non-negative integers, you are initially positioned at the first index of the array.
// Each element in the array represents your maximum jump length at the position
//int[] = {2,3,1,1,4}
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] array = {2,0,0,1,1,4};
        System.out.println(sol.jump_game(array));
    }
    boolean jump_game(int[] array)
    {
        boolean[] game = new boolean[array.length];
        game[array.length-1] = true;
        for(int i = array.length-2;i>=0;i--)
        {
            for(int j = 1;j<=array[i];j++)
            {
                if(i+j>=array.length-1||game[i+j]==true)
                {
                    game[i] = true;
                    break;
                }
            }
        }
        return (game[0]==true? true:false);
    }
}
