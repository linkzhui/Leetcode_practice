package Google.Line.Common_elements;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public void q1(int[] array1, int[] array2)
    {
        //Question1.1: Find common elements in two arrays
        //Assumptions:
        //1. is array sorted or unsorted
        //2. if it is sorted, it is ascending or descending
        //3. what is the data type
        //4. what is the size of this array


        // 1) sorted
            //Solution 1: if it is sorted,
            //在两个array设置一个start_index, 谁小移谁
            //time: O(n+m)

            //Solution 2: HashTable
            //time:O(n+m)
            //space: O(min(n.length,m.length))

            //Solution 3: Binary Search
            //走size小的array，然后对size2的array做binary search
            //time: O(nlogm)

        // 2) unsorted
            //Solution1: sort first
            //solution2: HashTable


    }

    public void q2(int[] array1, int[] array2, int[] array3)
    {
        //find common element in three sorted array
        //prefer O(1) space

        //用谁小移动谁的办法
        //time complexity: O(n+m+z)  -> 3 arrays' length
        //space complexity: O(1)
    }

    public boolean q3(Integer[][] array)
    {
        //find common element in k sorted array
        //for k problem
        //general solution:
        //1: iterative
        //2: binary reduction
        //3: k-way(priority queue)-> not recommended in this question

        //time complexity: O(nk)


        //iterative way
        if(array==null)
        {
            return false;
        }

        List<Integer> a = Arrays.asList(array[0]);

        for(int i = 1;i<array.length;i++)
        {
            List<Integer> b = new LinkedList<>();
            int a1_start = 0;
            int a2_start = 0;

            while(a1_start<a.size() && a2_start<array[0].length)
            {
                if(a.indexOf(a1_start)==array[i][a2_start])
                {
                    b.add(a.indexOf(a1_start));
                    a1_start++;
                    a2_start++;
                }
                else if(a.indexOf(a1_start)<array[i][a2_start])
                {
                    a1_start++;
                }
                else{
                    a2_start++;
                }

            }
            a=new LinkedList<>(b);
        }

        return a.size()==0;

    }


}
