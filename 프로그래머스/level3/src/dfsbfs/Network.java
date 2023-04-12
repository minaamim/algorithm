package dfsbfs;

public class Network {

    static boolean[] visited;

    public static void main(String args[]) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        solution(n, computers);
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for(int i = 0; i < computers.length; i++) {
            if(!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }

    static boolean[] dfs(int i, int[][] computers) {

        visited[i] = true;

        for(int j = 0; j < computers.length; j++) {
            if( i != j && !visited[j] && computers[i][j] == 1)
                visited = dfs(j, computers);
        }
        return visited;
    }
}
