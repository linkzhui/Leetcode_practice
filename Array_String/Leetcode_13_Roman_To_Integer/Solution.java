package Google.Array_String.Leetcode_13_Roman_To_Integer;

import java.util.HashMap;

public class Solution {
    //比较S.get(i)和S.get(i+1)
    //if(S.get(i) >= S.get(i+1) -> result+=S.get(i); i++;
    //else result = result - S.get(i) + S.get(i+1); i+=2;
    public int romanToInt(String s) {
        char[] array = s.toCharArray();
        int index = 0;
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        initRomanInt(map);
        while(index < s.length()) {
            int first = map.get(array[index]);
            if(index == s.length() - 1) {
                result += first;
                break;
            }
            int second = map.get(array[index+1]);
            if( first < second) {
                result = result - first + second;
                index+=2;
            }else{
                result += first;
                index++;
            }
        }
        return result;
    }

    private void initRomanInt(HashMap map){
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
}
