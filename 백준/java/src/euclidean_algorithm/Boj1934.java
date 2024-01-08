package euclidean_algorithm;

import java.util.*;

public class Boj1934 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            System.out.println(a * b / gcd(a, b));
        }
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;

        return gcd(b, a % b);
    }
}