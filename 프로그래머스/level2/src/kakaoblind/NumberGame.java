package kakaoblind;

import java.util.ArrayList;
import java.util.List;

/**
 * 2018 kakao blind recruitment 3차
 */

public class NumberGame {

    public static void main(String args[]) {
        System.out.println(solution(2, 4, 2, 1));
        System.out.println(solution(16, 16, 2, 1));
        System.out.println(solution(16, 16, 2, 2));
    }

    public static String solution(int n, int t, int m, int p) {

        /**
         * n: n진수
         * t: 횟수
         * m: 인원
         * p: 순서
         */

        String answer = "";

        List<Character> list = new ArrayList<>();

        for(int i = 0; i <= m * t; i++) {
            String num = Integer.toString(i, n);

            for(int j = 0; j < num.length(); j++)
                list.add(num.charAt(j));
        }

        int j = 0;
        for(int i = p; i < list.size(); i+=m) {

            if(j == t) break;
            answer += list.get(i - 1);
            j++;

        }

        answer = answer.toUpperCase();

        return answer;
    }

}
