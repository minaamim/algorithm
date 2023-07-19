package practiceproblem;

import java.util.*;

public class P160586 {

    /**
     * 대충 만든 자판
     */

    public static void main(String args[]) {

        String[] keymap1 = {"ABACD", "BCEFD"};
        String[] targets1 = {"ABCD", "AABB"};
        String[] keymap2 = {"AA"};
        String[] targets2 = {"B"};
        String[] keymap3 = {"AGZ", "BSSS"};
        String[] targets3 = {"ASA", "BGZ"};


        solution(keymap1, targets1);
        solution(keymap2, targets2);
        solution(keymap3, targets3);

    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < keymap.length; i++) {
            for(int j = 0; j < keymap[i].length(); j++) {
                char target = keymap[i].charAt(j);
                if(!map.containsKey(target)) {
                    map.put(target, j + 1);
                } else {
                    int num = map.get(target);
                    map.put(target, num > j + 1 ? j + 1 : num);
                }
            }
        }

        for(int i = 0; i < targets.length; i++) {
            int cnt = 0;
            for(int j = 0; j < targets[i].length(); j++) {

                if(!map.containsKey(targets[i].charAt(j))) {
                    cnt = -1;
                    break;
                }

                cnt += map.get(targets[i].charAt(j));
            }
            answer[i] = cnt;
        }
        return answer;
    }

}
