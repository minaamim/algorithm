package bfs;

import java.io.*;
import java.util.*;

public class Boj1926 {

    static int x, y, cnt = 0, max = 0;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new int[y][x];
        visited = new boolean[y][x];

        for(int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < x; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.println(cnt);
        System.out.println(max);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                if(arr[i][j] == 0 || visited[i][j]) continue;

                cnt++;
                q.add(new int[]{i, j});
                visited[i][j] = true;
                int area = 0;

                while(!q.isEmpty()) {
                    int[] now = q.poll();
                    area++;

                    for(int k = 0; k < 4; k++) {
                        int ny = now[0] + dy[k];
                        int nx = now[1] + dx[k];

                        if(nx < 0 || nx >= x || ny < 0 || ny >= y ) continue;

                        if(arr[ny][nx] == 1 && !visited[ny][nx]) {
                            q.add(new int[]{ny, nx});
                            visited[ny][nx] = true;
                        }
                    }
                }
                if(area > max) max = area;
            }
        }
    }
}
