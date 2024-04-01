package zip.danimartinwife;

import java.io.*;
import java.util.*;

public class Boj15591 {

    private static int N, Q;
    private static List<Edge>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            edges[p].add(new Edge(q, r));
            edges[q].add(new Edge(p, r));
        }

        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int count = 0;

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[N+1];

            visited[v] = true;
            queue.add(v);

            while(!queue.isEmpty()) {
                int now = queue.poll();

                for(Edge next : edges[now]) {
                    if(!visited[next.idx] && next.val >= k) {
                        count++;
                        queue.add(next.idx);
                        visited[next.idx] = true;
                    }
                }
            }
            sb.append(count+"\n");
        }
        System.out.println(sb);
    }

    static class Edge {
        int idx;
        int val;

        Edge(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}
