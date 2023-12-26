package greedy;

import java.util.*;

public class Boj1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long answer = 0;

        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int zero = 0, one = 0;

        for(int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if(num > 1) plusPq.add(num);
            else if(num < 0) minusPq.add(num);
            else if(num == 0) zero++;
            else if(num == 1) one++;
        }

        while(!plusPq.isEmpty()) {
            if(plusPq.size() == 1) {
                answer += plusPq.poll();
                break;
            }
            answer += (plusPq.poll() * plusPq.poll());
        }

        while(!minusPq.isEmpty()) {
            if(minusPq.size() == 1) {
                if(zero == 0) answer += minusPq.poll();
                break;
            }
            answer += (minusPq.poll() * minusPq.poll());
        }

        answer += one;
        System.out.println(answer);
    }
}
