package core;

import java.io.*;
import java.util.*;

public class Boj11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while(!deque.isEmpty() && deque.getLast().value > now) {
                deque.removeLast();
            }

            deque.addLast(new Node(i, now));

            if(i - deque.getFirst().idx >= L) {
                deque.removeFirst();
            }
            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        int idx;
        int value;
        Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
