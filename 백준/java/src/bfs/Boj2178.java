package bfs;

import java.io.*;
import java.util.*;

public class Boj2178 {

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static int N, M;
    private static int[][] arr;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        bfs(0, 0);
        System.out.println(arr[N-1][M-1]);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            for(int k = 0; k < 4; k++) {
                int di = now[0] + dx[k];
                int dj = now[1] + dy[k];

                if(0 <= di && di < N && 0 <= dj && dj < M) {
                    if(arr[di][dj] != 0 && !visited[di][dj]) {
                        visited[di][dj] = true;
                        arr[di][dj] = arr[now[0]][now[1]] + 1;
                        queue.add(new int[]{di, dj});
                    }
                }
            }
        }
    }
}
