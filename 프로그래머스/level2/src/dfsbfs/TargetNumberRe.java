package dfsbfs;

public class TargetNumberRe {

    public static void main(String args[]) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        solution(numbers, target);
    }
    static int answer = 0;

    public static int solution(int[] numbers, int target) {
        dfs(0, numbers, target, 0);
        return answer;
    }

    static void dfs(int sum, int[] numbers, int target, int degree) {

        if(degree == numbers.length) {
            if(sum == target)
                answer++;
            return;
        }
            dfs(sum + numbers[degree], numbers, target, degree + 1);
            dfs(sum - numbers[degree], numbers, target, degree + 1);
    }
}
