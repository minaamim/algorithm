package practiceproblem;

import java.util.Arrays;

public class Budget {
    public int solution(int[] d, int budget) {
        //최대 몇 개의 부서에 물품을 지원할 수 있는지 구하라
        int answer = 0;

        Arrays.sort(d);

        for(int i = 0; i < d.length; i++) {
            budget -= d[i];

            if(budget < 0)
                return i;

            answer++;
        }

        return answer;
    }
}
