package minimum_spanning_tree;

import java.io.*;
import java.util.*;

public class Boj1197 {

    private static int N, M;
    private static int[] parent;
    private static PriorityQueue<Edge> queue = new PriorityQueue<>((o1, o2) -> {
        return o1.value - o2.value;
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            queue.add(new Edge(s, e, v));
        }

        int usedEdge = 0;
        int ans = 0;

        while(usedEdge < N - 1) {
            Edge now = queue.poll();
            if(find(now.start) != find(now.end)) {
                union(now.start, now.end);
                ans += now.value;
                usedEdge++;
            }
        }
        System.out.println(ans);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }

    private static int find(int node) {
        if(parent[node] == node) return node;
        return find(parent[node]);
    }

    private static class Edge {
        int start;
        int end;
        int value;

        public Edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}
