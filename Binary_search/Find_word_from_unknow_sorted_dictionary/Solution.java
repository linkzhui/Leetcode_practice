package Google.Binary_search.Find_word_from_unknow_sorted_dictionary;


//Given a sorted dictionary with unknown size, how to determine whether a word is in this dictionary or not

//思路：
//
//step 1: try 2^0, 2^1, 2^2 ...... 2^n
//step 2: until we find that either a[index] > target (in this case, target must be on my lefthand if exist) or a [index] == null ()
// 每次把upper boundary的size乘2，来找target word
public class Solution {
}
