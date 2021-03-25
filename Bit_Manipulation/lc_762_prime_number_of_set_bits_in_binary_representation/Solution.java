package Google.Bit_Manipulation.lc_762_prime_number_of_set_bits_in_binary_representation;

import java.util.HashMap;

class Solution {
    public int countPrimeSetBits(int L, int R) {
        //key is integer
        //value represent if key is prime number or not, prime number is 1, non prime number is 0
        HashMap<Integer, Integer> primeMap = new HashMap<>();
        int totalCount = 0;
        primeMap.put(1, 0);   //1 is not prime number
        for (int i = L; i <= R; i++) {
            int num = i;
            int count = 0;
            while(num > 0) {
                count += (num % 2);
                num /= 2;
            }
            if (!primeMap.containsKey(count)) {
                primeMap.put(count, checkPrime(count));
            }
            totalCount += primeMap.get(count);
        }
        return totalCount;
    }

    private int checkPrime(int n) {
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}
