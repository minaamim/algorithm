package stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Development {

    public static void main(String args[]) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        solution(progresses, speeds);
    }


    public static int[] solution(int[] progresses, int[] speeds) {
        /**
         * progresses: 먼저 배포돼야하는 순서대로 작업의 진도가 적힌 배열
         * speeds: 각 작업의 개발 속도
         */

        List<Integer> answer = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        //작업 일수 저장
        for(int i = 0; i < progresses.length; i++)
            queue.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));


        while(!queue.isEmpty()) {
            int day = queue.poll();
            int cnt = 1;

            while (!queue.isEmpty() && day >= queue.peek()) {
                cnt++;
                queue.poll();
            }
            answer.add(cnt);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
