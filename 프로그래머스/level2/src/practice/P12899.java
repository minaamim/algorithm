package practice;

public class P12899 {

    public static void main(String args[]) {
        System.out.println(solution(4));
    }

    public static String solution(int n) {

        String[] numbers = {"4", "1", "2"};

        String answer = "";

        while(n > 0) {
           answer = numbers[n % 3] + answer;
           n = (n - 1) / 3;
        }

        return answer;
    }

}
