package Google.Array_String.Array_number_comparsons;

import org.junit.Test;

import java.util.*;

public class Solution {
    //QUESTION: the least number of comparisons to find the largest and smallest number

    //Solution_1(not correct)
    //遍历两遍，第一遍找最小值，第二遍找最大值
    // comparision: O(2n)


    //solution_2(correct)
    //世界杯足球赛
    //          1 2 | 4 3 | 6 5 | 8 7
    //losers    1   | 3   | 5   | 7   (n/2)
    //winners   2   | 4   | 6   | 8   (n/2)

    //(1) n/2 comparision to get the losers and winners group
    //(2) n/2 comparision to find the least number
    //(3) n/2 comparision to find the largest number
    // total number of comparision is 1.5n

    @Test
    public void test(){
        int[] array = {1,2,3,4,5,6,7};
        System.out.println("hello world");
    }
    int[] find_least_largest_number(int[] array)
    {

        if(array == null || array.length == 0)
        {
            return null;
        }
        int[] losers = new int[array.length/2+array.length%2];
        int[] winners = new int[array.length/2+array.length%2];
        int slow = 0;
        int fast = 1;
        while(fast<array.length)
        {
            if(array[slow]<array[fast])
            {
                losers[slow] = array[slow];
                winners[slow] = array[fast];
            }
            else
            {
                winners[slow] = array[slow];
                losers[slow] = array[fast];
            }
            slow+=2;
            fast+=2;
        }
        if(array.length%2!=0)
        {
            winners[slow] = array[slow];
            losers[slow] = array[slow];
        }

        int least = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        for(int i = 0;i<losers.length;i++)
        {
            if(least>losers[i])
            {
                least=losers[i];
            }
            if(largest<winners[i])
            {
                largest = winners[i];
            }
        }

        int[] result = {largest,largest};
        return result;
    }



    //QUESTION: how to use the least number of comparison to find the largest and second largest number?
    // 1    2   |   4   3   |   6   5   |   8   7
    //  2(1)    |   4(3)    |   6(5)    |   8(7)
    //          4(3,2)      |       8(7,6)
    //                      8(7,6,4)                用了n comparison 找到最大值，然后找扣号里的第二大的值，用了logn comparision
    int[] largest_second_largest(int[] array)
    {
        if(array == null || array.length == 0)
        {
            return null;
        }
        Deque<integer> queue = new ArrayDeque<>();
        int slow = 0;
        int fast = 1;
        while(fast<array.length)
        {
            if(array[slow]<array[fast])
            {
                integer a = new integer(array[fast]);
                a.small.add(array[slow]);
                queue.offerLast(a);
            }
            else{
                integer a = new integer(array[slow]);
                a.small.add(array[fast]);
                queue.offerLast(a);
            }
            slow+=2;
            fast+=2;
        }
        if(array.length%2!=0)
        {
            integer a = new integer(array[slow]);
            queue.add(a);
        }

        while(queue.size()!=1)
        {
            int size = queue.size();
            integer first;
            integer second;
            for(int i = 0; i<size;i+=2)
            {
                first = queue.pollFirst();
                second = queue.pollFirst();
                if(first.cur>second.cur)
                {
                    first.small.add(second.cur);
                    queue.offerLast(first);
                }
                else{
                    second.small.add(first.cur);
                    queue.offerLast(second);
                }
            }
        }
        integer temp = queue.pollFirst();
        int second_larget  = Integer.MIN_VALUE;
        int largest = temp.cur;
        for(Iterator<Integer> it = temp.small.iterator();it.hasNext();)
        {
            Integer value = it.next();
            second_larget = value>second_larget? value:second_larget;
        }
        int[] result = {largest,second_larget};
        return result;
    }

    class integer{
        int cur;
        List<Integer> small = new LinkedList();
        public integer(int cur){
            this.cur = cur;
        }
    }
}
