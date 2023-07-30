package kakaoblindrecruitment;

import java.util.*;

public class P92334 {

    public static void main(String[] args) {
        String[] id_list1 = {"muzi", "frodo", "apeach", "neo"};
        String[] report1 = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        solution(id_list1, report1, 2);

        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        solution(id_list2, report2, 3);
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        //순서
        Map<String, Integer> order = new HashMap<>();

        for(int i = 0; i < id_list.length; i++) order.put(id_list[i], i);


        Map<String, Set<String>> map = new HashMap<>();

        for(int i = 0; i < report.length; i++) {
            String[] str = report[i].split(" ");
            String user = str[0];
            String reportedUser = str[1];

            if(map.containsKey(reportedUser)) {
                if(!map.get(reportedUser).contains(user)) map.get(reportedUser).add(user);
            } else {
                map.put(reportedUser, new HashSet<>() {
                    {
                        add(user);
                    }
                });
            }
        }

        for(String key : map.keySet()) {
            if(map.get(key).size() >= k) {
                for(String user : map.get(key)) {
                    answer[order.get(user)]++;
                }
            }
        }

        return answer;
    }

}
