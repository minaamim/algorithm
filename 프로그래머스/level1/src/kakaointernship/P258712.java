package kakaointernship;

import java.io.*;
import java.util.*;

public class P258712 {

    public static void main(String[] args) throws IOException {
        String[] friends1 = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts1 = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan",
                "neo muzi"};

        String[] friends2 = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts2 = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro",
                "alessandro david"};

        String[] friends3 = {"a", "b", "c"};
        String[] gifts3 = {"a b", "b a", "c a", "a c", "a c", "c a"};

        System.out.println(solution(friends1, gifts1));
        System.out.println(solution(friends2, gifts2));
        System.out.println(solution(friends3, gifts3));
    }
    public static int solution(String[] friends, String[] gifts) throws IOException {
        int answer = 0;

        Map<String, HashMap<String, Integer>> record = new HashMap<>();
        Map<String, Integer> index = new HashMap<>();
        Map<String, Integer> score = new HashMap<>();

        for(int i = 0; i < friends.length; i++) {
            String name = friends[i];
            record.put(name, new HashMap<>(){{
                for(int j = 0; j < friends.length; j++) {
                    if(friends[j].equals(name)) continue;
                    put(friends[j], 0);
                }
            }});
            index.put(name, 0);
        }

        for(int i = 0; i < gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            String presenter = gift[0];
            String recipient = gift[1];

            record.get(recipient).replace(presenter, record.get(recipient).getOrDefault(presenter, 0) + 1);

            index.replace(presenter, index.getOrDefault(presenter, 0) + 1);
            index.replace(recipient, index.getOrDefault(recipient, 0) - 1);
        }

        for(int i = 0; i < friends.length; i++) {
            String me = friends[i];
            for(String you : record.keySet()) {
                if(me.equals(you)) continue;

                if(record.get(you).get(me) > record.get(me).get(you)) {
                    score.put(me, score.getOrDefault(me, 0) + 1);
                } else if(record.get(you).get(me) == record.get(me).get(you)){
                    if(index.get(me) > index.get(you)) {
                        score.put(me, score.getOrDefault(me, 0) + 1);
                    }
                }
            }
        }

        for(String key : score.keySet()) {
            if (answer < score.get(key)) {
                answer = score.get(key);
            }
        }
        return answer;
    }
}