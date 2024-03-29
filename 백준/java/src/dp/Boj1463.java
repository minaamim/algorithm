package dp;

import java.util.*;
import java.io.*;

public class Boj1463 {
    static int dp[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;

            if(i % 2 == 0 && dp[i/2] < dp[i]) {
                dp[i] = dp[i/2] + 1;
            }

            if(i % 3 == 0 && dp[i/3] < dp[i]) {
                dp[i] = dp[i/3] + 1;
            }
        }
        System.out.println(dp[N]);
        }
}
