package dp;

import java.io.*;
import java.util.*;

public class Boj2342 {

    private static int[][][] D = new int[100001][5][5];
    private static int map[][] = {
            {0, 2, 2, 2, 2},
            {2, 1, 3, 4, 3},
            {2, 3, 1, 3, 4},
            {2, 4, 3, 1, 3},
            {2, 3, 4, 3, 1}
    };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 100001; k++) {
                    D[k][i][j] = 100001 * 5;
                }
            }
        }
        D[0][0][0] = 0;

        int turn = 1;

        while(true) {
            int N = sc.nextInt();
            if(N == 0) break;

            for(int left = 0; left < 5; left++) {
                if(left == N) continue;
                for(int right = 0; right < 5; right++) {
                    D[turn][left][N] = Math.min(D[turn - 1][left][right] + map[right][N], D[turn][left][N]);
                }
            }

            for(int right = 0; right < 5; right++) {
                if(right == N) continue;
                for(int left = 0; left < 5; left++) {
                    D[turn][N][right] = Math.min(D[turn - 1][left][right] + map[left][N], D[turn][N][right]);
                }
            }
            turn++;
        }
        int MIN = Integer.MAX_VALUE;
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                MIN = Math.min(MIN, D[turn - 1][i][j]);
            }
        }
        System.out.println(MIN);
    }
}
