package kakaotechinternship2022;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueue {

    public int solution(int[] queue1, int[] queue2) {

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long s1 = 0, s2 = 0, sum;

        for(int queue : queue1) {
            q1.add(queue);
            s1 += queue;
        }

        for(int queue: queue2) {
            q2.add(queue);
            s2 += queue;
        }
        sum = s1 + s2;

        if(sum % 2 == 1)
            return -1;

        sum /= 2;

        int p1 = 0, p2 = 0, limit = queue1.length * 2;

        while(p1 <= limit && p2 <= limit) {
            if(s1 == sum)
                return p1 + p2;

            if(s1 > sum) {
                s1 -= q1.peek();
                s2 += q1.peek();
                q2.add(q1.poll());
                p1++;
            } else {
                s2 -= q2.peek();
                s1 += q2.peek();
                q1.add(q2.poll());
                p2++;
            }
        }
        return -1;
    }

}
