package Google.Line.leetcode_340_Longest_Substring_with_at_most_K_Distinct_Characters;

/**
 * Created by raymon on 7/12/17.
 */

//最多只能出现K个不同的元素
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] freq = new int[256];
        int num=0;
        int length=0;
        int start_index=0;
        for(int i =0;i<s.length();i++)
        {
            if(freq[s.charAt(i)]==0)
            {
                num++;
            }
            freq[s.charAt(i)]++;
            if(num>k)
            {
                do{
                    freq[s.charAt(start_index)]--;
                }while(freq[s.charAt(start_index++)]!=0);
                //删到有一个character的freq变为0为止，这里的start_index++就是换成下一个charater在start_index之后
                num--;
            }
            length=Math.max(length,i-start_index+1);
        }
        return length;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstringKDistinct("eceba",2));
    }
}
