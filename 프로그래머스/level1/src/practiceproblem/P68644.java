package practiceproblem;

import java.util.*;

public class P68644 {
    public static void main(String args[]) {
        int[] numbers1 = {2, 1, 3, 4, 1};
        int[] numbers2 = {5, 0, 2, 7};
        solution(numbers1);
        solution(numbers2);
    }

    public static int[] solution(int[] numbers) {
        int[] answer = {};

        Set<Integer> set = new TreeSet();

        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        answer = new int[set.size()];

        int idx = 0;
        for(int i : set) answer[idx++] = i;

        return answer;
    }
}
