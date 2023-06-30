import java.io.*;
import java.util.*;

public class Boj7562 {

    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[][] maze;
    static boolean[][] visited;
    static int x1, x2, y1, y2;
    static int n;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());

            maze = new int[n][n];
            visited = new boolean[n][n];

            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            bfs();

            sb.append(maze[x2][y2]).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x1, y1});
        visited[x1][y1] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for(int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= n) {
                    continue;
                }

                if(!visited[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    maze[nx][ny] = maze[x][y] + 1;
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
