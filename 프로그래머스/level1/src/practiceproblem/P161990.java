package practiceproblem;

import java.util.*;

public class P161990 {

    public static void main(String[] args) {
        String[] paper1 = {".#...", "..#..", "...#."};
        String[] paper2 = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        String[] paper3 = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        String[] paper4 = {"..", "#."};

        solution(paper1);
        solution(paper2);
        solution(paper3);
        solution(paper4);
    }

    public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        int minX = wallpaper[0].length(), maxX = 0;
        int minY = wallpaper.length + 1, maxY = 0;

        for(int y = 0; y < wallpaper.length; y++) {
            for(int x = 0; x < wallpaper[y].length(); x++) {
                char c = wallpaper[y].charAt(x);
                if(c == '#') {
                    if(x < minX) minX = x;
                    if(x > maxX) maxX = x;

                    if(y < minY) minY = y;
                    if(y > maxY) maxY = y;
                }
            }
        }

        answer[0] = minY;
        answer[1] = minX;
        answer[2] = maxY + 1;
        answer[3] = maxX + 1;

        return answer;
    }

}
