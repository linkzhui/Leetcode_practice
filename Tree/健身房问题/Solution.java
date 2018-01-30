package Google.Tree.健身房问题;

import java.util.*;

//
public class Solution {

    public coordinate find_coordinate(char[][] array)
    {
        List<coordinate> E_position = new LinkedList<>();
        Deque<coordinate> queue = new ArrayDeque<>();
        for(int i = 0;i<array.length;i++)
        {
            for(int j = 0;j<array[0].length;j++)
            {
                if(array[i][j]=='E')
                {
                    E_position.add(new coordinate(i,j,0));
                }
            }
        }

        cost[][] cur_cost = new cost[array.length][array[0].length];

        for(int i = 0; i<E_position.size();i++)
        {
            boolean[][] visited = new boolean[array.length][array[0].length];
            Arrays.fill(visited,false);
            queue.push(E_position.get(i));
            while(!queue.isEmpty())
            {
                coordinate cur = queue.pollFirst();

                if(cur.x+1<array[0].length && !visited[cur.x+1][cur.y] && array[cur.x+1][cur.y]!='C' && array[cur.x+1][cur.y]!='E')
                {
                    cur_cost[cur.x+1][cur.y].cost+=cur.cost;
                    cur_cost[cur.x+1][cur.y].count++;
                    visited[cur.x+1][cur.y] = true;
                    queue.offerLast(new coordinate(cur.x+1,cur.y,cur.cost+1));
                }
                if(cur.y+1<array.length && !visited[cur.x][cur.y+1] && array[cur.x][cur.y+1]!='C' && array[cur.x][cur.y+1]!='E')
                {
                    cur_cost[cur.x][cur.y+1].cost+=cur.cost;
                    cur_cost[cur.x][cur.y+1].count++;
                    visited[cur.x][cur.y+1] = true;
                    queue.offerLast(new coordinate(cur.x,cur.y+1,cur.cost+1));
                }
                if(cur.x-1>=0 && !visited[cur.x-1][cur.y] && array[cur.x-1][cur.y]!='C' && array[cur.x-1][cur.y]!='E')
                {
                    cur_cost[cur.x-1][cur.y].cost+=cur.cost;
                    cur_cost[cur.x-1][cur.y].count++;
                    visited[cur.x-1][cur.y] = true;
                    queue.offerLast(new coordinate(cur.x-1,cur.y,cur.cost+1));
                }
                if(cur.y-1>=0 && !visited[cur.x][cur.y-1] && array[cur.x][cur.y-1]!='C' && array[cur.x][cur.y-1]!='E')
                {
                    cur_cost[cur.x][cur.y-1].cost+=cur.cost;
                    cur_cost[cur.x][cur.y-1].count++;
                    visited[cur.x][cur.y-1] = true;
                    queue.offerLast(new coordinate(cur.x,cur.y-1,cur.cost+1));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        coordinate min_cor=new coordinate(-1,-1,0);
        for(int i = 0;i<array.length;i++)
        {
            for(int j = 0;j<array[0].length;j++)
            {
                if(cur_cost[i][j].count==E_position.size())
                {
                    if(cur_cost[i][j].cost<min)
                    {
                        min_cor = new coordinate(i,j,0);
                    }
                }
            }
        }

        return min_cor;



    }

    private class coordinate{
        int x;
        int y;
        int cost = 0;
        public coordinate(int x, int y, int cost)
        {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    private class cost{
        int count = 0;
        int cost = 0;

    }
}
