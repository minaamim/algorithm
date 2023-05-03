package dp;

import java.util.*;
import java.io.*;

/**
 * 실버 1
 */

public class BuyingCard {

    public static void main(String argsp[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split(" ");

        int[] dp = new int[N+1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], Integer.parseInt(arr[j - 1]) + dp[i - j]);
            }
        }
        System.out.println(dp[N]);
    }
}
