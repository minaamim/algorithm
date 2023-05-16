package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Spicier {

    public static void main(String args[]) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        System.out.println(solution(scoville, 7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue();

        for(int i : scoville) pq.add(i);

        while(pq.peek() < K) {

            if(pq.size() == 1) return -1;

            int lower = pq.poll();
            int low = pq.poll();

            pq.add(lower + low * 2);
            answer++;
        }

        return answer;
    }
}
