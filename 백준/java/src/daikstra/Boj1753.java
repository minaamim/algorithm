package daikstra;

import java.io.*;
import java.util.*;

public class Boj1753 {

    static int V, E, K; //정점 개수, 간선 개수, 시작점
    static ArrayList<ArrayList<Node>> graph;
    static int distance[];

    static class Node {
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for(int i = 0; i <= V; i++) graph.add(new ArrayList<>());

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        distance = new int[V + 1];

        for (int i = 0; i < distance.length; i++) distance[i] = Integer.MAX_VALUE;

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (o1, o2) -> Integer.compare(o1.cost, o2.cost)
        );

        //시작점
        pq.add(new Node(K, 0));
        distance[K] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if(distance[node.idx] < node.cost) continue;

            for(int i = 0; i < graph.get(node.idx).size(); i++) {
                Node next = graph.get(node.idx).get(i);

                if(distance[next.idx] > node.cost + next.cost) {
                    distance[next.idx] = node.cost + next.cost;
                    pq.add(new Node(next.idx, distance[next.idx]));
                }
            }
        }

        for(int i = 1; i <= V; i++) {
            if(distance[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(distance[i]);
        }
    }
}
