package practice;

public class P154538 {

    public static void main(String args[]) {
        System.out.println(solution(10, 40, 5));
        System.out.println(solution(10, 40, 30));
        System.out.println(solution(2, 5, 4));
    }

    static int ans = Integer.MAX_VALUE;

    public static int solution(int x, int y, int n) {
        dfs(x, y, n, 0);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }

    private static void dfs(int now, int y, int n, int cnt) {
        if(now > y) return;
        if(y == now) {
            ans = Math.min(ans, cnt);
            return;
        }

        dfs(now * 2, y, n, cnt + 1);
        dfs(now * 3, y, n, cnt + 1);
        dfs(now + n, y, n, cnt + 1);
    }

}
