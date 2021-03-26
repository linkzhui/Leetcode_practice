package Google.Array.lc_valid_mountain_array;

class Solution {
    public boolean validMountainArray(int[] arr) {
        int flip = 0;
        boolean increasing = true;
        if (arr.length == 1 || arr[1] <= arr[0]) {
            return false;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) {
                return false;
            }
            if ((arr[i] > arr[i-1] && increasing) || (arr[i] < arr[i-1] && !increasing)) {
            } else{
                increasing = !increasing;
                flip ++;
                if (flip > 1) {
                    return false;
                }
            }

        }
        return flip == 1;
    }
}
