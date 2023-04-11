package kakaotechinternship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 2019 카카오 개발자 겨울 인턴십
 */
public class Tuple {

    public static void main(String args[]) {
//        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        solution(s);
    }

    public static ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        String[] num = s.split("},");

        for(int i = 0; i < num.length; i++) {
            num[i] = num[i].replace("{", "");
            num[i] = num[i].replace("}", "");
        }

        Arrays.sort(num, Comparator.comparingInt(String::length));

        for(int i = 0; i < num.length; i++) {
            String n[] = num[i].split(",");
            for(String str : n) {
                int temp = Integer.parseInt(str);
                if(!answer.contains(temp)) {
                    answer.add(temp);
                }
            }
        }
        return answer;
    }
}
