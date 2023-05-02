package dp;

import java.util.*;
import java.io.*;

public class Boj9095 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[11];
        dp[0] = 1;

        for(int i = 1; i <= 10; i++) {
            for(int j = 1; j <= 3; j++) {
                if(i - j >= 0) {
                    dp[i] += dp[i - j];
                }
            }
        }

        while(N-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }

    }
}
