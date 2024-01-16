package unionfind;

import java.io.*;
import java.util.*;

public class Boj1717 {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int calc = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            switch (calc) {
                case 0:
                    union(a, b);
                    break;
                case 1:
                    check(a, b);
                    break;
            }
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[b] = a;
    }

    private static int find(int node) {
        if(node == parent[node]) return node;
        return parent[node] = find(parent[node]);
    }

    private static void check(int a, int b) {
        if(find(a) == find(b)) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }
}
