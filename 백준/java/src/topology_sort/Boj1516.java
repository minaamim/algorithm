package topology_sort;

import java.io.*;
import java.util.*;

public class Boj1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] arr = new ArrayList[N + 1];
        int[] time = new int[N + 1];
        int[] degree = new int[N + 1];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            while(true) {
                int token = Integer.parseInt(st.nextToken());
                if(token == -1) break;

                arr[token].add(i);
                degree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] ans = new int[N + 1];

        for(int i = 0; i < degree.length; i++) {
            if(degree[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int next : arr[now]) {
                degree[next]--;
                ans[next] = Math.max(ans[next], ans[now] + time[now]);
                if(degree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        for(int i = 1; i < ans.length; i++) {
            System.out.println(ans[i] + time[i]);
        }
    }
}