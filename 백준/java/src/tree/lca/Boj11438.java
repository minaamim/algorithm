package tree.lca;

import java.io.*;
import java.util.*;

public class Boj11438 {
    private static int N, M, kMAX;
    private static int[][] parent;
    private static ArrayList<Integer>[] tree;
    private static int[] depth;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            tree[s].add(e);
            tree[e].add(s);
        }

        int temp = 1;
        kMAX = 0;
        while(temp <= N) {
            temp <<= 1;
            kMAX++;
        }

        parent = new int[kMAX + 1][N + 1];

        bfs(1);

        for(int k = 1; k <= kMAX; k++) {
            for(int n = 1; n <= N; n++) {
                parent[k][n] = parent[k - 1][parent[k - 1][n]];
            }
        }

        M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            LCA(a, b);
        }
    }

    private static void LCA(int a, int b) {
        if(depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        for(int k = kMAX; k >= 0; k--) {
            if(Math.pow(2, k) <= depth[b] - depth[a]) {
                if(depth[a] <= depth[parent[k][b]]) {
                    b = parent[k][b];
                }
            }
        }

        for(int k = kMAX; k >= 0; k--) {
            if(parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        int lca = a;
        if (a != b) {
            lca = parent[0][lca];
        }
        System.out.println(lca);
    }

    private static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        int level = 1;
        int nowSize = 1;
        int cnt = 0;

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int next : tree[now]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    parent[0][next] = now;
                    depth[next] = level;
                }
            }
            cnt++;
            if(cnt == nowSize) {
                cnt = 0;
                nowSize = q.size();
                level++;
            }
        }
    }
}
