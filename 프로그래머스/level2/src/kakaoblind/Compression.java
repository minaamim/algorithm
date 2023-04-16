package kakaoblind;

import java.util.ArrayList;
import java.util.List;

/**
 * 2018 kakao blind recruitment 3차
 */
public class Compression {

    public static void main(String args[]) {
        solution("KAKAO");
        solution("TOBEORNOTTOBEORTOBEORNOT");
        solution("ABABABABABABABAB");
    }

    public static int[] solution(String msg) {
        int[] answer;

        List<String> dictionary = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Character ch = 'A';

        for (int i = 0; i < 26; i++, ch++) dictionary.add(ch.toString());

        for (int i = 0; i < msg.length(); i++) {
            Character w, c;
            w = msg.charAt(i);
            String word = w.toString();

            if(i == msg.length() - 1) {
                list.add(dictionary.indexOf(word) + 1);
            }

            for (int j = i + 1; j < msg.length(); j++) {
                c = msg.charAt(j);
                word += c.toString();

                if (dictionary.contains(word)) {
                    i = j;
                    if(i == msg.length() - 1) {
                        list.add(dictionary.indexOf(word) + 1);
                    }
                    continue;
                }

                dictionary.add(word);

                list.add(dictionary.indexOf(word.substring(0, word.length() - 1)) + 1);
                break;
            }
        }
        answer = new int[list.size()];

        int i = 0;
        for (int ans : list) {
            answer[i] = ans;
            i++;
        }

        return answer;
        }


}
