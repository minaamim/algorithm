package zip.tjfvmfdydid_java;

import java.io.*;
import java.util.*;

public class Boj17451 {
    private static int N;
    private static int[] planet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        planet = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            planet[i] = Integer.parseInt(st.nextToken());
        }
        long speed = 0;
        for(int i = N - 1; i >= 0; i--) {
            if(planet[i] < speed) {
                long div = (speed / planet[i]);
                if(speed % planet[i] != 0) div++;
                speed = planet[i] * div;
                continue;
            }
            speed = planet[i];
        }

        System.out.println(speed);
    }
}
