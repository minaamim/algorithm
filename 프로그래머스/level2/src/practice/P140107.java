package practice;

public class P140107 {

    public static void main(String[] args) {
        System.out.println(solution(2, 4));
        System.out.println(solution(1, 5));
    }

    public static long solution(int k, int d) {
        long answer = 1;
        answer += ((d / k) * 2);

        double dd = Math.pow(d, 2);

        for(int i = 1; i * k <= d; i++) {
            answer += (long) (Math.sqrt(dd - Math.pow(i * k, 2)) / k);
        }

        return answer;
    }
}
