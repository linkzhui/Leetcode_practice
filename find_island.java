package Google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class find_island {
    public static void main(String[] args)
    {
        int[][] array = new int[][]{{1,0,1,0},{1,0,0,1},{0,1,1,0},{1,0,0,1},{0,1,1,0}};
        int[] total_num = new int[1];
        find_island sol = new find_island();
        sol.find(array,new LinkedList<>(),0,total_num);
        System.out.println(total_num[0]);

    }
    void find(int[][] array, List<index_intervel> list, int level,int[] total_num)
    {
        List<index_intervel> cur_level = new ArrayList<>();
        int start_index=0;
        int count = 0;
        if(level == array.length)
        {
            total_num[0]+=list.size();
            return;

        }
        for(int i = 0;i<array[level].length;i++)
        {

           if(array[level][i]==0) {
               if (count == 0) {
                   start_index = i;
               }
               count++;
               if (i == array[level].length - 1)
               {
                   cur_level.add(new index_intervel(start_index,start_index+count-1));
               }
            }
            else if(array[level][i]==1)
           {
               if(count!=0)
               {
                   cur_level.add(new index_intervel(start_index,start_index+count-1));
                   count=0;
               }

           }
        }
        int i = 0;
        for(index_intervel index:list)
        {
            if(index.end<cur_level.get(i).start)
            {
                total_num[0]+=1;
            }
            else if(index.start<cur_level.get(i).end && index.end>cur_level.get(i).end && i!=cur_level.size()-1)
            {
                i++;
            }

            else if(index.start>cur_level.get(i).end)
            {
                if(i==cur_level.size()-1)
                {
                    total_num[0]+=1;
                }
                else{
                    i++;
                    total_num[0]+=1;
                }
            }

        }
        find(array,cur_level,level+1,total_num);
    }
}

class index_intervel{
    int start;
    int end;
    public index_intervel(int start,int end)
    {
        this.start = start;
        this.end = end;
    }
}

