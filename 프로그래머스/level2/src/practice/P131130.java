package practice;

import java.util.*;

public class P131130 {

    public static void main(String[] args) {
        int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};
        System.out.println(solution(cards));
    }

    static boolean[] visited;
    static PriorityQueue<Integer> queue;

    public static int solution(int[] cards) {
        int answer = 0;
        visited = new boolean[cards.length];
        queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < cards.length; i++) {
            if(!visited[i]) dfs(cards, i, 0);
        }

        if(queue.size() != 1) answer = queue.poll() * queue.poll();
        return answer;
    }

    static void dfs(int[] cards, int num, int depth) {
        if(visited[num]) {
            queue.add(depth);
            return;
        }
        visited[num] = true;
        dfs(cards, cards[num] - 1, depth + 1);
    }
}
