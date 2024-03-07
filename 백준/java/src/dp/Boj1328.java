package dp;

import java.io.*;
import java.util.*;

public class Boj1328 {
    private static long MOD = 1000000007;
    private static long[][][] D;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();
        D = new long[101][101][101];

        D[1][1][1] = 1;

        for(int i = 2; i <= N; i++) {
            for(int l = 1; l <= L; l++) {
                for(int r = 1; r <= R; r++) {
                    D[i][l][r] = (D[i - 1][l][r] * (i - 2) + (D[i - 1][l][r - 1] + D[i - 1][l - 1][r])) % MOD;
                }
            }
        }
        System.out.println(D[N][L][R]);
    }
}
