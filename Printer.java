package Google;

import java.util.Arrays;


class GPS{
    public enum Direction{NORTH,SOUTH,EAST,WEST};
}

public class Printer {
    
    
    public static void main(String[] args){
        Printer sol = new Printer();
        sol.print("1123","1232","231");
    }


    public void print(String... input)
    {
        System.out.println(Arrays.toString(input));
    }

}
