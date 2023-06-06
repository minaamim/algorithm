import java.util.*;

public class NextBigNum {
    public static void main(String args[]) {
        int[] numbers1 = {2, 3, 3, 5};
        int[] numbers2 = {9, 1, 5, 3, 6, 2};
        solution(numbers1);
        solution(numbers2);
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            int now = numbers[i];
            for(int j = i; j < numbers.length; j++) {
                int next = numbers[j];
                if (next > now) {
                    answer[i] = next;
                    break;
                } else answer[i] = -1;
            }
        }

        return answer;
    }

}
