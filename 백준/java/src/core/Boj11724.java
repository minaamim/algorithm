package core;

import java.io.*;
import java.util.*;

public class Boj11724 {

    private static int N, M;
    private static List<Integer>[] edges;
    private static boolean[] visited;
    private static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = 0;

        edges = new List[N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            edges[u].add(v);
            edges[v].add(u);
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                ans++;
                dfs(i);
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int node) {
        visited[node] = true;
        for(int next: edges[node]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
}
