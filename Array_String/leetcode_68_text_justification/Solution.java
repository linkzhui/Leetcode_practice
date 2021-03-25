package Google.Array_String.leetcode_68_text_justification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raymon on 6/26/17.
 */
public class Solution {
    public static void main(String[] args) {
        String[] str = {"What","must","be","acknowledgment","shall","be"};
        Solution sol = new Solution();
        List<String> result = sol.fullJustify(str, 16);
        System.out.println(result.size());
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0 || maxWidth <= 0) {
            return result;
        }
        String[] spaces = new String[maxWidth+1];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i<= maxWidth; i++) {
            sb.append(" ");
            spaces[i] = sb.toString();
        }
        helper (words, maxWidth, 0, result,spaces);
        return result;
    }
    private void helper(String[] words, int maxWidth, int start, List<String> result, String[] spaces){
        if (start == words.length) {
            return;
        }
        int length = 0;
        int word_length = 0;
        int i = start;
        for (; i < words.length && length < maxWidth; i++) {
            if (i == start) {
                length += words[i].length();
                word_length+=words[i].length();
            } else if (length + words[i].length() + 1 <= maxWidth) {
                length += words[i].length() + 1;
                word_length+=words[i].length();
            } else {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(words[start]);
        if (i == start + 1) {
            sb.append(spaces[maxWidth - word_length]);
        } else {
            int spaces_count = i - start - 1;
            if (i == words.length) {
                for (int j = 0; j < spaces_count; j++) {
                    sb.append(spaces[1]);
                    sb.append(words[j+start+1]);
                }
                sb.append(spaces[maxWidth-length]);
            } else {
                int spaces_length = maxWidth - word_length;
                int space = spaces_length / spaces_count;
                for (int j = 0; j < spaces_count; j++) {
                    if (j == 0) {
                        sb.append(spaces[space + spaces_length%spaces_count]);
                    } else {
                        sb.append(spaces[space]);
                    }
                    sb.append(words[j+start+1]);
                }
            }
        }
        result.add(sb.toString());
        helper (words, maxWidth, i, result, spaces);
    }
}
