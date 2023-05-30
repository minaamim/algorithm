package kakaoblindrecruitment;

import java.util.HashMap;
import java.util.Map;

public class Personality {
    public static void main(String args[]) {
        String[] survey1 = {"AN", "CF", "MJ", "RT", "NA"};
        String[] survey2 = {"TR", "RT", "TR"};
        int[] choices1 = {5, 3, 2, 7, 5};
        int[] choices2 = {7, 1, 3};
        System.out.println(solution(survey1, choices1));
        System.out.println(solution(survey2, choices2));
    }

    public static String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < survey.length; i++) {
            char negative = survey[i].charAt(0);
            char positive = survey[i].charAt(1);

            switch (choices[i]) {
                case 1:
                    map.put(negative, map.getOrDefault(negative, 0) + 3);
                    break;
                case 2:
                    map.put(negative, map.getOrDefault(negative, 0) + 2);
                    break;
                case 3:
                    map.put(negative, map.getOrDefault(negative, 0) + 1);
                    break;
                case 5:
                    map.put(positive, map.getOrDefault(positive, 0) + 1);
                    break;
                case 6:
                    map.put(positive, map.getOrDefault(positive, 0) + 2);
                    break;
                case 7:
                    map.put(positive, map.getOrDefault(positive, 0) + 3);
                    break;
            }
        }

        answer.append(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T');
        answer.append(map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F');
        answer.append(map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M');
        answer.append(map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N');

        return answer.toString();
    }


}
