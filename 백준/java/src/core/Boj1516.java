package core;

import java.io.*;
import java.util.*;

public class Boj1516 {
    private static List<Integer>[] edges;
    private static int[] degree;
    private static int[] time;
    private static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        edges = new List[N + 1];
        degree = new int[N + 1];
        time = new int[N + 1];
        result = new int[N + 1];

        for(int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            time[i] = t;

            while(true) {
                int pre = Integer.parseInt(st.nextToken());
                if(pre == -1) break;
                edges[pre].add(i);
                degree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(degree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next : edges[now]) {
                degree[next]--;
                result[next] = Math.max(result[next], result[now] + time[now]);

                if(degree[next] == 0) {
                    q.add(next);
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            System.out.println(result[i] + time[i]);
        }
    }
}
