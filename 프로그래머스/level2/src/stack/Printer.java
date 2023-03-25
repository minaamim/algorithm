package stack;

import java.util.Collections;
import java.util.PriorityQueue;

public class Printer {

    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : priorities)
            pq.add(i);


        while(!pq.isEmpty()) {
            for(int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }

        return -1;
    }


}
