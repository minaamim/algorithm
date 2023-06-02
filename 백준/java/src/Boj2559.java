import java.io.*;
import java.util.*;

public class Boj2559 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int max = Integer.MIN_VALUE;

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

        for(int i = 0; i <= N - K; i++) {
            int temp = 0;
            for(int j = i; j < i + K; j++) temp += arr[j];

            max = Math.max(max, temp);
        }

        System.out.println(max);
    }
}
