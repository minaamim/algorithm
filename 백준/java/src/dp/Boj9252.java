package dp;

import java.util.*;

public class Boj9252 {

    private static long[][] dp;
    private static char[] A;
    private static char[] B;
    private static List<Character> path;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.next().toCharArray();
        B = sc.next().toCharArray();
        dp = new long[A.length + 1][B.length + 1];
        path = new ArrayList<>();

        for(int i = 1; i <= A.length; i++) {
            for(int j = 1; j <= B.length; j++) {
                if(A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(dp[A.length][B.length]);
        getText(A.length, B.length);
        for(int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i));
        }
    }

    private static void getText(int r, int c) {
        if(r == 0 || c == 0) return;
        if(A[r - 1] == B[c - 1]) {
            path.add(A[r - 1]);
            getText(r - 1, c - 1);
        } else {
            if (dp[r - 1][c] > dp[r][c - 1]) {
                getText(r - 1, c);
            } else getText(r, c - 1);
        }
    }
}