package prefixsum;

import java.io.*;
import java.util.*;

public class Boj10986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long answer = 0;

        st = new StringTokenizer(br.readLine());

        long[] sum = new long[N];
        long[] rest = new long[M];

        sum[0] = Long.parseLong(st.nextToken());
        for(int i = 1; i < N; i++) sum[i] = sum[i - 1] + Long.parseLong(st.nextToken());

        for(int i = 0; i < sum.length; i++) {
            int num = (int) (sum[i] % M);
            if(num == 0) answer++;
            rest[num]++;
        }

        for(int i = 0; i < rest.length; i++) {
            if(rest[i] > 1) answer += (rest[i] * (rest[i] - 1) / 2);
        }
        System.out.println(answer);
    }
}
