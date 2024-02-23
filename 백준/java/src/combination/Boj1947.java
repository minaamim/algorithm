package combination;

import java.util.*;

public class Boj1947 {
    private static int N;
    private static long[] D;
    private static long MOD = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        D = new long[1000001];
        D[1] = 0;
        D[2] = 1;

        for(int i = 3; i <= N; i++) {
            D[i] = (i - 1) * (D[i - 1] + D[i - 2]) % MOD;
        }
        System.out.println(D[N]);
    }
}