package bruteforce;

public class Fatigue {

    public static void main(String args[]) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(solution(k, dungeons));
    }

    static boolean[] visited;
    static int answer = -1;

    public static int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];

        dfs(k, dungeons, 0);

        return answer;
    }


    static void dfs(int now, int[][] dungeons, int depth) {

        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && check(now, dungeons[i][0])) {
                visited[i] = true;
                dfs(now - dungeons[i][1], dungeons, depth+1);
                visited[i] = false;
            }
        }

        answer = Math.max(answer, depth);

    }

    static boolean check(int now, int next) {
        return now >= next ? true : false;
    }

}
