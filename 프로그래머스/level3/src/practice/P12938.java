package practice;

public class P12938 {

    public static void main(String[] args) {
        solution(2, 9);
        solution(2, 1);
        solution(2, 8);
    }

    public static int[] solution(int n, int s) {
        int[] answer;

        if(n > s) {
            answer = new int[]{-1};
            return answer;
        }
        answer = new int[n];

        int init = s / n;
        int mod = s % n;

        for(int i = 0; i < n; i++) answer[i] = init;

        int idx = n - 1;
        for(int i = 0; i < mod; i++) {
            answer[idx]++;
            idx--;
        }

        return answer;
    }



}
