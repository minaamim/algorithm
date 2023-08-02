package kakaoblind;

import java.util.*;

public class P150368 {

    public static void main(String[] args) {
        int[][] user = {
                {40, 10000},
                {25, 10000}
        };

        int[] emoticon = {7000, 9000};

        solution(user, emoticon);
    }

    static double[] discountRate = {0.4, 0.3, 0.2, 0.1};
    static List<Emoji> emojis = new ArrayList<>();
    static int maxJoin = Integer.MIN_VALUE;
    static int maxPrice = Integer.MIN_VALUE;

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        dfs(0, users, emoticons);

        answer[0] = maxJoin;
        answer[1] = maxPrice;

        System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }

    static void dfs(int depth, int[][] users, int[] emoticons) {

        if(depth == emoticons.length) {

            int join = 0;
            int total = 0;

            for(int i = 0; i < users.length; i++) {
                int sale = users[i][0];
                int price = users[i][1];
                int sum = 0;

                for(Emoji emoji : emojis) if(emoji.rate >= sale) sum += emoji.price;

                if(sum >= price) join++;
                else total += sum;
            }

            if(join > maxJoin) {
                maxJoin = join;
                maxPrice = total;
            } else if (join == maxJoin && maxPrice < total) maxPrice = total;

            return;
        }


        for(int i = 0; i < discountRate.length; i++) {
            emojis.add(new Emoji(emoticons[depth] * (1 - discountRate[i]), discountRate[i] * 100));
            dfs(depth + 1, users, emoticons);
            emojis.remove(emojis.size() - 1);
        }
    }

    static class Emoji {
        double price;
        double rate;

        Emoji(double price, double rate) {
            this.price = price;
            this.rate = rate;
        }
    }
}
