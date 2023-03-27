package greedy;

import java.util.ArrayList;
import java.util.List;

public class MockTest {

    public static void main(String args[]) {
        int[] answers = {1, 2, 3, 4, 5};

        solution(answers);
    }


    public static int[] solution(int[] answers) {
        int[] answer = {};

        int[] num1 = {1, 2, 3, 4, 5};
        int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int score[] = {0, 0, 0};

        // 채점하기
        for(int i = 0; i <answers.length; i++) {

            //student1
            if(answers[i] == num1[i%5])
                score[0]++;

            if(answers[i] == num2[i%8])
                score[1]++;

            if(answers[i] == num3[i%10])
                score[2]++;
        }

        int max = Math.max(score[0], Math.max(score[1], score[2]));

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < score.length; i++) {
            if(max == score[i])
                list.add(i + 1);
        }

        answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }

}
