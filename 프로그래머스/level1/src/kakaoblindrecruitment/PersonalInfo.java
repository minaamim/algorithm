package kakaoblindrecruitment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonalInfo {

    public static void main(String args[]) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        solution(today, terms, privacies);
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(String term : terms) {
            String[] str = term.split(" ");
            map.put(str[0], Integer.parseInt(str[1]));
        }

        for(int i = 0; i < privacies.length; i++) {
            String[] str = privacies[i].split(" ");
            if(getDate(today) >= getDate(str[0]) + map.get(str[1]) * 28)
                list.add(i+1);
        }

        answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
            System.out.print(list.get(i) + " ");
        }

        return answer;
    }

    static int getDate(String date) {
        String str[] = date.split("\\.");

        return Integer.parseInt(str[0]) * 12 * 28 + Integer.parseInt(str[1]) * 28 + Integer.parseInt(str[2]);
    }
}
