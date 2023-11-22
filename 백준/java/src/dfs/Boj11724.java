package dfs;

import java.io.*;
import java.util.*;

public class Boj11724 {

    private static List<Integer>[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //노드 개수
        int N = Integer.parseInt(st.nextToken());
        //에지 개수
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;

        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u].add(v);
            arr[v].add(u);
        }

        for(int i = 1; i < arr.length; i++) {
            if(!visited[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int v) {
        if(visited[v]) return;

        visited[v] = true;
        for(int i : arr[v]) {
            if(!visited[i]) dfs(i);
        }
    }
}
