package Google.Array_String.leetcode_271_Encode_and_Decode_Strings;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        //pattern string_length + '/' + string
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append('/');
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int begin = 0;
        while (begin < s.length()) {
            int slash = s.indexOf('/', begin);
            int size = Integer.parseInt(s.substring(begin, slash));
            result.add(s.substring(slash+1, slash+size+1));
            begin = slash + size + 1;
        }
        return result;
    }
}
