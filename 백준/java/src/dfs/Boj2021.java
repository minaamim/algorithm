package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj2021 {

    /**
     * N: 역 개수
     * L: 노선 개수
     */
    static int N, L;
    static boolean[] visitedLine;
    static boolean[] visitedStation;
    static ArrayList<Integer>[] stations;
    static ArrayList<Integer>[] lines;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int start, destination, answer;

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);

        visitedLine = new boolean[L + 1];
        visitedStation = new boolean[N + 1];
        stations = new ArrayList[N + 1];
        lines = new ArrayList[N + 1];

        for(int i = 1; i <= N ; i++) {
            stations[i] = new ArrayList<>();
            lines[i] = new ArrayList<>();
        }

        for(int i = 1; i <= L; i++) {
            String[] s = br.readLine().split(" ");

            for(String station : s) {
                int num = Integer.parseInt(station);

                if(num == -1)
                    break;
                stations[num].add(i);
                lines[i].add(num);
            }
        }

        input = br.readLine().split(" ");
        start = Integer.parseInt(input[0]);
        destination = Integer.parseInt(input[1]);

        answer = bfs(start, destination);

        System.out.println(answer);
    }

    static int bfs(int start, int destination) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.transCount));
        visitedStation[start] = true;

        for(int line : stations[start]) {
            pq.add(new Node(line, start, 0));
            visitedLine[line] = true;
        }

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.curStation == destination) {
                return now.transCount;
            }

            for(int nextStation : lines[now.curLine]) {
                if(!visitedStation[nextStation]) {
                    visitedStation[nextStation] = true;
                    pq.add(new Node(now.curLine, nextStation, now.transCount));

                    for(int nextLine : stations[nextStation]) {
                        if(!visitedLine[nextLine]) {
                            visitedLine[nextLine] = true;
                            pq.add(new Node(nextLine, nextStation, now.transCount + 1));
                        }
                    }
                }
            }

        }

        return -1;
    }

    static class Node {
        int curLine;
        int curStation;
        int transCount;

        public Node(int curLine, int curStation, int transCount) {
            this.curLine = curLine;
            this.curStation = curStation;
            this.transCount = transCount;
        }
    }
}
