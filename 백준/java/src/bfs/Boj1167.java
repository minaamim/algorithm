package bfs;

import java.io.*;
import java.util.*;

public class Boj1167 {

    private static List<Edge>[] nodes;
    private static boolean[] visited;
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        nodes = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) {
                int E = Integer.parseInt(st.nextToken());
                if(E == -1) break;
                int V = Integer.parseInt(st.nextToken());

                nodes[node].add(new Edge(E, V));
            }
        }
        bfs(1);

        int max = 1;
        for(int i = 2; i < distance.length; i++) {
            if(distance[i] > distance[max]) max = i;
        }

        visited = new boolean[N + 1];
        distance = new int[N + 1];
        bfs(max);

        Arrays.sort(distance);
        System.out.println(distance[N]);
    }

    private static void bfs(int idx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        visited[idx] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(Edge edge : nodes[now]) {
                int e = edge.idx;
                int v = edge.value;

                if(!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now] + v;
                }
            }
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
