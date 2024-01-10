package euclidean_algorithm;

import java.util.*;

public class Boj21568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(), B = sc.nextInt(), C = sc.nextInt();

        int gcd = gcd(A, B);
        if (C % gcd != 0) {
            System.out.println(-1);
            return;
        }

        int mok = C / gcd;
        long[] ret = execute(A, B);
        System.out.println(ret[0] * mok + " " + ret[1] * mok);
    }

    private static long[] execute(int a, int b) {
        long[] ret = new long[2];
        if(b == 0) {
            ret[0] = 1;
            ret[1] = 0;
            return ret;
        }

        long q = a / b;
        long[] v = execute(b, a % b);
        ret[0] = v[1];
        ret[1] = v[0] - v[1] * q;
        return ret;
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}