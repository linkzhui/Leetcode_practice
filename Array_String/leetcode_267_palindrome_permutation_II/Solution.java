package Google.Line.leetcode_267_palindrome_permutation_II;


import java.util.*;


//if we find all the permutation set for the first half of the string, then we can reverse the firs half of string to get the second half
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        List<String> result = sol.generatePalindromes("aabb");
        for(String element:result)
        {
            System.out.println(element);
        }
    }
    public List<String> generatePalindromes(String s){
        int[] map = new int[256];
        List<String> result =  new ArrayList<>();
        if(!canPermutePalindrome(s,map))
        {
            return result;
        }

        char mid_char = 0;
        char[] st = new char[s.length()/2];    //half length of the original string
        int k = 0;   //cur index of st
        for(int i = 0;i<map.length;i++)
        {
            if(map[i]%2==1)
            {
                mid_char = (char) i;
            }
            for(int j = 0;j<map[i]/2;j++)
            {
                st[k++] = (char) i;
            }
        }
        Set<String> set = new HashSet<>();
        permutation(st,0,mid_char,set);
        return new ArrayList<>(set);

    }
    private void permutation(char[] st, int cur_index, Character mid_char, Set<String> set)
    {
        //base case
        if(cur_index==st.length)
        {
            set.add(new String(st)+(mid_char==0? "":mid_char)+new StringBuffer(new String(st)).reverse().toString());

        }
        for(int i = cur_index;i<st.length;i++) {
            if (st[i] != st[cur_index] || i == cur_index)  //avoid the duplicate result
            {
                swap(st,cur_index,i);
                permutation(st,cur_index+1,mid_char, set);
                swap(st,cur_index,i);
            }
        }
    }

    private void swap(char[] nums, int left, int right)
    {
        char temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private boolean canPermutePalindrome(String s, int[] map) {
        if(s==null || s.length()==0)
        {
            return false;
        }

        int count = 0;//用count来记录number of unpair element
        for(Character element:s.toCharArray())
        {
            if(++map[element]%2==1)
            {
                count++;
            }
            else{
                count--;
            }
        }
        return (count <= 1);
    }
}
