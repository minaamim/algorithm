package stack;

import java.util.*;

public class Development {

    public static void main(String args[]) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] progresses1 = { 95, 90, 99, 99, 80, 99 };
        int[] speeds1 = {1, 1, 1, 1, 1, 1};

        solution(progresses, speeds);
        solution(progresses1, speeds1);
    }


    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) queue.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));

        while(!queue.isEmpty()) {
            int cnt = 1;
            int day = queue.poll();

            while(!queue.isEmpty() && day >= queue.peek()) {
                cnt++;
                queue.poll();
            }
            ans.add(cnt);
        }
        answer = new int[ans.size()];

        int index = 0;
        for(int i : ans) {
            answer[index] = i;
            index++;
        }
        return answer;
    }
}
