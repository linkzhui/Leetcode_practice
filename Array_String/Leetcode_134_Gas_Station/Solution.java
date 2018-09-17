package Google.Array_String.Leetcode_134_Gas_Station;

//greedy algorithm: if the current sum cannot be positive, the start index will be next positive sum

// Whenever the sum is negative, reset it and let the car start from next point.
// In the mean time, add up all of the left gas to total. If it's negative finally, return -1 since it's impossible to finish.
// If it's non-negative, return the last point saved in res;
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length == 0)
        {
            return -1;
        }
        if(cost == null || cost.length == 0) {
            return 0;
        }

        int total = 0;
        int index = 0;
        int current_sum = 0;
        for (int i = 0; i < gas.length; i++) {
            current_sum += gas[i] - cost[i];
            if (current_sum < 0) {
                total += current_sum;
                current_sum = 0;
                index = i+1;
            }
        }
        total += current_sum;
        return total < 0? -1 : index;
    }
}
