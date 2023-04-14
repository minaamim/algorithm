package kakaoblindrecruitment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 2019 kakao blind recruitment
 */

public class FailureRate {

    public static void main(String args[]) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        solution(N, stages);
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        Map<Integer, Double> failureRate = new HashMap<>();

        for(int i = 1; i <= N; i++) {
            double failure = 0.0, total = 0.0;

            for(int stage : stages) {
                if(stage == i) failure++;
                if(stage >= i) total++;
            }

            if(failure == 0 && total == 0) total = 1;
            failureRate.put(i, failure / total);
        }

        for(int i = 0; i < N; i++) {
            double max = -1;
            int maxKey = 0;

            for(int key : failureRate.keySet()) {
                if(max < failureRate.get(key)) {
                    max = failureRate.get(key);
                    maxKey = key;
                }
            }
            answer[i] = maxKey;
            failureRate.remove(maxKey);
        }

        return answer;
    }

}
