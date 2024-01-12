package graph;

import java.io.*;
import java.util.*;

public class Boj1707 {

    private static ArrayList<Integer>[] arr;
    private static int[] check;
    private static boolean[] visited;
    private static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());
            arr = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            check = new int[N + 1];
            isEven = true;

            for(int i = 0; i < arr.length; i++) {
                arr[i] = new ArrayList<>();
            }

            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());

                arr[s].add(e);
                arr[e].add(s);
            }

            for(int i = 1; i < arr.length; i++) {
                if(isEven) dfs(i);
                else break;
            }

            if(isEven) {
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }
    }

    private static void dfs(int node) {
        visited[node] = true;

        for(int i : arr[node]) {
            if(!visited[i]) {
                check[i] = (check[node] + 1) % 2;
                dfs(i);
            }
            else if(check[node] == check[i]) {
                isEven = false;
            }
        }
    }
}