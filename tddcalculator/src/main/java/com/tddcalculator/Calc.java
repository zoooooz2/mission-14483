package com.tddcalculator;

public class Calc {
    public static int addRecursive(String[] nums, int idx) {
        if (idx == nums.length) return 0; // 끝에 도달
        return Integer.parseInt(nums[idx].trim()) + addRecursive(nums, idx + 1);
    }
    public static int run(String input){
        String[] nums = input.split("\\+");
        return addRecursive(nums, 0);
    }
}


