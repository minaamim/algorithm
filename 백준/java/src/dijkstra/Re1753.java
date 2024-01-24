package dijkstra;

import java.io.*;
import java.util.*;

public class Re1753 {

    private static boolean[] visited;
    private static PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> {
        return o1.value - o2.value;
    }));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        ArrayList<Node>[] arr = new ArrayList[V + 1];
        int[] dist = new int[V + 1];
        visited = new boolean[V + 1];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 1; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
            arr[u].add(new Node(v, w));
        }

        queue.add(new Node(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()) {
            Node now = queue.poll();
            int idx = now.idx;

            if(visited[idx]) continue;

            visited[idx] = true;

            for(int i = 0; i < arr[idx].size(); i++) {
                Node node = arr[idx].get(i);
                int next = node.idx;
                int value = node.value;

                if(dist[next] > dist[idx] + value) {
                    dist[next] = dist[idx] + value;
                    queue.add(new Node(next, dist[next]));
                }
            }
        }
        for(int i = 1; i < dist.length; i++) {
            if(visited[i]) {
                System.out.println(dist[i]);
                continue;
            }
            System.out.println("INF");
        }
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
