package dfsbfs;

public class Network {
    boolean[] check;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        check = new boolean[n];

        for(int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(computers, i);
                answer++;
            }
        }
        return answer;
    }

    boolean[] dfs(int[][] computers, int i) {
        check[i] = true;

        for(int j = 0; j < computers.length; j++) {

            //이어져있으면 모두 check
            if(check[j] == false && computers[i][j] == 1 && i!=j) {
                check = dfs(computers, j);
            }
        }
        return check;
    }
}
