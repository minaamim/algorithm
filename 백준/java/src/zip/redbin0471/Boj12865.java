package zip.redbin0471;

import java.io.*;
import java.util.*;

public class Boj12865 {
    private static int N, K;
    private static int[][] item;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        item = new int[N + 1][2];
        dp = new int[N + 1][K + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            item[i][0] = w;
            item[i][1] = v;
        }

        for(int k = 1; k <= K; k++) {
            for(int i = 1; i <= N; i++) {
                dp[i][k] = dp[i - 1][k];
                if(k - item[i][0] >= 0) {
                    dp[i][k] = Math.max(dp[i - 1][k], item[i][1] + dp[i - 1][k - item[i][0]]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
