package core;

import java.io.*;
import java.util.*;

public class Boj11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int testCase = Integer.parseInt(st.nextToken());
        int[] target = new int[N + 1];
        int[] sum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            target[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + target[i];
        }

        for(int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(sum[end] - sum[start - 1]);
        }
    }
}