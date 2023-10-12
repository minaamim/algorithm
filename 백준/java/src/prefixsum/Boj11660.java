package prefixsum;

import java.io.*;
import java.util.*;

public class Boj11660 {

    public static void main(String[] args) throws IOException {
        long arr[][], sum[][];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        arr = new long[N + 1][N + 1];
        sum = new long[N + 1][N + 1];

        for(int y = 1; y <= N; y++) {
            int x = 1;
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) arr[y][x++] = Long.parseLong(st.nextToken());
        }

        for(int y = 1; y <= N; y++) {
            for(int x = 1; x <= N; x++) {
                if(x == 1) {
                    sum[y][x] = arr[y][x] + sum[y-1][x];
                    continue;
                }
                else if(y == 1) {
                    sum[y][x] = arr[y][x] + sum[y][x - 1];
                    continue;
                }
                sum[y][x] = arr[y][x] + sum[y - 1][x] + sum[y][x - 1] - sum[y - 1][x - 1];
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1, y1, x2, y2;
            y1 = Integer.parseInt(st.nextToken());
            x1 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());

            long result = (sum[y2][x2] - sum[y1 - 1][x2] - sum[y2][x1 - 1] + sum[y1 - 1][x1 - 1]);
            System.out.println(result);
        }
    }
}