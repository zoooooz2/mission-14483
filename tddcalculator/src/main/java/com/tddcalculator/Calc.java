package com.tddcalculator;

import java.util.ArrayList;
import java.util.List;

public class Calc {
    public static int run(String input) {
        // 공백 제거
        input = input.replaceAll("\\s+", "");

        // 숫자와 연산자 배열로 분리
        List<String> tokens = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                // 음수 판단: 첫 글자이거나 직전이 *면 음수
                if (ch == '-' && (i == 0 || tokens.get(tokens.size() - 1).equals("*"))) {
                    continue; // 숫자와 붙여서 처리
                }

                if (start < i) tokens.add(input.substring(start, i));
                tokens.add(String.valueOf(ch));
                start = i + 1;
            }
        }
        if (start < input.length()) tokens.add(input.substring(start));

        // 재귀로 계산
        return evalRecursive(tokens, 0, tokens.size());
    }

    private static int evalRecursive(List<String> tokens, int start, int end) {
        // 먼저 곱셈 처리
        List<String> temp = new ArrayList<>();
        int i = start;
        while (i < end) {
            String token = tokens.get(i);
            if (token.equals("*")) {
                int left = Integer.parseInt(temp.remove(temp.size() - 1));
                int right = Integer.parseInt(tokens.get(i + 1));
                temp.add(String.valueOf(left * right));
                i += 2;
            } else {
                temp.add(token);
                i++;
            }
        }

        // 이제 덧셈/뺄셈 처리
        int result = Integer.parseInt(temp.get(0));
        i = 1;
        while (i < temp.size()) {
            String op = temp.get(i);
            int num = Integer.parseInt(temp.get(i + 1));
            if (op.equals("+")) result += num;
            else if (op.equals("-")) result -= num;
            i += 2;
        }
        return result;
    }
}


