package practiceproblem;

import java.util.Arrays;

public class FruitSeller {
    class Solution {
        public int solution(int k, int m, int[] score) {
            /**
             * 과일 상태에 따라 1점 - k점
             * m = 한 상자에 담을 수 있는 사과의 수
             * score = 사과들의 점수
             * 과일 장수가 얻을 수 있는 최대 이익을 구하라
             */
            int answer = 0;

            Arrays.sort(score);

            for(int i = score.length - 1; i >=0; i--) {
                if((score.length - i) % m == 0)
                    answer+=score[i] * m;
            }
            return answer;
        }
    }
}
