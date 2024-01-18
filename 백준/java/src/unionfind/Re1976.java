package unionfind;

import java.io.*;

public class Re1976 {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for(int i = 1; i <= N; i++) {
            String[] data = br.readLine().split(" ");
            for(int j = 0; j < data.length; j++) {
                if(data[j].equals("1")) {
                    union(i, j + 1);
                }
            }
        }

        String[] plan = br.readLine().split(" ");
        int start = find(Integer.parseInt(plan[0]));

        for(int i = 1; i < plan.length; i++) {
            if(find(Integer.parseInt(plan[i])) != start) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }

    private static int find(int node) {
        if(parent[node] == node) {
            return node;
        }
        return find(parent[node]);
    }
}
