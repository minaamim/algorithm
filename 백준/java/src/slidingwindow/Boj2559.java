package slidingwindow;

import java.io.*;
import java.util.*;

public class Boj2559 {
    private static int N, K;
    private static long[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        K = stoi(st.nextToken());
        long max = Integer.MIN_VALUE;
        sum = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + stoi(st.nextToken());
        }

        for(int i = K; i <= N; i++) {
            max = Math.max(max, (sum[i] - sum[i - K]));
        }
        System.out.println(max);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
