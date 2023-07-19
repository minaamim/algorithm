package bruteforce;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 전력망을 둘로 나누기
 */

public class P86971 {

    static int[][] graph;

    public static void main(String args[]) {
        int[][] wires = {
                {1, 3},
                {2, 3},
                {3, 4},
                {4, 5},
                {4, 6},
                {4, 7},
                {7, 8},
                {7, 9}
        };

        System.out.println(solution(9, wires));
    }

    public static int solution(int n, int[][] wires) {
        int answer = n;

        graph = new int[n + 1][n + 1];

        for(int i = 0; i < wires.length; i++) {
            int from = wires[i][0], to = wires[i][1];
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        for(int i = 0; i < wires.length; i++) {
            int from = wires[i][0], to = wires[i][1];
            graph[from][to] = 0;
            graph[to][from] = 0;

            answer = Math.min(answer, bfs(n, from));

            graph[from][to] = 1;
            graph[to][from] = 1;
        }
        return answer;
    }

    static int bfs(int n, int x) {
        boolean[] visited = new boolean[n + 1];
        int cnt = 1;

        Queue<Integer> queue = new LinkedList<>();
        visited[x] = true;
        queue.add(x);

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int i = 1; i <= n; i++) {
                if(graph[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    cnt++;
                }
            }
        }

        return Math.abs(cnt - (n - cnt));
    }
}
