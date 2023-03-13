package hash;

import java.util.HashMap;

public class Disguise {

    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> clothesList = new HashMap<>();

        for(int i = 0; i < clothes.length; i++) {
            String clothesType = clothes[i][1];
            clothesList.put(clothesType, clothesList.getOrDefault(clothesType, 1) + 1);
        }

        for(String key : clothesList.keySet())
            answer *= clothesList.get(key);

        return answer - 1;
    }

}
