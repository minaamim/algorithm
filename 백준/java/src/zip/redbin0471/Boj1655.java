package zip.redbin0471;

import java.io.*;
import java.util.*;

public class Boj1655 {
    private static PriorityQueue<Integer> pq = new PriorityQueue<>();
    private static PriorityQueue<Integer> reversePq = new PriorityQueue<>(
            Comparator.reverseOrder()
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());
            if(pq.size() == reversePq.size()) {
                reversePq.add(target);
                if(!pq.isEmpty() && reversePq.peek() > pq.peek()) {
                    pq.add(reversePq.poll());
                    reversePq.add(pq.poll());
                }
            } else {
                pq.add(target);
                if(reversePq.peek() > pq.peek()) {
                    pq.add(reversePq.poll());
                    reversePq.add(pq.poll());
                }
            }
            bw.write(reversePq.peek() + "\n");
        }
        bw.flush();
        bw.close();
    }
}
