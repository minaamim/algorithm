package bellman_ford_moore;

import java.io.*;
import java.util.*;

public class Boj11657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[M + 1];
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(start, end, time);
        }

        dist[1] = 0;

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < M; j++) {
                Edge edge = edges[j];

                if(dist[edge.start] != Integer.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.time) {
                    dist[edge.end] = dist[edge.start] + edge.time;
                }
            }
        }

        boolean hasCycle = false;

        for(int i = 0; i < M; i++) {
            Edge edge = edges[i];
            if(dist[edge.start] != Integer.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.time) hasCycle = true;
        }

        if(!hasCycle) {
            for(int i = 2; i <= N; i++) {
                if(dist[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                    continue;
                }
                System.out.println(dist[i]);
            }
            return;
        }
        System.out.println("-1");
    }
}

class Edge {
    int start, end, time;
    public Edge(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}