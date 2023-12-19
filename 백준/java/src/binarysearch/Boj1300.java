package binarysearch;

import java.io.*;

public class Boj1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), K = Integer.parseInt(br.readLine());

        long start = 1, end = K;
        long answer = 0;

        while(start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;

            for(int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }

            if(cnt < K) {
                start = mid + 1;
            } else {
                answer = mid;
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }
}