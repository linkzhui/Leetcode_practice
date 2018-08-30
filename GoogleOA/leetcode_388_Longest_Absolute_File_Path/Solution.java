package Google.GoogleOA.leetcode_388_Longest_Absolute_File_Path;


//hashMap stores (level, the length of the path up to level level) pairs. By default, we use a (0,0) to initialize the hashmap. But for example "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext".
//dir is in level 1, not 0. subdir1 is in level 2, so on...
//we update the hashMap using hashMap.get(level) + len + 1 because the current level is level+1, previous level is level, we +1 because the additional path separator char \ , if s contains . , we update the current max length
//Hope helps

import java.util.HashMap;

public class Solution {
    public int lengthLongestPath(String input) {
        //HashMap key: # of level, value: length of path to this level
        HashMap<Integer,Integer> map = new HashMap<>();
        //dir is level 1, therefore we need to put level 0 into the hashmap
        map.put(0,0);
        //record current longest path;
        int result = 0;
        for(String path:input.split("\n"))
        {
            //because /n is level 1;
            int prev_level = path.lastIndexOf("\t")+1;
            int currentLevelLen = path.length()-prev_level;
            if(path.contains("."))
            {
                //current level is file
                //we need add / between previous level and current file
                result = Math.max(result,map.get(prev_level)+currentLevelLen);
            }
            else{
                //current level is sub dir
                map.put(prev_level+1, map.get(prev_level)+currentLevelLen+1);
            }
        }
        return result;
    }
}
