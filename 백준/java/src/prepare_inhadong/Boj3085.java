package prepare_inhadong;

import java.io.*;
import java.util.*;

public class Boj3085 {

    private static char[][] board;
    private static int N;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new char[N][N];

        for(int i = 0; i < N; i++) {
            board[i] = sc.next().toCharArray();
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N - 1; j++) {
                swap(i, j, i, j + 1);
                search();
                swap(i, j + 1, i, j);
            }
        }

        for(int j = 0; j < N; j++) {
            for(int i = 0; i < N - 1; i++) {
                swap(i, j, i + 1, j);
                search();
                swap(i + 1, j, i, j);
            }
        }
        System.out.println(max);
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    private static void search() {
        for(int i = 0; i < N; i++) {
            int cnt = 1;
            for(int j = 0; j < N - 1; j++) {
                if(board[i][j] == board[i][j+1]) {
                    cnt++;
                    max = Math.max(max, cnt);
                    continue;
                }
                cnt = 1;
            }
        }

        for(int j = 0; j < N; j++) {
            int cnt = 1;
            for(int i = 0; i < N - 1; i++) {
                if(board[i][j] == board[i+1][j]) {
                    cnt++;
                    max = Math.max(max, cnt);
                    continue;
                }
                cnt = 1;
            }
        }
    }
}
