package unionfind;

import java.io.*;
import java.util.*;

public class Boj1976 {

    static int[] parent;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];

        for(int i = 1; i <= N; i++) parent[i] = i;

        for(int i = 1; i <= N; i++) {
            String[] str = br.readLine().split(" ");

            for(int j = 0; j < N; j++) {
                if(str[j].equals("1")) union(i, j + 1);
            }
        }

        String[] plan = br.readLine().split(" ");

        int start = find(Integer.parseInt(plan[0]));

        for(int i = 1; i < M; i++) {
             if(find(Integer.parseInt(plan[i])) != start) {
                 System.out.println("NO");
                 return;
             }
        }

        System.out.println("YES");

    }

    public static int find(int x) {
        if(x == parent[x]) return x;
        return find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            if(x < y) parent[y] = x;
            else parent[x] = y;
        }
    }
}
