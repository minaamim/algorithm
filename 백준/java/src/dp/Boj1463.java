package dp;

import java.util.*;
import java.io.*;

public class Boj1463 {
    static int dp[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        System.out.println(recursion(N));
    }

    static int recursion(int N) {
        int min = 0;

        if(N == 1) return 0;
        if(dp[N] > 0) return dp[N];

        min = recursion(N - 1) + 1;

        if(N % 2 == 0) {
            int temp = recursion(N / 2) + 1;
            min = temp < min ? temp : min;
        }

        if(N % 3 == 0) {
            int temp = recursion(N / 3) + 1;
            min = temp < min ? temp : min;
        }
        return min;
    }


}
