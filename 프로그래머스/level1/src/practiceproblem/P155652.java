package practiceproblem;

import java.util.HashSet;
import java.util.Set;

public class P155652 {

    public static void main(String args[]) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

        String s1 = "ybc";
        String skip1 = "az";
        int index1 = 1;

//        System.out.println(solution(s, skip, index));
        System.out.println(solution(s1, skip1, index1));
    }

    public static String solution(String s, String skip, int index) {

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            for(int j = 0; j < index; j++) {
                now++;
                if(now > 'z') now -= 26;
                if(skip.contains(String.valueOf(now))) j--;
            }
            sb.append(now);
        }
        return sb.toString();
    }
}
