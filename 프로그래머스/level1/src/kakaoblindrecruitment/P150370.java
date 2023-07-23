package kakaoblindrecruitment;

import java.util.*;

public class P150370 {

    public static void main(String args[]) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        solution(today, terms, privacies);
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        Set<Integer> set = new TreeSet<>();
        Map<String, Integer> map = new HashMap<>();

        int now = getDate(today);

        for(String term: terms) {
            String[] str = term.split(" ");
            map.put(str[0], Integer.parseInt(str[1]));
        }

        for(int i = 0; i < privacies.length; i++) {
            String[] temp = privacies[i].split(" ");
            String term = temp[1];
            int plus = map.get(term) * 28;

            if(now >= getDate(temp[0]) + plus) {
                set.add(i + 1);
            }
        }

        answer = new int[set.size()];
        int index = 0;
        for(Integer ans : set) answer[index++] = ans;

        return answer;
    }

    private static int getDate(String str) {
        String[] date = str.split("\\.");

        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);

        return year * 12 * 28 + month * 28 + day;
    }
}
