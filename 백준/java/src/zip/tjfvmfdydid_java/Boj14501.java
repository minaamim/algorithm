package zip.tjfvmfdydid_java;

import java.io.*;
import java.util.*;

public class Boj14501 {
    private static int N;
    private static int[] time;
    private static int[] price;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        time = new int[N + 1];
        price = new int[N + 1];
        dp = new int[N + 2];

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            time[i] = t;
            price[i] = p;
        }

        for(int i = 1; i <= N + 1; i++) {
            for(int j = 1; j < i; j++) {
                if(j + time[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[j] + price[j]);
                }
            }
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        System.out.println(dp[N + 1]);
    }
}