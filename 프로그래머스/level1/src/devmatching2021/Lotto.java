package devmatching2021;

public class Lotto {

    public static void main(String[] args) {
//        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] lottos = {0,0,0,0,0,0};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        solution(lottos, win_nums);
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] winner = {7, 6, 5, 4, 3, 2, 1};
        int cnt = 0;
        int zero = 0;

        for(int lotto: lottos) {
            for(int i : win_nums) {
                if(lotto == i)
                    cnt++;
            }

            if(lotto == 0)
                zero++;
        }

        for(int i = 1; i < winner.length; i++) {

            int total = cnt+zero;

            if(total == 0 || total == 1)
                answer[0] = 6;
            if(cnt == 0 || cnt == 1)
                answer[1] = 6;


            if(total == winner[i])
                answer[0] = i;

            if(cnt == winner[i])
                answer[1] = i;

        }

        return answer;
    }
}
