package graph;

import java.io.*;
import java.util.*;

public class Boj2251 {

    private static int[] sender = {0, 0, 1, 1, 2, 2};
    private static int[] receiver = {1, 2, 0, 2, 0, 1};
    private static boolean[][] visited = new boolean[201][201];
    private static boolean[] answer = new boolean[201];
    private static int[] now = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < now.length; i++) {
            now[i] = Integer.parseInt(st.nextToken());
        }

        bfs();

        for(int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void bfs() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;

        while(!queue.isEmpty()) {
            AB p = queue.poll();
            int A = p.A;
            int B = p.B;
            int C = now[2] - A - B;

            for(int k = 0; k < 6; k++) {
                int[] next = {A, B, C};
                next[receiver[k]] += next[sender[k]];
                next[sender[k]] = 0;

                if(next[receiver[k]] > now[receiver[k]]) {
                    next[sender[k]] = next[receiver[k]] - now[receiver[k]];
                    next[receiver[k]] = now[receiver[k]];
                }

                if(!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    if(next[0] == 0) answer[next[2]] = true;
                }
            }
        }
    }

    static class AB {
        int A;
        int B;

        public AB(int A, int B) {
            this.A = A;
            this.B = B;
        }
    }
}
