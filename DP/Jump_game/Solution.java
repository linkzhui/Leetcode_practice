package Google.DP.Jump_game;
//Given an a array of non-negative integers, you are initially positioned at the first index of the array.
// Each element in the array represents your maximum jump length at the position
//int[] = {2,3,1,1,4}
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] array = {2,0,3,1,1,4};
        System.out.println(sol.jump_game_2(array));
    }



    //Greedy solution: time complexity: O(n)
    //                 space complexity: O(n)
    //bottom up greedy algorithm
    //Iterating right-to-left, for each position we check if there is a potential jump that reaches a GOOD index (currPosition + nums[currPosition] >= leftmostGoodIndex).
    boolean jump_game_2(int[] array) {
        if(array == null || array.length < 2) {
            return true;
        }
        int length = array.length;
        int leftMost = length - 1;
        for(int i = length - 2; i>=0; i--) {
            if(array[i]+i>=leftMost) {
                leftMost = i;
            }
        }
        return leftMost == 0;
    }




    //DP solution: time complexity: O(n^2)
    //             space complexity: O(n)
    boolean jump_game_1(int[] array)
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
        return game[0];
    }

}
