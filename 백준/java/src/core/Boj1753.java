package core;

import java.io.*;
import java.util.*;

public class Boj1753 {

    private static List<Edge>[] edges;
    private static int[] distance;
    private static boolean[] visited;
    private static PriorityQueue<Edge> pq = new PriorityQueue<>(
            (o1, o2) -> {
                return o1.value - o2.value;
            }
    );
    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        edges = new List[V + 1];
        distance = new int[V + 1];
        visited = new boolean[V + 1];
        Arrays.fill(distance, INF);
        for(int i = 1; i <= V; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[u].add(new Edge(v, w));
        }

        pq.add(new Edge(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            int curIndex = now.idx;
            if(visited[curIndex]) continue;
            visited[curIndex] = true;

            for(Edge next : edges[curIndex]) {
                int nextIdx = next.idx;
                int nextVal = next.value;

                if(distance[nextIdx] > distance[curIndex] + nextVal) {
                    distance[nextIdx] = distance[curIndex] + nextVal;
                    pq.add(new Edge(nextIdx, distance[nextIdx]));
                }
            }
        }

        for(int i = 1; i <= V; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
                continue;
            }
            System.out.println("INF");
        }

    }

    private static class Edge {
        int idx;
        int value;
        Edge(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
