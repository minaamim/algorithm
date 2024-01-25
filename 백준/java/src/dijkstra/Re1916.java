package dijkstra;

import java.io.*;
import java.util.*;

public class Re1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());

        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        ArrayList<Node>[] nodes = new ArrayList[N + 1];

        for(int i = 1; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());

            nodes[s].add(new Node(e, v));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> {
            return o1.value - o2.value;
        }));

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());

        queue.add(new Node(A, 0));
        dist[A] = 0;

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            if(visited[now.idx]) continue;

            visited[now.idx] = true;

            for(Node next : nodes[now.idx]) {
                if(dist[next.idx] > dist[now.idx] + next.value) {
                    dist[next.idx] = dist[now.idx] + next.value;
                    queue.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        System.out.println(dist[B]);
    }

    private static class Node {
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}