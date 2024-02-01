package tree;

import java.io.*;
import java.util.*;

public class Boj11725 {

    private static int N;
    private static ArrayList<Integer>[] tree;
    private static boolean[] visited;
    private static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        ans = new int[N + 1];

        for(int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            tree[s].add(e);
            tree[e].add(s);
        }
        dfs(1);

        for(int i = 2; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    private static void dfs(int node) {
        visited[node] = true;

        for(int next : tree[node]) {
            if(!visited[next]) {
                ans[next] = node;
                dfs(next);
            }
        }
    }
}
