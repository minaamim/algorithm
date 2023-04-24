package summerwintercoding;

import java.util.HashMap;
import java.util.Map;

public class SkillTree {
    public static void main(String args[]) {
        String skill1 = "CBD";
        String[] sillTrees1 = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill1, sillTrees1));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(int i = 0; i < skill_trees.length; i++) {
            boolean temp = true;

            Map<Character, Integer> map = new HashMap<>();
            int check = 0;
            for(int j = 0; j < skill_trees[i].length(); j++) {
                Character now = skill_trees[i].charAt(j);

                if (skill.contains(now.toString())) {
                    map.put(now, check);
                    check++;
                }
            }

            for(Character ch : map.keySet()) {
                if(map.get(ch) != skill.indexOf(ch)) temp = false;
            }
            if(temp) answer++;
        }

        return answer;
    }

}
