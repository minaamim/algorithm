package dfsbfs;

public class Network {

    public static void main(String args[]) {
        int[][] computer1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] computer2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        System.out.println(solution(3, computer1));
        System.out.println(solution(3, computer2));
    }

    static boolean[] visited;

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];

        for(int i = 0; i < computers.length; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i, computers);
            }
        }
        return answer;
    }

    static void dfs(int depth, int[][] computers) {

        visited[depth] = true;

        for(int j = 0; j < computers.length; j++) {
            if (depth != j && !visited[j] && computers[depth][j] == 1)
                dfs(j, computers);
        }
        return;
    }
}
