package zip.inhadong;

import java.io.*;
import java.util.*;

public class Boj14500 {
    private static int N, M;
    private static int[][] paper;
    private static boolean[][] visited;
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                visited[r][c] = true;
                backTracking(r, c, 1, paper[r][c]);
                visited[r][c] = false;
            }
        }
        System.out.println(answer);
    }

    private static void backTracking(int r, int c, int depth, int sum) {
        if(depth == 4) {
            if(answer < sum) answer = sum;
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nextR = r + dy[i];
            int nextC = c + dx[i];

            if(!isValid(nextR, nextC)) continue;
            if(visited[nextR][nextC]) continue;

            if(depth == 2) {
                visited[nextR][nextC] = true;
                backTracking(r, c, depth + 1, sum + paper[nextR][nextC]);
                visited[nextR][nextC] = false;
            }

            visited[nextR][nextC] = true;
            backTracking(nextR, nextC, depth + 1, sum + paper[nextR][nextC]);
            visited[nextR][nextC] = false;
        }
    }

    private static boolean isValid(int r, int c) {
        if(r < 0 || r >= N || c < 0 || c >= M) return false;
        return true;
    }
}
