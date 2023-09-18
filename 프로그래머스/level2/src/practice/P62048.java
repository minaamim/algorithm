package practice;

public class P62048 {
    public static void main(String[] args){
        System.out.println(solution(8, 12));
    }

    public static long solution(int w, int h) {
        long answer = (long) w * h;
        long num = gcd(w, h);

        answer -= (w / num + h / num - 1) * num;

        return answer;
    }

    private static int gcd(int x, int y) {
        int big = Math.max(x, y);
        int small = Math.min(x, y);

        int tmp = 0;

        while(small > 0) {
            tmp = big % small;
            big = small;
            small = tmp;
        }
        return big;
    }
}