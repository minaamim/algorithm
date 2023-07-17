package practiceproblem;

import java.util.PriorityQueue;

public class HallOfFame {
    public int[] solution(int k, int[] score) {
        //k등 안에 들면 명예의 전당

        int[] answer = new int[score.length];

        //낮은 숫자가 우선
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < score.length; i++) {
            pq.add(score[i]);

            if(pq.size() > k)
                pq.poll();

            answer[i] = pq.peek();
        }
        return answer;
    }
}
