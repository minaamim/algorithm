package tree;

import java.io.*;
import java.util.*;

public class Boj14425 {
    private static int N, M;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        Node root = new Node();

        while(N > 0) {
            String text = sc.next();
            Node now = root;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);

                if(now.next[c - 'a'] == null) {
                    now.next[c - 'a'] = new Node();
                }

                now = now.next[c - 'a'];
                if(i == text.length() - 1) now.isEnd = true;
            }
            N--;
        }

        int cnt = 0;
        while(M > 0) {
            String text = sc.next();
            Node now = root;

            for(int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if(now.next[c - 'a'] == null) break;

                now = now.next[c - 'a'];
                if(i == text.length() - 1 && now.isEnd) cnt++;
            }
            M--;
        }
        System.out.println(cnt);
    }

    private static class Node {
        Node[] next = new Node[26];
        boolean isEnd;
    }
}