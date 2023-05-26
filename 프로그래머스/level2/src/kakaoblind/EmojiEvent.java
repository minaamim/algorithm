package kakaoblind;

import java.util.*;

public class EmojiEvent {

    public static void main(String args[]) {
        int[][] user1 = {{40, 10000}, {25, 10000}};
        int[][] user2 = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};

        int[] emoticon1 = {7000, 9000};
        int[] emoticon2 = {1300, 1500, 1600, 4900};

        solution(user1, emoticon1);
        solution(user2, emoticon2);

    }

    static class Emoji {
        double price;
        double rate;

        Emoji(double price, double rate) {
            this.price = price;
            this.rate = rate;
        }
    }

    static double[] sales = {0.1, 0.2, 0.3, 0.4};
    static List<Emoji> emojis = new ArrayList<>();
    static int maxJoin = Integer.MIN_VALUE;
    static int maxPrice = Integer.MAX_VALUE;

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        recursion(0, users, emoticons);

        answer[0] = maxJoin;
        answer[1] = maxPrice;

        System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }

    static void recursion(int depth, int[][] users, int[] emoticons) {

        if(depth == emoticons.length) {
            int total = 0, join = 0;

            for(int i = 0; i < users.length; i++) {
                int userRate = users[i][0];
                int userMax = users[i][1];

                int sum = 0;

                for(int j = 0; j < emojis.size(); j++) {
                    Emoji emoji = emojis.get(j);
                    double emojiPrice = emoji.price;
                    double emojiRate = emoji.rate;

                    if(emojiRate >= userRate) sum += emojiPrice;
                }

                if (sum >= userMax) join++;
                else total += sum;

                if(maxJoin < join) {
                    maxPrice = total;
                    maxJoin = join;
                } else if(maxJoin == join && maxPrice < total) maxPrice = total;
            }
            return;
        }

        for(int i = 0; i < sales.length; i++) {
            emojis.add(new Emoji((1 - sales[i]) * emoticons[depth], 100 * sales[i]));
            recursion(depth + 1, users, emoticons);
            emojis.remove(emojis.size() - 1);
        }
    }
}
