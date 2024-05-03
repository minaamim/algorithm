package zip.tjfvmfdydid_java;

import java.io.*;
import java.util.*;

public class Boj1107 {
    private static int N, M;
    private static boolean[] broken;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        broken = new boolean[10];

        if(M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int ans = Math.abs(N - 100);

        for(int i = 0; i < 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();
            boolean isBreak = false;

            for(int j = 0; j < len; j++) {
                if(broken[str.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }

            if(!isBreak) {
                int min = Math.abs(N - i) + len;
                ans = Math.min(min, ans);
            }
        }
        System.out.println(ans);
    }
}
