package dp;

import java.util.*;
import java.io.*;

public class Boj9095 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());

            int[] dp = new int[num+1];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for(int j = 4; j <= num; j++) {
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            System.out.println(dp[num]);
        }

    }
}
