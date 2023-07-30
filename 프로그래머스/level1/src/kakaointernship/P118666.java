package kakaointernship;

import java.util.*;

public class P118666 {

    public static void main(String[] args) {
        String[] survey1 = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choice1 = {5, 3, 2, 7, 5};
        String[] survey2 = {"TR", "RT", "TR"};
        int[] choice2 = {7, 1, 3};

        System.out.println(solution(survey1, choice1));
        System.out.println(solution(survey2, choice2));
    }

    public static String solution(String[] survey, int[] choices) {

        Map<Character, Integer> map = new HashMap<>();
        String str = "RTCFJMAN";
        for(char ch : str.toCharArray()) map.put(ch, 0);

        for(int i = 0; i < choices.length; i++) {

            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);

            switch (choices[i]) {
                case 1:
                    map.put(first, map.getOrDefault(first, 0) + 3);
                    break;
                case 2:
                    map.put(first, map.getOrDefault(first, 0) + 2);
                    break;
                case 3:
                    map.put(first, map.getOrDefault(first, 0) + 1);
                    break;
                case 4:
                    break;
                case 5:
                    map.put(second, map.getOrDefault(second, 0) + 1);
                    break;
                case 6:
                    map.put(second, map.getOrDefault(second, 0) + 2);
                    break;
                case 7:
                    map.put(second, map.getOrDefault(second, 0) + 3);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(map.get('R') >= map.get('T') ? 'R' : 'T');
        sb.append(map.get('C') >= map.get('F') ? 'C' : 'F');
        sb.append(map.get('J') >= map.get('M') ? 'J' : 'M');
        sb.append(map.get('A') >= map.get('N') ? 'A' : 'N');

        return sb.toString();
    }


}
