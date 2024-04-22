package prefixsum;

import java.io.*;
import java.util.*;

public class Boj1806 {
    private static int N, S;
    private static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        S = stoi(st.nextToken());
        a = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            a[i] = stoi(st.nextToken());
        }

        int sum = 0;
        int len = Integer.MAX_VALUE;
        int start = -1;
        for(int end = 0; end < N; end++) {
            sum += a[end];
            while(sum >= S) {
                len = Math.min(len, end - start);
                start++;
                sum -= a[start];
            }
        }
        if (len == Integer.MAX_VALUE) {
            System.out.println(0);
            return;
        }
        System.out.println(len);
    }

    private static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
