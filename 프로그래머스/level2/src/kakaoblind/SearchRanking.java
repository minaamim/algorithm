package kakaoblind;

import java.util.*;

/**
 * 2021 kakao blind recruitment
 */

public class SearchRanking {

    public static void main(String args[]) {
        String[] info = {
                "java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"
        };

        String[] query = {
                "java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"
        };

        solution(info, query);
    }

    static Map<String, ArrayList<Integer>> map = new HashMap<>();
    static ArrayList<Integer> scoreList = new ArrayList<>();

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for(int i = 0; i < info.length; i++) dfs(0, "", info[i].split(" "));

        //점수 순 정렬
        for(ArrayList<Integer> list : map.values()) Collections.sort(list);

        for(int i = 0; i < query.length; i++) {
            String[] condition = query[i].split(" and ");

            String[] score = condition[3].split(" ");

            int targetScore = Integer.parseInt(score[1]);
            condition[3] = score[0];

            String key = String.join("", condition);

            if(map.containsKey(key)) {
                ArrayList<Integer> list = map.get(key);
                int start = 0;
                int end = list.size() - 1;

                while(start <= end) {
                    int mid = (start + end) / 2;

                    if(list.get(mid) < targetScore) start = mid + 1;
                    else end = mid - 1;

                    answer[i] = list.size() - start;
                }
            }
        }
        return answer;
    }

    //나올 수 있는 query와 점수 list
    static void dfs(int depth, String query, String[] info) {
        if(depth == 4) {
            if(!map.containsKey(query)) {
                scoreList = new ArrayList<>();
                scoreList.add(Integer.parseInt(info[4]));
                map.put(query, scoreList);
            } else map.get(query).add(Integer.parseInt(info[4]));
            return;
        }

        dfs(depth + 1, query + "-", info);
        dfs(depth + 1, query + info[depth], info);
    }


}
