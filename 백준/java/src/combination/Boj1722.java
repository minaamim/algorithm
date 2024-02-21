package combination;

import java.io.*;
import java.util.*;

public class Boj1722 {
    private static int N, Q;
    //자리별 경우의 수
    private static long[] cases;
    //순열
    private static long[] P;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Q = Integer.parseInt(st.nextToken());

        cases = new long[N + 1];
        P = new long[N + 1];
        visited = new boolean[N + 1];
        cases[0] = 1;
        for(int i = 1; i < cases.length; i++) {
            cases[i] = cases[i - 1] * i;
        }

        switch (Q) {
            case 1:
                getK(Long.parseLong(st.nextToken()));
                break;
            case 2:
                for(int i = 1; i <= N; i++) {
                    P[i] = Integer.parseInt(st.nextToken());
                }
                getOrder();
        }
    }

    private static void getK(long k) {
        for(int i = 1; i <= N; i++) {
            for(int j = 1, cnt = 1; j <= N; j++) {
                if(visited[j]) continue;
                if(k <= cnt * cases[N - i]) {
                    k -= ((cnt - 1) * cases[N - i]);
                    P[i] = j;
                    visited[j] = true;
                    break;
                }
                cnt++;
            }
        }
        for(int i = 1; i <= N; i++) {
            System.out.print(P[i] + " ");
        }
    }

    private static void getOrder() {
        long k = 1;
        for(int i = 1; i <= N; i++) {
            long cnt = 0;
            for(int j = 1; j < P[i]; j++) {
                if(visited[j] == false) cnt++;
            }
            k += cnt * cases[N - i];
            visited[(int) P[i]] = true;
        }
        System.out.println(k);
    }
}
