package prepare_inhadong;

import java.io.*;
import java.util.*;

public class Boj1107 {
    private static int target;
    private static boolean[] broken = new boolean[10];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        target = sc.nextInt();
        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            broken[sc.nextInt()] = true;
        }

        int result = Math.abs(target - 100);

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
                int min = Math.abs(target - i) + len;
                result = Math.min(min, result);
            }
        }
        System.out.println(result);
    }
}
