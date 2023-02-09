import java.util.Scanner;

public class Blackjack {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int result = solution(arr, N, M);
        System.out.println(result);

    }

    static int solution(int[] arr, int N, int M) {
        int result = 0;

        for(int i = 0; i < N-2; i++) {
            for(int j = i+1; j < N-1; j++) {
                for(int k = j+1; k < N; k++) {
                    int temp = arr[i] + arr[j] + arr[k];

                    if(temp == M)
                        return temp;

                    if(result < temp && temp < M) {
                        result = temp;
                    }
                }
            }
        }

        return result;
    }

}
