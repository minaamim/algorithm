package greedy;

import java.util.Arrays;

public class GymClothes {

    public static void main(String args[]) {

    }

    public int solution(int n, int[] lost, int[] reserve) {
        /**
         * n == 전체 학생의 수
         * lost = 체육복 없는 학생들의 번호가 담긴 배열
         * reserve = 여벌의 체육복이 있는 학생들의 번호
         * 앞,뒷번호에만 체육복 빌려줄 수 있음
         */

        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}
