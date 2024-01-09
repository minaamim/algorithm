package euclidean_algorithm;

import java.io.*;
import java.util.*;

public class Boj1033 {

    static ArrayList<Node>[] arr;
    static long lcm;
    static boolean[] visited;
    static long[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];
        lcm = 1;

        for(int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            arr[a].add(new Node(b, p, q));
            arr[b].add(new Node(a, q, p));
            lcm *= (p * q / gcd(p, q));
        }

        D[0] = lcm;
        dfs(0);
        long mgcd = D[0];

        for(int i = 1; i < N; i++) {
            mgcd = gcd(mgcd, D[i]);
        }
        for(int i = 0; i < N; i++) {
            System.out.print(D[i] / mgcd + " ");
        }
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static void dfs(int node) {
        visited[node] = true;
        for(Node n : arr[node]) {
            int next = n.getB();
            if(!visited[next]) {
                D[next] = D[node] * n.getQ() / n.getP();
                dfs(next);
            }
        }
    }

    private static class Node {
        int b;
        int p;
        int q;

        Node(int b, int p, int q) {
            super();
            this.b = b;
            this.p = p;
            this.q = q;
        }

        int getB() {
            return b;
        }

        int getP() {
            return p;
        }

        int getQ() {
            return q;
        }
    }
}
