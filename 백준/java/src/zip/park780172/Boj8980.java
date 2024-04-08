package zip.park780172;

import java.io.*;
import java.util.*;

public class Boj8980 {
    private static int N, C, M;
    private static Delivery info[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        info = new Delivery[M];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int box = Integer.parseInt(st.nextToken());
            info[i] = new Delivery(from, to, box);
        }
        Arrays.sort(info);

        int box[] = new int[N + 1];
        int max, available, total = 0;

        for(int i = 0; i < M; i++) {
             int from = info[i].from;
             int to = info[i].to;
             int cnt = info[i].box;
             max = 0;

            for (int j = from; j < to; j++) {
                max = Math.max(max, box[j]);
            }
            available = Math.min(C - max, cnt);
            total += available;
            for (int j = from; j < to; j++) {
                box[j] += available;
            }
        }
        System.out.println(total + box[N]);
    }

    private static class Delivery implements Comparable<Delivery> {
        int from, to, box;
        Delivery(int from, int to, int box) {
            this.from = from;
            this.to = to;
            this.box = box;
        }

        @Override
        public int compareTo(Delivery o) {
            if(this.to == o.to) return this.from - o.from;
            return this.to - o.to;
        }
    }
}
