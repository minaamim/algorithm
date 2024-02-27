package dp;

import java.util.*;

public class Re11726 {
    private static long[] D;
    private static long MOD = 10007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        D = new long[10001];
        D[1] = 1;
        D[2] = 2;

        for(int i = 3; i <= N; i++) {
            D[i] = (D[i - 1] + D[i - 2]) % MOD;
        }
        System.out.println(D[N]);
    }
}
