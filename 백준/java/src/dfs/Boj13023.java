package dfs;

import java.io.*;
import java.util.*;

public class Boj13023 {

    static List<Integer>[] nodes;
    static boolean[] visited;
    static boolean arrived;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        nodes = new ArrayList[N];
        arrived = false;

        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            nodes[a].add(b);
            nodes[b].add(a);
        }

        for(int i = 0; i < N; i++) {
            if (arrived) {
                System.out.println("1");
                return;
            }

            if (!visited[i]) {
                dfs(i, 1);
            }
        }
        System.out.println("0");
    }

    private static void dfs(int node, int depth) {
        if(depth == 5 || arrived) {
            arrived = true;
            return;
        }

        visited[node] = true;
        for(int i : nodes[node]) {
            if(!visited[i]) {
                dfs(i, depth + 1);
            }
        }
        visited[node] = false;
    }
}
