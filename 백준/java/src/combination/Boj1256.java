package combination;

import java.util.*;

public class Boj1256 {
    private static int N, M, K;
    private static int[][] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        D = new int[N + M + 1][N + M + 1];

        for(int i = 0; i < D.length; i++) {
            D[i][1] = i;
            D[i][0] = 1;
            D[i][i] = 1;
        }

        for(int i = 2; i < D.length; i++) {
            for(int j = 1; j < D.length; j++) {
                D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
                if (D[i][j] > 1000000000) D[i][j] = 1000000001;

            }
        }

        if (D[N + M][M] < K) {
            System.out.println("-1");
            return;
        }

        while(!(N == 0 && M == 0)) {
            if(D[N - 1 + M][M] >= K) {
                System.out.print("a");
                N--;
            } else {
                System.out.print("z");
                K -= D[N - 1 + M][M];
                M--;
            }
        }
    }
}