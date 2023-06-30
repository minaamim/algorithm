package dfs;

import java.io.*;
import java.util.*;

public class Boj2178 {

    static int m, n;
    static int[][] maze;
    static int[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        maze = new int[m][n];
        visited = new int[m][n];

        for(int i = 0; i < m; i++) {
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

        answer = visited[m - 1][n - 1] == 0 ? -1 : visited[m - 1][n - 1];
        System.out.println(answer);
    }

    static void bfs() {
        visited[0][0] = 1;

        Queue<int[]> queue = new LinkedList<int[]>();

        queue.add(new int[]{0,0});

        while(!queue.isEmpty()) {
            var current = queue.remove();
            var y = current[0];
            var x = current[1];

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= m || nx < 0 || nx >= n) {
                    continue;
                }

                if(visited[ny][nx] == 0 && maze[ny][nx] == 1) {
                    visited[ny][nx] = visited[y][x] + 1;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }

}
