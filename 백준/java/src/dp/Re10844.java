package dp;

import java.util.*;

public class Re10844 {
    private static long MOD = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[][] D = new long[N + 1][11];
        for(int i = 1; i < 10; i++) {
            D[1][i] = 1;
        }

        for(int i = 2; i <= N; i++) {
            D[i][0] = D[i - 1][1];
            D[i][9] = D[i - 1][8];
            for(int j = 1; j < 9; j++) {
                D[i][j] = (D[i - 1][j - 1] + D[i - 1][j + 1]) % MOD;
            }
        }

        long sum = 0;
        for(int i = 0; i < 10; i++) {
            sum = (sum + D[N][i]) % MOD;
        }
        System.out.println(sum);
    }
}
