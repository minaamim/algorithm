package prime;

import java.util.*;

public class Boj1016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long MIN = sc.nextLong(), MAX = sc.nextLong();
        boolean[] check = new boolean[(int) (MAX - MIN + 1)];
        int ans = 0;

        for(long i = 2; i <= Math.sqrt(MAX); i++) {
            long pow = i * i;

            long idx = MIN / pow;

            if(MIN % pow != 0) idx++;

            for(long j = idx; j * pow <= MAX; j++) {
                check[(int) ((j * pow) - MIN)] = true;
            }
        }

        for(int i = 0; i < check.length; i++) {
            if(!check[i]) ans++;
        }
        System.out.println(ans);
    }
}