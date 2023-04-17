package kakaoblind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2019 kakao blind recruitment
 */

public class OpenChat {
    public static void main(String args[]) {
        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };

        solution(record);
    }

    public static String[] solution(String[] record) {
        String[] answer = {};

        Map<String, String> nickname = new HashMap<>();
        List<String[]> records =new ArrayList<>();

        for(String str : record) {
            String[] temp = str.split(" ");

            switch(temp[0]) {
                case "Enter" :
                    nickname.put(temp[1], temp[2]);
                    records.add(new String[]{temp[1], temp[0]});
                    break;

                case "Leave" :
                    records.add(new String[]{temp[1], temp[0]});
                    break;

                case "Change" :
                    nickname.replace(temp[1], temp[2]);
                    break;
            }
        }

        List<String> ans = new ArrayList<>();

        for(int i = 0; i < records.size(); i++) {
            String uid = records.get(i)[0];
            String inOut = records.get(i)[1];

            String nick = nickname.get(uid);

            if(inOut.equals("Enter")) ans.add(nick + "님이 들어왔습니다.");
            else if(inOut.equals("Leave")) ans.add(nick + "님이 나갔습니다.");
        }


        answer = new String[ans.size()];

        int i = 0;
        for(String s : ans) {
            answer[i] = s;
            i++;
        }

        return answer;
    }

}
