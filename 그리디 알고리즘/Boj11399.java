package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Boj11399 {
    static int N;
    static int[] arr;

    public static void main(String args[]) {

        int result = 0;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            result += arr[i] * (N-i);
        }

        System.out.println(result);
    }



}
