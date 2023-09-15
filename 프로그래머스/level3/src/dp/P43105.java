package dp;

public class P43105 {

    public static void main(String[] args) {
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        System.out.println(solution(triangle));
    }

    static int MAX = Integer.MIN_VALUE;

    public static int solution(int[][] triangle) {

        dfs(triangle, 0, 0, 0);

        return MAX;
    }

    private static void dfs(int[][] triangle, int x, int y, int sum) {
        if(y == triangle.length){
            if(sum > MAX) MAX = sum;
            return;
        }
        sum += triangle[y][x];

        dfs(triangle, x, y + 1, sum);
        dfs(triangle, x + 1, y + 1, sum);
    }
}
