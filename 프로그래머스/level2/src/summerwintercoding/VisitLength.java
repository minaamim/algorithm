package summerwintercoding;

import java.util.*;

public class VisitLength {
    public static void main(String args[]) {
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][][][] visited = new boolean[11][11][11][11];

    public static int solution(String dirs) {
        int answer = 0;
        int index = 0;
        int x, y, nextX = 5, nextY = 5;

        for(int i = 0; i < dirs.length(); i++) {

            x = nextX;
            y = nextY;

            switch (dirs.charAt(i)) {
                case 'U':
                    index = 2;
                    break;
                case 'D':
                    index = 3;
                    break;
                case 'R':
                    index = 0;
                    break;
                case 'L':
                    index = 1;
                    break;
            }

            nextX += dx[index];
            nextY += dy[index];

            if(nextX < 0 || nextY < 0 || nextX > 10 || nextY > 10){
                nextX -= dx[index];
                nextY -= dy[index];
                continue;
            }

            if(!visited[x][y][nextX][nextY] && !visited[nextX][nextY][x][y]) {
                visited[x][y][nextX][nextY] = true;
                visited[nextX][nextY][x][y] = true;
                answer++;
            }
        }
        return answer;
    }

}
