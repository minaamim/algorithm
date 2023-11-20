package slidingwindow;

import java.io.*;
import java.util.*;

public class Boj11003 {
    public static void main(String[] args) throws IOException {
        int N, L;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while(!deque.isEmpty() && deque.getLast().value > now) deque.removeLast();

            deque.addLast(new Node(now, i));

            if(deque.getFirst().index <= i - L) deque.removeFirst();

            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    private static class Node {
        private int value;
        private int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
