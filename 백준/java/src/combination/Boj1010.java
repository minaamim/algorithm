package combination;

import java.io.*;
import java.util.*;

public class Boj1010 {
    private static int N, M;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp = new int[31][31];
        for(int i = 0; i <= 30; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
            dp[i][1] = i;
        }

        for(int i = 2; i <= 30; i++) {
            for(int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            System.out.println(dp[M][N]);
        }
    }
}
