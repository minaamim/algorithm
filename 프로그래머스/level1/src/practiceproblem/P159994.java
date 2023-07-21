package practiceproblem;

import java.util.*;

public class P159994 {

    public static void main(String args[]) {
        String[] card1 = {"i", "drink", "water"};
        String[] card2 = {"want", "to"};
        String[] goal = {
                "i", "want", "to", "drink", "water"
        };

        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal2 = {"i", "want", "to", "drink", "water"};

        System.out.println(solution(card1, card2, goal));
        System.out.println(solution(cards1, cards2, goal));
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";

        int index1 = 0, index2 = 0;

        for(int i = 0; i < goal.length; i++) {

            if(index1 < cards1.length && cards1[index1].equals(goal[i])) index1++;
            else if(index2 < cards2.length && cards2[index2].equals(goal[i])) index2++;
            else break;

            if(i == goal.length - 1) return "Yes";
        }
        return answer;
    }
}
