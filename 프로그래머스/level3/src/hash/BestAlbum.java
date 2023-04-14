package hash;

import java.util.*;

public class BestAlbum {

    public static void main(String args[]) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        solution(genres, plays);
    }


    public static int[] solution(String[] genres, int[] plays) {
        int[] answer;

        ArrayList<String> rank = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();

        for(int i = 0; i < genres.length; i++)
            count.put(genres[i], count.getOrDefault(genres[i], 0) + plays[i]);

        //장르 선택 내림차순
        while(count.size() != 0) {
            int max = -1;
            String maxKey = "";
            for (String key : count.keySet()) {
                if(max < count.get(key)) {
                    max = count.get(key);
                    maxKey = key;
                }
            }
            rank.add(maxKey);
            count.remove(maxKey);
        }

        //곡 선택
        ArrayList<Music> result = new ArrayList<>();

        for(String genre : rank) {
            ArrayList<Music> list = new ArrayList<>();

            for(int i = 0; i < genres.length; i++) {
                if(genres[i].equals(genre)) {
                    list.add(new Music(i, genre, plays[i]));
                }
            }

            Collections.sort(list, (o1, o2) -> o2.playNum - o1.playNum);

            result.add(list.get(0));

            if(list.size() != 1)
                result.add(list.get(1));
        }

        answer = new int[result.size()];

        for(int i = 0; i < result.size(); i++)
            answer[i] = result.get(i).index;

        return answer;
    }

    static class Music {
        int index;
        String genre;
        int playNum;

        public Music(int index, String genre, int playNum) {
            this.index = index;
            this.genre = genre;
            this.playNum = playNum;
        }
    }
}
