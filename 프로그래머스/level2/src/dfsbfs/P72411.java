package dfsbfs;

import java.util.*;

public class P72411 {

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        String[] answer = solution(orders, course);
        for(String str : answer) System.out.println(str);
    }

    static Map<String, Integer> map;

    public static String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();
        String[] answer;

        for(String o : orders) {
            char[] order = o.toCharArray();
            Arrays.sort(order);

            for (int i = 0; i < course.length; i++) dfs(0, 0, course[i], order, "");
        }

        int[] max = new int[course[course.length - 1] + 1];

        for(String key : map.keySet()) {
            if(map.get(key) >= 2) max[key.length()] = Math.max(map.get(key), max[key.length()]);
        }

        List<String> temp = new ArrayList<>();
        for(String key : map.keySet()) {
            for(int i = 0; i < max.length; i++) {
                if(max[i] == 0) continue;
                if(key.length() == i && map.get(key) == max[i]) temp.add(key);
            }
        }

        Collections.sort(temp);
        answer = new String[temp.size()];
        int i = 0;
        for(String str : temp) answer[i++] = str;

        return answer;
    }

    private static void dfs(int cnt, int start, int limit, char[] order, String result) {
        if(cnt == limit) {
            map.put(result, map.getOrDefault(result, 0) + 1);
            return;
        }

        for (int i = start; i < order.length; i++)
            dfs(cnt+1, i+1, limit, order, result+order[i]);
    }
}
