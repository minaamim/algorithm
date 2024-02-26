package dp;

import java.util.*;

public class Re1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D[] = new int[N + 1];
        for(int i = 2; i <= N; i++) {
            D[i] = D[i - 1] + 1;
            if(i % 2 == 0) D[i] = Math.min(D[i], D[i/2] + 1);
            if(i % 3 == 0) D[i] = Math.min(D[i], D[i/3] + 1);
        }
        System.out.println(D[N]);
    }
}
