package Google.Array_String.Leetcode_844_Backspace_String_Compare;

public class Solution {
    //two pointers, one pointers for each string, and we iterate the string from end of the string first
    //we need to count to record how many undeleted characters，
    //case 1: undeleted characters != 0
                //1.1 current character
    public boolean backspaceCompare(String S, String T) {
        int index_s = S.length()-1;
        int index_t = T.length()-1;
        int count_s = 0; //how many undeleted characters in S
        int count_t = 0; //how many undeleted characters in T
        while (index_s >= 0 || index_t >= 0){
            //这里为什么是||是因为，有可能有一条string越界了，但是另外一条string还没有走到头，需要把另外一条string也要走到头才能判断是不是相同 (有可能另外一条string最后会被删除为剩0个unpaired character)
            while (index_s>=0) {
                if (S.charAt(index_s) == '#') {
                    count_s++;
                    --index_s;
                } else if (count_s>0) {
                    count_s--;
                    --index_s;
                } else {
                    break;
                }
            }
            while (index_t>=0) {
                if (T.charAt(index_t) == '#') {
                    count_t++;
                    --index_t;
                } else if (count_t>0) {
                    count_t--;
                    --index_t;
                } else {
                    break;
                }
            }
            //如果一条越界，一条没有越界，说明没有越界的那条string还有unpaired character，就返回false
            if (index_t >= 0 != index_s >= 0) {
                return false;
            }
            //如果两条string都没有越界，同时两个character不相等，return false
            if (index_t >= 0 && index_s >= 0 && T.charAt(index_t) != S.charAt(index_s)) {
                return false;
            }
            index_t--;
            index_s--;
        }
        return true;
    }
}
