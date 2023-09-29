package class2;

import java.io.*;
import java.util.*;

public class Boj4153 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0 && c == 0) break;

            solution(a, b, c);
        }

    }

    private static void solution(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(a);
        pq.add(b);
        pq.add(c);

        c = pq.poll();
        b = pq.poll();
        a = pq.poll();

        if(c * c == b * b + a * a) System.out.println("right");
        else System.out.println("wrong");
    }
}
