package backtracking;

import java.util.Scanner;

public class BOJ15651 {

    static boolean[] visit;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static int n, m;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        visit = new boolean[n];
        arr = new int[m];

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth) {

        if(depth == m) {
            for(int temp : arr) {
                sb.append(temp).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
                visit[i] = true;
                arr[depth] = i+1;
                dfs(depth+1);
                visit[i] = false;

        }
    }

}
