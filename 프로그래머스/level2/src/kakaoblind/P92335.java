package kakaoblind;

import java.util.*;

public class P92335 {

    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
        System.out.println(solution(110011, 10));
    }

    public static int solution(int n, int k) {
        int answer = 0;

        String num = Integer.toString(n, k);

        String[] arr = num.split("0");

        for(int i = 0; i < arr.length; i++) {
            if(arr[i].isEmpty()) continue;
            if(isPrime(Long.parseLong(arr[i]))) answer++;
        }
        return answer;
    }

    private static boolean isPrime(long num) {

        if(num == 1 || num == 0) return false;

        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }

        return true;
    }
}
