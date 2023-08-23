package dfsbfs;

import java.util.*;

public class P81302 {

    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        int[] arr = solution(places);
        for(int i : arr) System.out.print(i + " ");
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int i = 0; i < places.length; i++) {
            String[] p = places[i];

            boolean check = true;

            for(int r = 0; r < 5 && check; r++) {
                for(int c = 0; c < 5 && check; c++) {
                    if(p[r].charAt(c) == 'P') {
                        if(!bfs(r, c, p)) check = false;
                    }
                }
            }
            answer[i] = check ? 1 : 0;
        }
        return answer;
    }

    private static boolean bfs(int r, int c, String[] p) {
        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || (nr == r && nc == c)) continue;

                int d = Math.abs(nr - r) + Math.abs(nc - c);

                if (p[nr].charAt(nc) == 'P' && d <= 2) return false;
                else if (p[nr].charAt(nc) == 'O' && d < 2) queue.offer(new int[]{nr, nc});
            }
        }
        return true;
    }
}
