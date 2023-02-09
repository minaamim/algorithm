package backtracking;

import java.util.Scanner;

public class BOJ9663 {

    static int N;
    static int[] queen;
    static int result = 0;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        queen = new int[N];
        backtracking(0);
        System.out.println(result);
    }

    static void backtracking(int row) {

        if(row == N) {
            result++;
            return;
        }

        for(int i = 0; i < N; i++) {
            queen[row] = i;
            if(isOkay(row)) {
                backtracking(row+1);
            }
        }
    }

    static boolean isOkay(int col) {

        for(int i = 0; i < col; i++) {
            //같은 열에 놓인 퀸이 있다면
            if(queen[col] == queen[i])
                return false;

            //대각선에 놓인 퀸이 있다면
            if(Math.abs(i - col) == Math.abs(queen[i] - queen[col]))
                return false;
        }

        return true;
    }

}
