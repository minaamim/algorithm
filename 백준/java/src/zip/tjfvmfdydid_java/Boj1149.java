package zip.tjfvmfdydid_java;

import java.io.*;
import java.util.*;

public class Boj1149 {
    private static int N;
    private static int[][] price;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        price = new int[N][3];
        dp = new int[N][3];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                price[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = price[0][0];
        dp[0][1] = price[0][1];
        dp[0][2] = price[0][2];

        for(int i = 1; i < N; i++) {
            dp[i][0] = price[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = price[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = price[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        int ans = Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]);
        System.out.println(ans);
    }
}
