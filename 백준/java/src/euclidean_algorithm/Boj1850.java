package euclidean_algorithm;

import java.io.*;
import java.util.*;

public class Boj1850 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong(), b = sc.nextLong();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(long i = 0; i < gcd(a, b); i++) {
            bw.write("1");
        }
        bw.flush();
    }

    private static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, (a % b));
    }
}
