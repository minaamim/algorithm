package sorting;

import java.util.Arrays;

public class HIndex {

    public static void main(String args[]) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for(int i = 0; i < citations.length; i++) {
            //현재 인덱스의 인용수와 같거나 큰 논문 개수
            int h = citations.length - i;

            if(citations[i] >= h && i <= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }

    

}
