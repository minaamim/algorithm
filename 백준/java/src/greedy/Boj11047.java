package greedy;

import java.io.*;
import java.util.*;

public class Boj11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int answer = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] > K) continue;

            answer += (K / arr[i]);
            K %= arr[i];
        }
        System.out.println(answer);
    }
}