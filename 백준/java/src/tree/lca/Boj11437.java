package tree.lca;

import java.io.*;
import java.util.*;

public class Boj11437 {
    private static int N, M;
    private static ArrayList<Integer>[] tree;
    private static int[] depth;
    private static int[] parent;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        depth = new int[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            tree[s].add(e);
            tree[e].add(s);
        }

        bfs(1);

        M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            LCA(a, b);
        }
    }

    private static void LCA(int a, int b) {
        if(depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        while(depth[a] != depth[b]) {
            a = parent[a];
        }
        while(a != b) {
            a = parent[a];
            b = parent[b];
        }
        System.out.println(a);
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        int level = 1;
        int nowSize = 1;
        int count = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int next : tree[now]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    parent[next] = now;
                    depth[next] = level;
                }
            }
            count++;
            if(count == nowSize) {
                count = 0;
                nowSize = queue.size();
                level++;
            }
        }
    }
}