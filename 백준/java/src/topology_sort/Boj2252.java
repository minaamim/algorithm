package topology_sort;

import java.io.*;
import java.util.*;

public class Boj2252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arr = new ArrayList[N + 1];
        int[] degree = new int[N + 1];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            degree[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i < degree.length; i++) {
            if(degree[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");

            for(int next : arr[now]) {
                degree[next]--;
                if(degree[next] == 0) queue.add(next);
            }
        }
    }
}
