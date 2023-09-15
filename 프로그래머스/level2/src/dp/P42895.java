package dp;

import java.util.*;

public class P42895 {

    public static void main(String[] args) {
        System.out.println(solution(5, 12));
        System.out.println(solution(2, 11));
    }

    public static int solution(int N, int number) {
        int answer = -1;

        Set<Integer>[] dp = new Set[9];
        for (int i = 1; i < 9; i++) dp[i] = new TreeSet<>();

        for (int i = 1; i < 9; i++) dp[i].add(Integer.parseInt(Integer.toString(N).repeat(i)));

        for(int i = 1; i < 9; i++) {
            for(int j = 1; j < i; j++) {
                for(int k : dp[j]) {
                    for(int l : dp[i - j]) {
                        dp[i].add(k + l);
                        dp[i].add(k - l);
                        dp[i].add(k * l);
                        if(l != 0) dp[i].add(k / l);
                    }
                }
            }
        }

        for(int i = 1; i <= 8; i++) {
            if(dp[i].contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

}
