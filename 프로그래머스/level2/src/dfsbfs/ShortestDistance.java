package dfsbfs;

import java.util.LinkedList;

/**
 * 참고: https://middleearth.tistory.com/m/61
 */

public class ShortestDistance {

    int[][] maps, visited;
    int m, n;
    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};

    public int solution(int[][] maps) {
        int answer = 0;

        m = maps.length;
        n = maps[0].length;

        visited = new int[m][n];
        this.maps = maps;

        bfs();

        answer = visited[m - 1][n - 1] == 0 ? -1 : visited[m - 1][n - 1];

        return answer;
    }

    void bfs() {
        visited[0][0] = 1;
        var queue = new LinkedList<int[]>();
        queue.add(new int[]{0,0});

        while (!queue.isEmpty()) {
            var curr = queue.remove();
            var y = curr[0];
            var x = curr[1];

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= m || nx < 0 || nx >= n)
                    continue;

                if(visited[ny][nx] == 0 && maps[ny][nx] == 1) {
                    visited[ny][nx] = visited[y][x] + 1;
                    queue.add(new int[]{ny, nx});
                }

            }

        }

    }

}
