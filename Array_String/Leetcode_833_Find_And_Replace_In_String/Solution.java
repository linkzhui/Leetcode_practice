package Google.Array_String.Leetcode_833_Find_And_Replace_In_String;

public class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0 ; i < S.length();) {
            if(i == indexes[index]) {
                if (valid(S, i, sources[index])) {
                    sb.append(sources[index]);
                    i += sources[index].length();
                }
                if (index < indexes.length)
                    index++;
            } else {
                sb.append(S.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }

    private boolean valid(String S, int index, String source) {
        for (int i = 0; i < source.length(); i++) {
            if(index + i >= S.length() || S.charAt(index+i)!=source.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
