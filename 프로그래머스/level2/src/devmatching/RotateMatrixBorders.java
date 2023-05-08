package devmatching;

import java.util.*;

/**
 * 2021 Dev-Matching
 * 행렬 테두리 회전하기
 */

public class RotateMatrixBorders {
    public static void main(String args[]) {
        int rows1 = 6, columns1 = 6;
        int rows2 = 3, columns2 = 3;
        int rows3 = 100, columns3 = 97;

        int[][] queries1 = {
                {2, 2, 5, 4},
                {3, 3, 6, 6},
                {5, 1, 6, 3}
        };

        int[][] queries2 = {
                {1, 1, 2, 2},
                {1, 2, 2, 3},
                {2, 1, 3, 2},
                {2, 2, 3, 3}
        };

        int[][] queries3 = { {1, 1, 100, 97} };

        solution(rows1, columns1, queries1);
        solution(rows2, columns2, queries2);
        solution(rows3, columns3, queries3);
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] matrix = new int[rows][columns];

        //행렬 채우기
        int idx = 1;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = idx;
                idx++;
            }
        }

        for(int i = 0; i < queries.length; i++) {
            int x1 = queries[i][1] - 1;
            int y1 = queries[i][0] - 1;
            int x2 = queries[i][3] - 1;
            int y2 = queries[i][2] - 1;
            int min = 100;

            Queue<Integer> queue = new LinkedList<>();

            for(int dx = x1; dx <= x2; dx++) {
                int temp = matrix[y1][dx];
                if(!queue.isEmpty()) matrix[y1][dx] = queue.poll();
                queue.add(temp);

                if(matrix[y1][dx] < min) min = matrix[y1][dx];
            }

            for(int dy = y1 + 1; dy <= y2; dy++) {
                int temp = matrix[dy][x2];
                if(!queue.isEmpty()) matrix[dy][x2] = queue.poll();
                queue.add(temp);
                if(matrix[dy][x2] < min) min = matrix[dy][x2];
            }

            for(int dx = x2 - 1; dx >= x1; dx--) {
                int temp = matrix[y2][dx];
                if(!queue.isEmpty()) matrix[y2][dx] = queue.poll();
                queue.add(temp);
                if(matrix[y2][dx] < min) min = matrix[y2][dx];
            }

            for(int dy = y2 - 1; dy >= y1; dy--) {
                int temp = matrix[dy][x1];
                if(!queue.isEmpty()) matrix[dy][x1] = queue.poll();
                queue.add(temp);
                if(matrix[dy][x1] < min) min = matrix[dy][x1];
            }

            answer[i] = min;
        }

        return answer;
    }

}
