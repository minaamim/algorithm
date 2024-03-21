package core;

import java.io.*;
import java.util.*;

public class Boj1717 {

    private static int N, M;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];

        for(int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (type) {
                case 0:
                    union(a, b);
                    break;
                case 1:
                    if(check(a, b)) {
                        System.out.println("YES");
                        break;
                    }
                    System.out.println("NO");
            }
        }

    }

    private static boolean check(int a, int b) {
        if(find(a) == find(b)) return true;
        return false;
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if( a != b ) {
            parent[b] = a;
        }
    }

    private static int find(int node) {
        if(parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }
}
