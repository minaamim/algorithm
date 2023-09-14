package heap;

import java.util.*;

public class P42626 {

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        System.out.println(solution(scoville, 7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i : scoville) queue.add(i);

        while(queue.peek() < K) {

            if(queue.size() == 1) return -1;
            queue.add(queue.poll() + queue.poll() * 2);
            answer++;
        }

        return answer;
    }
}
