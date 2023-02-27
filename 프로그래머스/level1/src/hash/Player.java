package hash;

import java.util.HashMap;

public class Player {

    public String solution(String[] participant, String[] completion) {
        /**
         * participant = 참여한 선수들 이름
         * completion = 완주한 선수 이름
         */

        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<>();

        for(String name : participant)
            hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);

        for(String name : completion)
            hashMap.put(name, hashMap.get(name) - 1);

        for(String key : hashMap.keySet()) {
            if(hashMap.get(key) != 0) {
                answer = key;
                break;
            }
        }

        return answer;
    }

}
