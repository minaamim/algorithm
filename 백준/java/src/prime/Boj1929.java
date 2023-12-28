package prime;

import java.util.*;

public class Boj1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt(), end = sc.nextInt();

        boolean[] prime = new boolean[end + 1];

        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(end); i++) {
            if(prime[i]) continue;

            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        for(int i = start; i < prime.length; i++) {
            if (!prime[i]) {
                System.out.println(i);
            }
        }
    }
}
