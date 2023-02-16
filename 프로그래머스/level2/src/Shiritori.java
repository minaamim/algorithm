import java.util.ArrayList;
import java.util.List;

public class Shiritori {
    public int[] solution(int n, String[] words) {

        /**
         * 가장 먼저 탈락하는 사람의 번호와 몇 번째 차례에 탈락하는지 return
         * 중복되는 단어나 끝말로 시작하지 않을 시 탈락
         */

        int[] answer = new int[2];

        List<String> arr = new ArrayList<>();
        answer[0] = 0;
        answer[1] = 0;

        arr.add(words[0]);

        for(int i = 1; i < words.length; i++) {

            String now = words[i];
            String previous = words[i - 1];

            if(arr.contains(now) || now.charAt(0) != previous.charAt(previous.length() - 1)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }

            arr.add(now);
        }
        return answer;
    }
}
