package dp;

import java.util.*;

public class Boj1915 {
    private static long[][] D = new long[1001][1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long max = 0;

        for(int i = 0; i < N; i++) {
            String line = sc.next();
            for(int j = 0; j < M; j++) {
                D[i][j] = Long.parseLong(String.valueOf(line.charAt(j)));
                if(D[i][j] == 1 && j > 0 && i > 0) {
                    D[i][j] = Math.min(D[i - 1][j - 1], Math.min(D[i - 1][j], D[i][j - 1])) + D[i][j];
                }
                if (max < D[i][j]) {
                    max = D[i][j];
                }
            }
        }
        System.out.println(max * max);
    }
}
