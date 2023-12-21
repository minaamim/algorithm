package greedy;

import java.io.*;
import java.util.*;

public class Boj1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        while(true) {
            if (pq.size() == 1) {
                break;
            }
            int p1 = pq.poll(), p2 = pq.poll();
            answer += (p1 + p2);
            pq.add(p1 + p2);
        }
        System.out.println(answer);
    }
}
