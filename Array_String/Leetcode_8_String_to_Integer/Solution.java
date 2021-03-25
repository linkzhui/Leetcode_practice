package Google.Array_String.Leetcode_8_String_to_Integer;

class Solution {
    //step 1: skip all the beginning whitespace (String.trim())
    //step 2: check if the first character is number or sign   (we need a value to record the sign)
    //step 3: iterate the rest array:
    //case 1: first non-whitespace character is not number or sign, return 0;
    //case 2: if the number is bigger than max integer or min integer
    //case 3: conversion stop, if next character is not number
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int start = 0;
        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }
        int sign = 1;
        long result = 0;
        if (start < str.length() && (str.charAt(start) == '+' || str.charAt(start) == '-')) {
            if (str.charAt(start) == '-') {
                sign = -1;
            }
            start++;
        }
        while (start < str.length() && Character.isDigit(str.charAt(start))) {
            result = result * 10 + (str.charAt(start) - '0');
            if (result > Integer.MAX_VALUE) {
                return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            start++;
        }
        result *= sign;
        return (int) result;
    }
}
