package dp;

import java.io.*;
import java.util.*;

public class Boj14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int D[] = new int[N + 2];
        int T[] = new int[N + 1];
        int P[] = new int[N + 1];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = N; i >= 0; i--) {
            if(T[i] + i <= N) {
                D[i] = Math.max(D[i + 1], P[i] + D[i + T[i]]);
                continue;
            }
            D[i] = D[i + 1];
        }
        System.out.println(D[0]);
    }
}
