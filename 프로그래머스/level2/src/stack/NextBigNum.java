package stack;

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
        Stack<Integer> stack = new Stack<>();

        for(int i = numbers.length - 1; i >= 0; i--) {

            while (!stack.isEmpty()) {
                if (stack.peek() > numbers[i]) {
                    answer[i] = stack.peek();
                    break;
                } else stack.pop();
            }

            if (stack.isEmpty()) answer[i] = -1;
            stack.add(numbers[i]);
        }
        return answer;
    }

}
