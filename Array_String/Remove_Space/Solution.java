package Google.Array_String.Remove_Space;

public class Solution {
    public static void main (String[] args) {
        Solution sol = new Solution();
        String input = "   awdwa fawf faw    a   b";
        System.out.println(sol.removeSpace(input));
    }
    public String removeSpace (String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 0;
        int cur = 0;
        while (cur < input.length()) {
           if (slow != 0) {
               array[slow++] = ' ';
           }
           while(cur < input.length() && array[cur] != ' ')
           {
               array[slow++] = array[cur++];
           }
           while(cur < input.length() && array[cur] == ' ')
           {
               cur++;
           }
        }
        String result = new String(array);
        return result.substring(0, slow);
    }
}

