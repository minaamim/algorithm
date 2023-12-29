package prime;

import java.util.*;

public class Boj1456 {

    static boolean arr[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Long A = sc.nextLong(), B = sc.nextLong();
        solution(A, B);
    }

    private static void solution(Long A, Long B) {
        int cnt = 0;
        getPrime(B);

        for(long i = 2; i < arr.length; i++) {
            if(!arr[(int) i]) {
                long prime = i;
                while((double) prime <= (double) B / (double) i) {
                    if((double) prime >= (double) A / (double) i) cnt++;
                    prime *= i;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void getPrime(Long limit) {
        //false == prime
        arr = new boolean[(int) Math.ceil(Math.sqrt(limit)) + 1];
        arr[0] = arr[1] = true;

        for(int i = 2; i <= Math.sqrt(limit); i++) {
            if(arr[i]) continue;

            for(int j = i + i; j < arr.length; j += i) {
                arr[j] = true;
            }
        }
    }
}