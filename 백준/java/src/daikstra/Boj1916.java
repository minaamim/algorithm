package daikstra;

import java.io.*;
import java.util.StringTokenizer;

public class Boj1916 {

    static int INF = 1000000;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] a = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) a[i][j] = INF;
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a[s][e] > c) a[s][e] = c;
        }

        StringTokenizer st = new StringTokenizer(br.readLine()); br.close();
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] distance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++) {
            distance[i] = INF;
            visited[i] = false;
        }

        distance[start] = 0;

        for(int k = 0; k < N - 1; k++) {
            int min = INF + 1;
            int x = -1;

            //노드 선택
            for(int i = 1; i <= N; i++) {
                if(visited[i] == false && min > distance[i]) {
                    min = distance[i];
                    x = i;
                }
            }

            visited[x] = true;

            //최솟값 갱신
            for(int i = 1; i <= N; i++) {
                if(distance[i] > distance[x] + a[x][i]) distance[i] = distance[x] + a[x][i];
            }
        }

        System.out.println(distance[end]);
    }
}
