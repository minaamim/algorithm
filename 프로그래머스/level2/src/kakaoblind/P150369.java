package kakaoblind;

import java.util.*;

public class P150369 {

    public static void main(String args[]) {

        int cap = 4, n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};

        System.out.println(solution(cap, n, deliveries, pickups));

    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliver = 0, pickup = 0;

        for(int i = n - 1; i >= 0; i--) {
            if(deliveries[i] != 0 || pickups[i] != 0) {
                int cnt = 0;
                while(deliver < deliveries[i] || pickup < pickups[i]) {
                    cnt++;
                    deliver += cap;
                    pickup += cap;
                }
                deliver -= deliveries[i];
                pickup -= pickups[i];
                answer += (i+1) * cnt * 2;
            }
        }
        return answer;
    }
}
