package Google.Line.remove_all_duplicated_empty_space;

public class Solution {
    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder("    ");
        Solution sol = new Solution();
        String s =sol.remove_duplicate_empty_space(sb);
        System.out.println(s);
    }
    public String remove_duplicate_empty_space(StringBuilder sb)
    {
        if(sb.length()==0||sb==null)
        {
            return null;
        }
        int slow = -1;
        boolean pre_space = false;
        for(int i = 0;i<sb.length();i++)
        {
            if(sb.charAt(i)!=' '||(sb.charAt(i)==' '&&!pre_space))
            {
                pre_space = sb.charAt(i)==' '? true:false;
                slow++;
                swap(sb,slow,i);
            }
        }
        return sb.substring(0,slow+1).toString();

    }

    public void swap(StringBuilder sb, int left, int right)
    {
        char temp = sb.charAt(left);
        sb.setCharAt(left, sb.charAt(right));
        sb.setCharAt(right,temp);
    }
}
