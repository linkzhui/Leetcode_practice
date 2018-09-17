package Google.Line.leetcode_151_reverser_words_in_a_string;

/**
 * Created by raymon on 6/22/17.
 */

//像这种reverse的，要走到-1的位置，如果是正着走的话，要走要s.length的位置
public class leetcode_151_reverser_words_in_a_string {
    public static void main(String[] argv){
        System.out.println(reverseWords("the sky is blue"));
    }
    private static String reverseWords(String s){
        StringBuilder sb = new StringBuilder();
        int end = s.length();
        String prefix = "";
        for(int i=s.length()-1;i>=-1;i--)
        {
            if(i==-1||s.charAt(i)==' ')
            {
                if(i+1!=end)
                {
                    sb.append(prefix+s.substring(i+1,end));
                    prefix = " ";
                }
                end = i;
            }


        }

        return sb.toString();
    }
}
