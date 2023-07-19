package practice;

import java.util.*;

public class Tangerine {

    public static void main(String args[]) {
    }

    public int solution(int k, int[] tangerine) {
        /**
         * k = 한 상자에 담으려는 귤의 개수
         * tangerine = 귤의 크기를 담은 배열
         * answer = 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값
         */

        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        //귤 사이즈 별로 정리
        for(int i : tangerine)
            map.put(i, map.getOrDefault(i, 0) + 1);

        List<Integer> keyList = new ArrayList<>(map.keySet());

        keyList.sort(((o1, o2) -> map.get(o2) - map.get(o1)));

        int i = 0;
        while(k > 0) {
            k -= map.get(keyList.get(i));
            answer++;
            i++;
        }
        return answer;
    }


}
