package zip.ses9928;

import java.io.*;
import java.util.*;

public class Boj9655 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;

        for(int i = 4; i <= N; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1;
        }

        if(dp[N] % 2 == 0) {
            System.out.println("CY");
            return;
        }
        System.out.println("SK");
    }
}
