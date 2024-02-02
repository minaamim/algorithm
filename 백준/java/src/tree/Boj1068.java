package tree;

import java.io.*;
import java.util.*;

public class Boj1068 {

    private static int N, TARGET, ROOT;
    private static ArrayList<Integer>[] tree;
    private static boolean[] visited;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        visited = new boolean[N];

        for(int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) {
                ROOT = i;
                continue;
            }
            tree[parent].add(i);
            tree[i].add(parent);
        }
        TARGET = Integer.parseInt(br.readLine());

        if(TARGET == ROOT) {
            System.out.println("0");
            return;
        }
        dfs(ROOT);
        System.out.println(ans);
    }

    private static void dfs(int node) {
        visited[node] = true;
        int cnt = 0;

        for(int next : tree[node]) {
            if(!visited[next] && next != TARGET) {
                cnt++;
                dfs(next);
            }
        }
        if(cnt == 0) ans++;
    }
}
