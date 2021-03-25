package Google.Array.ls_849_maximize_distance_to_closest_person;

class Solution {
    //three cases need to think
    // 1. first seat is empty: the first seat has been taken by someone - 0 = maximum distance between to closest person
    // 2. last seat is empty: last seat index - the most right seat has been taken by someone = max distance
    // 3. left side have a seat taken by someone, right side have one seat taken by someone: distance = (right - left) / 2
    public int maxDistToClosest(int[] seats) {
        int left = -1;
        int max = 1;
        int i = 0;
        for (; i < seats.length; i++) {
            if (seats[i] != 0) {
                if (left == -1) {
                    max = Math.max(max, i);
                } else {
                    max = Math.max(max, (i - left)/2);
                }
                left = i;
            }
        }
        if (seats[i-1] == 0) {
            max = Math.max(max, i - 1 - left);
        }
        return max;
    }
}
