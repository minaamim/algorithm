package greedy;

import java.util.Scanner;

public class Boj11047 {

    static int N, K;
    static Integer[] arr;
    static int sum = 0, count = 0;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new Integer[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        System.out.println(solution());
    }

    public static int solution() {

        for(int i = N - 1; i >= 0; i--) {
            if(arr[i] <= K) {
                count += K / arr[i];
                K = K % arr[i];
            }
        }

        return count;
    }
}
