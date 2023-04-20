package kakaoblind;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2018 kakao blind recruitment
 */

public class Friends4Block {

    public static void main(String args[]) {
        String[] board1 = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        String[] board2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        System.out.println(solution(4, 5, board1));
        System.out.println(solution(6, 6, board2));
    }

    static boolean[][] checked;

    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] copy = new char[m][n];

        for(int i = 0; i < m; i++)
            copy[i] = board[i].toCharArray();

        boolean flag = true;

        while(flag) {
            checked = new boolean[m][n];
            flag = false;

            for(int i = 0; i < m-1; i++) {
                for(int j = 0; j < n-1; j++) {
                    if(copy[i][j] == '#') continue;
                    if(check(i, j, copy)) {
                        checked[i][j] = true;
                        checked[i][j+1] = true;
                        checked[i+1][j] = true;
                        checked[i+1][j+1] = true;
                        flag = true;
                    }
                }
            }
            answer += erase(m, n, copy);
            checked = new boolean[m][n];
        }
        return answer;
    }

    static boolean check(int x, int y, char[][] board) {
        char ch = board[x][y];
        if (ch == board[x][y+1] && ch == board[x+1][y] && ch == board[x+1][y+1])
            return true;

        return false;
    }

    static int erase(int m, int n, char[][] board) {
        int cnt = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(checked[i][j])
                    board[i][j] = '.';
            }
        }

        for(int i = 0; i < n; i++) {
            Queue<Character> q = new LinkedList<>();

            for(int j =  m - 1; j >= 0; j--) {
                if(board[j][i] == '.') cnt++;
                else q.add(board[j][i]);
            }

            int index = m - 1;

            while(!q.isEmpty()) board[index--][i] = q.poll();

            for(int j = index; j>= 0; j--)
                board[j][i] = '#';

        }
        return cnt;
    }
}
