package kakaointernship;

import java.util.*;

/**
 * 2019 인턴십
 * 크레인 인형뽑기 게임
 */

public class P64061 {
    public static void main(String args[]) {

        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        int[][] board1 = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int[] moves1 = {1, 2, 3, 4};

        System.out.println(solution(board, moves));
        System.out.println(solution(board1, moves1));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < moves.length; i++) {
            int idx = 0;
            int target = moves[i] - 1;
            while(board[idx][target] == 0 && idx < board.length - 1) {
                idx++;
            }

            int doll = board[idx][target];
            if(doll == 0) continue;
            board[idx][target] = 0;

            if(!stack.isEmpty() && stack.peek() == doll) {
                answer += 2;
                stack.pop();
            } else stack.add(doll);
        }
        return answer;
    }
}
