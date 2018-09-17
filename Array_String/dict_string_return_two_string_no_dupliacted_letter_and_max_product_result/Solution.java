package Google.Line.dict_string_return_two_string_no_dupliacted_letter_and_max_product_result;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    String[] dict;
    public int Q2_1(String[] dict)
    {
        //Q2.1: 一个字典有给一系列strings，要求两个string，是的它们没有共同字符，并且长度乘积最大
        //assumption: all letters in the word is from 'a-z' in ASCII, and sorted in the length
        //sort order：descending

        //dijistra algorithm
        Set<object> set = new HashSet<>();
        PriorityQueue<object> pq = new PriorityQueue<>((a,b)->(b.val-a.val));
        //max heap

        //initial state:
        //pq: (dict[i],dict[j])

        //expansion rule:
        //dict[i+1],dict[j] or dict[i],dict[j+1]

        //termination rule:
        //1. the priority queue is empty
        //2. we get a result
        object a = new object(0,1);
        pq.offer(a);
        set.add(a);
        while(!pq.isEmpty())
        {
            object element = pq.poll();
            if(dict[element.i].length()<dict[element.j].length()? find_common_element(dict[element.i],dict[element.j]):find_common_element(dict[element.j],dict[element.i]))
            {
                return element.val;
            }
            else{
                object new_element_1 = new object(element.i+1,element.j);

                if(!set.contains(new_element_1)&&!set.contains(new object(element.j,element.i+1)))
                {
                    pq.offer(new_element_1);
                    set.add(new_element_1);
                }
                object new_element_2 = new object(element.i,element.j+1);
                if(!set.contains(new_element_2)&&!set.contains(new object(element.j+1,element.i)))
                {
                    pq.offer(new_element_2);
                    set.add(new_element_2);
                }

            }
        }
        return 0;
    }

    private class object{
        int i;
        int j;
        int val = 0;
        public object(int i, int j){
            this.i = i;
            this.i = j;
            this.val = dict[i].length()*dict[j].length();
        }
    }

    private boolean find_common_element(String a, String b)
    {
        //a.length is less or equal than b.length
        HashSet<Character> set = new HashSet<>();
        for(int i =0;i<a.length();i++)
        {
            set.add(a.charAt(i));
        }
        for(int i = 0;i<b.length();i++)
        {
            if(set.contains(b.charAt(i)))
            {
                return false;
            };
        }
        return true;
    }
}
