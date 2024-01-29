package bellman_ford_moore;

import java.io.*;
import java.util.*;

public class Boj1219 {

    private static int N, M, START, END;
    private static long MIN = Long.MIN_VALUE;
    private static long MAX = Long.MAX_VALUE;
    private static long[] dist;
    private static long[] cityMoney;
    private static Edge[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        START = Integer.parseInt(st.nextToken());
        END = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge[M];
        dist = new long[N];
        cityMoney = new long[N];
        Arrays.fill(dist, MIN);

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(s, e, c);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cityMoney[i] = Long.parseLong(st.nextToken());
        }

        dist[START] = cityMoney[START];

        for(int i = 0; i <= N + 100; i++) {
            for(int j = 0; j < M; j++) {
                int from = edges[j].from;
                int to = edges[j].to;
                int cost = edges[j].cost;

                if(dist[from] == MIN) continue;
                if(dist[from] == MAX) dist[to] = MAX;
                else if(dist[to] < dist[from] + cityMoney[to] - cost) {
                    dist[to] = dist[from] + cityMoney[to] - cost;
                    if(i >= N - 1) dist[to] = MAX;
                }
            }
        }

        if(dist[END] == MIN) {
            System.out.println("gg");
            return;
        }
        if(dist[END] == MAX) {
            System.out.println("Gee");
            return;
        }
        System.out.println(dist[END]);
    }

    private static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}