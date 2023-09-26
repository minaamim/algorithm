package practice;

import java.util.*;

public class P12927 {

    public static void main(String[] args) {
        int[] works1 = {4, 3, 3};
        int[] works2 = {2, 1, 2};
        int[] works3 = {1, 1};
        System.out.println(solution(4, works1));
        System.out.println(solution(1, works2));
        System.out.println(solution(3, works3));
    }

    public static long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int work : works) pq.add(work);

        for(int i = 0; i < n; i++) {
            if(pq.peek() <= 0) break;
            pq.add(pq.poll() - 1);
        }

        while(!pq.isEmpty()) {
            int tired = pq.poll();
            answer += tired * tired;
        }

        return answer;
    }
}
