package practice;

import java.util.PriorityQueue;

public class Defence {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int round = 0; round < enemy.length; round++) {
            queue.add(enemy[round]);
            if(queue.size() > k)
                n -= queue.poll();
            if(n < 0)
                return round;
        }
        answer = enemy.length;
        return answer;
    }
}
