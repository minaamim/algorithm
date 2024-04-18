package zip.tjfvmfdydid_java;

import java.io.*;
import java.util.*;

public class Boj16960 {
    private static int N, M;
    private static List<Integer>[] switches;
    private static int[] lampes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        switches = new List[N + 1];
        lampes = new int[M + 1];
        for(int i = 1; i <= N; i++) {
            switches[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num; j++) {
                int lamp = Integer.parseInt(st.nextToken());
                switches[i].add(lamp);
                lampes[lamp]++;
            }
        }

        for(int i = 1; i <= N; i++) {
            if(isPossible(i)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static boolean isPossible(int idx) {
        boolean flag = true;

        for(int lamp : switches[idx]) {
            lampes[lamp]--;
            if(lampes[lamp] <= 0) {
                flag = false;
            }
        }

        for(int lamp : switches[idx]) {
            lampes[lamp]++;
        }

        return flag;
    }
}
