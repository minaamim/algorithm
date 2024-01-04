package euler_phi;

import java.util.*;

public class Boj11689 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        long result = N;

        for(long p = 2; p <= Math.sqrt(N); p++) {
            if (N % p == 0) {
                result -= (result / p);

                while(N % p == 0) N /= p;
            }
        }

        if(N > 1) result -= (result / N);

        System.out.println(result);
    }
}