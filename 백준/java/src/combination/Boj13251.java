package combination;

import java.io.*;
import java.util.*;

public class Boj13251 {
    private static int N, M, K;
    private static int[] D;
    private static double[] probability;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        D = new int[M];
        probability = new double[M];
        N = 0;
        double ans = 0.0;

        for(int i = 0; i < M; i++) {
            D[i] = sc.nextInt();
            N += D[i];
        }
        K = sc.nextInt();

        for(int i = 0; i < M; i++) {
            if(D[i] >= K) {
                probability[i] = 1.0;
                for (int k = 0; k < K; k++) {
                    probability[i] *= (double) (D[i] - k) / (N - k);
                }
            }
            ans += probability[i];
        }
        System.out.println(ans);
    }
}
