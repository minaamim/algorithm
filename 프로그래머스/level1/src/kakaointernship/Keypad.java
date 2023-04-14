package kakaointernship;

/**
 * 2020 카카오 인턴십 키패드 누르기
 */
public class Keypad {

    public static void main(String args[]) {
        int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand1 = "right";

        int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand2 = "left";

        int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand3 = "right";

        System.out.println(solution(numbers1, hand1));
        System.out.println(solution(numbers2, hand2));
        System.out.println(solution(numbers3, hand3));
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;

        for(int i = 0; i < numbers.length; i++) {
            int n = numbers[i];

            if (n == 1 || n == 4 || n == 7) {
                left = n;
                answer += "L";
            }

            if (n == 3 || n == 6 || n == 9) {
                right = n;
                answer += "R";
            }
            if (n == 2 || n == 5 || n == 8 || n == 0) {
                if (n == 0)
                    n = 11;

                int l = Math.abs(n - left) / 3 + Math.abs(n - left) % 3;
                int r = Math.abs(n - right) / 3 + Math.abs(n - right) % 3;

                if (l == r) {
                    if (hand.equals("right")) {
                        right = n;
                        answer += "R";
                    } else {
                        left = n;
                        answer += "L";
                    }
                } else if (l > r) {
                    right = n;
                    answer += "R";
                } else {
                    left = n;
                    answer += "L";
                }
            }
        }

        return answer;
    }
}
