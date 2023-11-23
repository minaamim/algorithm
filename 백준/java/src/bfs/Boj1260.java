package bfs;

import java.io.*;
import java.util.*;

public class Boj1260 {
    private static List<Integer>[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M, V;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u].add(v);
            arr[v].add(u);
        }

        for(int i = 0; i < arr.length; i++) {
            Collections.sort(arr[i]);
        }

        dfs(V);
        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);
    }

    private static void dfs(int node) {
        System.out.print(node + " ");
        visited[node] = true;

        for(int i : arr[node]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        visited[node] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");

            for(int i : arr[now]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
