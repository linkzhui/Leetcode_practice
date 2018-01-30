package Google.DP.leetcode_98_interleaving_string;

/**
 * Created by raymon on 6/28/17.
 */
public class solution {
    /*

    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int total = s3.length();
        if(n+m!=total)
        {
            return false;
        }
        boolean[] matrix = new boolean[m+1];
        Arrays.fill(matrix,false);
        Arrays.fill(matrix[0],true);

        int horizontal = 2;
        int vertical = 2;
        for(;vertical<=n+2;vertical++)
        {

            for(;horizontal<m+2;horizontal++)
            {
                if(vertical==2&&horizontal==2)
                {
                    matrix[horizontal][vertical]=true;
                }
                else if(vertical==horizontal)
                {

                }

            }


        }





        return false;
    }
    */
}
