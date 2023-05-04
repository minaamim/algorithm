package dp;

import java.util.Scanner;

//실버1
public class Boj10844 {

    public static long mod = 1000000000L;

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[][] dp = new long[N+1][10];

        for(int i = 1; i <= 9; i++) dp[1][i] = 1;

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j <= 9; j++) {
                dp[i][j] = 0;
                if(j - 1 >= 0) dp[i][j] += dp[i-1][j-1];
                if(j + 1 <= 9) dp[i][j] += dp[i-1][j+1];

                dp[i][j] %= mod;
            }
        }

        long answer = 0;
        for(int i = 0; i <= 9; i++)
            answer += dp[N][i];

        answer %= mod;
        System.out.println(answer);
    }
}
