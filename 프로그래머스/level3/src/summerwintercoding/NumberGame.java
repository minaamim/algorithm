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

        List<Integer> list = new ArrayList<>();

        for(int i : B) list.add(i);

        list.sort((o1, o2) -> o1 - o2);

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < list.size(); j++) {

                if(list.get(j) > A[i]) {
                    answer++;
                    list.remove(j);
                    break;
                }
            }
        }
        return answer;
    }

}
