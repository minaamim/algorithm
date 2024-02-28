package dp;

import java.io.*;
import java.util.*;

public class Boj13398 {
    private static int[] A;
    private static int[] L;
    private static int[] R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        L = new int[N];
        R = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        L[0] = A[0];
        int result = L[0];
        for(int i = 1; i < N; i++) {
            L[i] = Math.max(A[i], L[i - 1] + A[i]);
            result = Math.max(result, L[i]);
        }

        R[N - 1] = A[N - 1];
        for(int i = N - 2; i >= 0; i--) {
            R[i] = Math.max(A[i], R[i + 1] + A[i]);
        }

        for(int i = 1; i < N - 1; i++) {
            result = Math.max(result, L[i - 1] + R[i + 1]);
        }
        System.out.println(result);
    }
}
