package Google.Array_String.leetcode_247_Strobogrammatic_Number_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//通过recursion的方式来枚举所有的可能性
//corner case， 0不能作为数字的开头
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0','0');
        map.put('1','1');
        map.put('8','8');
        map.put('6','9');
        map.put('9','6');
        List<String> result = new ArrayList<>();
        helper(n, 0, map,new StringBuilder(), result);
        return result;
    }

    private void helper (int n, int i, HashMap<Character, Character> map, StringBuilder sb, List<String> result) {
        if (n/2 == i) {
            String first_part = sb.toString();
            String reverse = reverse(sb, map);
            if (n % 2 == 1) {
                result.add(first_part + 1 + reverse);
                result.add(first_part + 8 + reverse);
                result.add(first_part + 0 + reverse);
            } else {
                result.add(first_part + reverse);
            }
            return;
        }
        for (Map.Entry<Character, Character> entry : map.entrySet()) {
            Character key = entry.getKey();
            //0 不能作为数字的开头
            if (key == '0' && i==0) {
                continue;
            }
            helper(n, i+1, map, sb.append(key), result);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    private String reverse(StringBuilder sb, HashMap<Character, Character> map)
    {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < sb.length(); i++) {
            result.insert(0, map.get(sb.charAt(i)));
        }
        return result.toString();
    }
}
