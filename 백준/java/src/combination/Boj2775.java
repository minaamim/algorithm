package combination;

import java.io.*;
import java.util.Scanner;

public class Boj2775 {
    private static int[][] dp;
    private static int floor, room;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            floor = sc.nextInt();
            room = sc.nextInt();

            dp = new int[floor + 1][room + 1];
            getPersonnel();
        }
    }

    private static void getPersonnel() {
        for(int i = 1; i <= room; i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i <= floor; i++) {
            for(int j = 1; j <= room; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        System.out.println(dp[floor][room]);
    }
}
