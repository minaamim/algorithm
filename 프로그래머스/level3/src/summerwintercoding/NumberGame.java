package summerwintercoding;

import java.util.*;

public class NumberGame {

    public static void main(String args[]) {

        int[] A1 = {5, 1, 3, 7};
        int[] B1 = {2, 2, 6, 8};
        int[] A2 = {2, 2, 2, 2,};
        int[] B2 = {1, 1, 1, 1};

        System.out.println(solution(A1, B1));
        System.out.println(solution(A2, B2));

    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int b = B.length - 1;
        for(int i = A.length - 1; i >= 0; i--) {
           if(B[b] > A[i]) {
               answer++;
               b--;
           }
        }
        return answer;
    }

}
