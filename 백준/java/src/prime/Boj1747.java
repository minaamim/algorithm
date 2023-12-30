package prime;

import java.util.*;

public class Boj1747 {

    private static int MAX = 10000001;
    private static boolean[] primes = new boolean[MAX];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        solution(N);
    }

    private static void solution(int N) {
        getPrimes();

        for(int i = N; i < primes.length; i++) {
            if(!primes[i]) {
                if(isPalindrome(i)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    private static void getPrimes() {
        primes[0] = primes[1] = true;

        for(int i = 2; i <= Math.sqrt(MAX - 1); i++) {
            if(primes[i]) continue;

            for(int j = i + i; j < primes.length; j += i) {
                primes[j] = true;
            }
        }
    }

    private static boolean isPalindrome(int target) {
        char[] num = String.valueOf(target).toCharArray();

        int s = 0, e = num.length - 1;

        while(s < e) {
            if(num[s] != num[e]) return false;
            s++;
            e--;
        }
        return true;
    }
}
