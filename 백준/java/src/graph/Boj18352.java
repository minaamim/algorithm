package graph;

import java.io.*;
import java.util.*;

public class Boj18352 {

    private static ArrayList<Integer>[] arr;
    private static int[] dist;
    private static Set<Integer> ans = new TreeSet<>();
    private static int N, M, K, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        dist = new int[N + 1];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < dist.length; i++) {
            dist[i] = -1;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s].add(e);
        }

        bfs(X);

        if(ans.isEmpty()) {
            System.out.println("-1");
            return;
        }

        for (int city : ans) {
            System.out.print(city + " ");
        }
    }

    private static void bfs(int city) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(city);
        dist[city]++;
        while(!queue.isEmpty()) {
            int now = queue.poll();

            if(dist[now] == K) ans.add(now);

            for(int next : arr[now]) {
                if(dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
