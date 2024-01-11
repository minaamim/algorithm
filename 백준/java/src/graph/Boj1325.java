package graph;

import java.io.*;
import java.util.*;

public class Boj1325 {

    private static ArrayList<Integer>[] arr;
    private static boolean[] visited;
    private static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        cnt = new int[N + 1];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s].add(e);
        }

        for(int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            bfs(i);
        }

        int MAX = Integer.MIN_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < cnt.length; i++) {
            if(cnt[i] > MAX) {
                MAX = cnt[i];
                ans.clear();
                ans.add(i);
            } else if(cnt[i] == MAX) {
                ans.add(i);
            }
        }

        for(int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
    private static void bfs(int node) {
        visited[node] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int next : arr[now]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    cnt[next]++;
                }
            }
        }
    }
}