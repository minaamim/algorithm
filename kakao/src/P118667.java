import java.util.*;

public class P118667 {

    public static void main(String[] args) {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        System.out.println(solution(queue1, queue2));
    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0, sum2 = 0;

        for(int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];

            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        while(sum1 != sum2) {

            if(answer > queue1.length * 3) return -1;

            if(sum1 > sum2) {
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.add(q1.poll());
                answer++;
            } else if(sum1 < sum2) {
                sum2 -= q2.peek();
                sum1 += q2.peek();
                q1.add(q2.poll());
                answer++;
            }
        }
        return answer;
    }
}