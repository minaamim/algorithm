package practiceproblem;

import java.util.HashMap;
import java.util.Map;

public class P178871 {
    public static void main(String args[]) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        solution(players, callings);
    }

    public static String[] solution(String[] players, String[] callings) {

        Map<String, Integer> rankMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) rankMap.put(players[i], i);

        for(String player : callings) {
            int rank = rankMap.get(player);
            String before = players[rank - 1];

            players[rank - 1] = player;
            players[rank] = before;

            rankMap.put(player, rank - 1);
            rankMap.put(before, rank);
        }
        return players;
    }
}
