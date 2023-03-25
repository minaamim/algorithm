package stack;

import java.util.Collections;
import java.util.PriorityQueue;

public class Printer {

    public static void main(String args[]) {
//        int[] priorities = {2, 1, 3, 2};
//        int location = 2;

        int[] priorities = {1, 1, 9, 1, 1, 1,};
        int location = 0;

        System.out.println(solution(priorities, location));
    }


    public static int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : priorities)
            pq.add(i);


        while(!pq.isEmpty()) {
            for(int i = 0; i < priorities.length; i++) {

                System.out.println("i: " + i);
                System.out.println("priorities[i]: " + priorities[i]);
                System.out.println("pq.peek(): " + pq.peek());

                if (priorities[i] == pq.peek()) {
                    if (i == location) {
                        return ++answer;
                    }

                    pq.poll();
                    answer++;
                }

            }
        }

        return -1;
    }


}
