package dfsbfs;

public class TargetNumber {

    public static void main(String args[]) {
        int[] numbers1 = {1, 1, 1, 1, 1};
        int[] numbers2 = {4, 1, 2, 1};

        System.out.println(solution(numbers1, 3));
        System.out.println(solution(numbers2, 4));
    }
    static int answer = 0;

    public static int solution(int[] numbers, int target) {

        dfs(numbers, target, 0, 0);

        return answer;
    }

    static void dfs(int[] numbers, int target, int depth, int sum) {

        System.out.println("target: " + target + " depth: " + depth + " sum: " + sum );
        if(depth == numbers.length) {
            if(sum == target) answer++;

            return;
        }

        dfs(numbers, target, depth + 1, sum + numbers[depth]);
        dfs(numbers, target, depth + 1, sum - numbers[depth]);
    }

}
