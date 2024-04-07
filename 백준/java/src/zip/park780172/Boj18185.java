package zip.park780172;

import java.io.*;
import java.util.*;

public class Boj18185 {
    private static int N;
    private static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 2];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        int ans = 0;

        while(idx < N) {
            if(A[idx] > 0) {
                int val = A[idx];
                ans += 3 * val;
                val = Math.min(val, A[idx + 1]);
                ans += 2 * val;
                A[idx + 1] -= val;
                val = Math.min(val, A[idx + 2] - Math.min(A[idx + 1], A[idx + 2]));
                ans += 2 * val;
                A[idx+2] -= val;
            }
            idx++;
        }
        System.out.println(ans);
    }
}
