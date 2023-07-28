package dfsbfs;

import java.util.*;

public class P154540 {

    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) {
        String[] map1 = {"X591X", "X1X5X", "X231X", "1XXX1"};
        String[] map2 = {"XXX", "XXX", "XXX"};
        solution(map1);
        solution(map2);
    }

    public static List<Integer> solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) map[i] = maps[i].toCharArray();

        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                if(maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    visited[i][j] = true;
                    list.add(bfs(i, j));
                }
            }
        }

        if(list.isEmpty()) list.add(-1);
        Collections.sort(list);

        return list;
    }

    static int bfs(int i, int j) {
        int sum = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int y = now[0];
            int x = now[1];
            sum += map[y][x] - '0';

            for(int n = 0; n < 4; n++) {
                int nx = x + dx[n];
                int ny = y + dy[n];

                if(nx < 0 || ny < 0 || ny >= map.length || nx >= map[0].length) continue;
                if(!visited[ny][nx] && map[ny][nx] != 'X') {
                    visited[ny][nx]= true;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
        return sum;
    }
}
