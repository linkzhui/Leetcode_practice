package Google.Array.ls_1295_find_numbers_with_even_number_of_digits;

class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(Integer num : nums) {
            count += digitNum(num) % 2 == 0? 1 : 0;
        }
        return count;
    }

    private int digitNum(int num) {
        int count = 0;
        while(num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }
}