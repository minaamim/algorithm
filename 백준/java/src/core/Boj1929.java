package core;

import java.io.*;
import java.util.*;

public class Boj1929 {
    private static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        getPrime(N);
        for(int i = M; i <= N; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }

    private static void getPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {

            if(!isPrime[i]) continue;

            for(int j = i + i; j <= n; j+= i) {
                isPrime[j] = false;
            }
        }
    }
}