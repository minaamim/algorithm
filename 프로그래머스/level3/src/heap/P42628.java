package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class P42628 {

    public static void main(String[] args) {
        String[] operations1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        int[] ans1 = solution(operations1);
        int[] ans2 = solution(operations2);

        for(int i : ans1) System.out.print(i + " ");
        System.out.println();
        for(int i : ans2) System.out.print(i + " ");
    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for(String operation : operations) {
            String[] arr = operation.split(" ");
            int num = Integer.parseInt(arr[1]);
            switch (arr[0]) {
                case "I":
                    min.add(num);
                    max.add(num);
                    break;
                case "D":
                    if(max.isEmpty()) break;
                    if(num == 1) {
                        int del = max.poll();
                        min.remove(del);
                    }
                    if(num == -1) {
                        int del = min.poll();
                        max.remove(del);
                    }
            }
        }

        if(!max.isEmpty()) {
            answer[1] = min.peek();
            answer[0] = max.peek();
        }
        return answer;
    }

}
