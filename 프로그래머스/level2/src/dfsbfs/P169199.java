package dfsbfs;

import java.util.*;

public class P169199 {

    public static void main(String[] args) {
        String[] board1 = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        String[] board2 = {".D.R", "....", ".G..", "...D"};
        System.out.println(solution(board1));
        System.out.println(solution(board2));
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] map;
    static boolean[][] visited;
    static char ROBOT = 'R', DISABLE = 'D', GOAL = 'G';
    static int gx, gy;

    public static int solution(String[] board) {
        int answer;
        int rx = 0, ry = 0;
        map = new char[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];
        int idx = 0;
        for(String str : board) {
            map[idx++] = str.toCharArray();
        }

        for(int y = 0; y < map.length; y++) {
            for(int x = 0; x < map[y].length; x++) {
                if(map[y][x] == ROBOT) {
                    rx = x;
                    ry = y;
                }
                if(map[y][x] == GOAL) {
                    gx = x;
                    gy = y;
                }
            }
        }

        answer = bfs(rx, ry);

        return answer;
    }

    static int bfs(int j , int i) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j, 0});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int y = now[0];
            int x = now[1];
            int count = now[2];

            if(gx == x && gy == y) return count;

            for(int n = 0; n < 4; n++) {
                int nx = x + dx[n];
                int ny = y + dy[n];

                while(inRange(nx, ny) && map[ny][nx] != DISABLE) {
                    nx += dx[n];
                    ny += dy[n];
                }

                nx -= dx[n];
                ny -= dy[n];

                if(visited[ny][nx] || (ny == i && nx == j)) continue;
                visited[ny][nx] = true;
                queue.add(new int[] {ny, nx, count+1});
            }
        }
        return -1;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < map[0].length && y < map.length;
    }
}
