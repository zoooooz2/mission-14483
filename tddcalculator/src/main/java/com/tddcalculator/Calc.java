package com.tddcalculator;

public class Calc {
    public static int run(String input){
        String[] num = input.split(" ");
        String sign = num[1];

        if(sign.equals("+")){
            return Integer.parseInt(num[0]) + Integer.parseInt(num[2]);
        }
        return Integer.parseInt(num[0]) + Integer.parseInt(num[2]);
    }
}


