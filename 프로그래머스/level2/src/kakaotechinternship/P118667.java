package kakaotechinternship;

import java.util.*;

public class P118667 {

    public static void main(String[] args) {
        int[] q1 = {3, 2, 7, 2};
        int[] q2 = {4, 6, 5, 1};
        System.out.println(solution(q1, q2));

        int[] q11 = {1, 2, 1, 2};
        int[] q22 = {1, 10, 1, 2};
        System.out.println(solution(q11, q22));

        int[] q111 = {1, 1};
        int[] q222 = {1, 5};
        System.out.println(solution(q111, q222));
    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        long sum1 = 0, sum2 = 0;
        Queue<Long> q1 = new LinkedList();
        Queue<Long> q2 = new LinkedList();

        for(int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.offer(Long.valueOf(queue1[i]));
            q2.offer(Long.valueOf(queue2[i]));
        }

        int cnt = 0;
        int end = (q1.size() + q2.size()) * 2;

        while(sum1 != sum2) {

            if(cnt > end) break;

            if(sum1 > sum2) {
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.offer(q1.poll());
            }
            else if(sum1 < sum2) {
                sum2 -= q2.peek();
                sum1 += q2.peek();
                q1.offer(q2.poll());
            }
            cnt++;
        }

        if(sum1 == sum2) return cnt;

        return answer;
    }
}
