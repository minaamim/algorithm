package greedy;

import java.util.Arrays;

public class Lifeboat {
    public int solution(int[] people, int limit) {
        /**
         * people = 사람들 몸무게
         * limit = 몸무게 무게 제한
         * 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값 return
         */
        int answer = 0;

        //오름차순 정렬
        Arrays.sort(people);

        int min = 0;

        for(int max = people.length - 1; max >= min; max--) {
            if(people[min] + people[max] <= limit)
                min++;
            answer++;
        }

        return answer;
    }
}
