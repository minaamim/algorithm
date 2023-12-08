package dfs;

import java.io.*;
import java.util.*;

public class Boj2023 {
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    private static void dfs(int num, int depth) {
        if(isPrime(num) && depth == N) {
            System.out.println(num);
        }

        for(int i = 1; i < 10; i++) {
            if(isPrime(num * 10 + i)) {
                dfs(num * 10 + i, depth + 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        if(num == 0 || num == 1) return false;

        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
