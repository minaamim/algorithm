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
            int temp = matrix[y1][x1];
            int min = temp;

            for(int dy = y1; dy < y2; dy++){
                matrix[dy][x1] = matrix[dy+1][x1];
                if(min > matrix[dy][x1]) min = matrix[dy][x1];
            }
            for(int dx = x1; dx < x2; dx++){
                matrix[y2][dx] = matrix[y2][dx+1];
                if(min > matrix[y2][dx]) min = matrix[y2][dx];
            }
            for(int dy = y2; dy > y1; dy--){
                matrix[dy][x2] = matrix[dy-1][x2];
                if(min > matrix[dy][x2]) min = matrix[dy][x2];
            }
            for(int dx = x2; dx > x1; dx--){
                matrix[y1][dx] = matrix[y1][dx-1];
                if(min > matrix[y1][dx]) min = matrix[y1][dx];
            }
            matrix[y1][x1+1] = temp;
            answer[i] = min;
        }

        return answer;
    }

}
