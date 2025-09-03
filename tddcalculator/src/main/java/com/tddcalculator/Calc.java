package com.tddcalculator;

public class Calc {
    public static int sumRecursive(String[] nums, int idx) {
        if (idx == nums.length) return 0;

        // 현재 항을 정수로 변환
        int value = Integer.parseInt(nums[idx]);

        // 재귀적으로 나머지 합 구하기
        return value + sumRecursive(nums, idx + 1);
    }
    public static int run(String input){
        // 공백 제거
        input = input.replaceAll("\\s+", "");

        // 숫자와 연산자를 분리하기
        String[] nums = input.split("(?=[+-])"); // +,- 앞에서 잘라줌

        return sumRecursive(nums, 0);
    }
}


