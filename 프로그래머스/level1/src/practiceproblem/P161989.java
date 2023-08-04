package practiceproblem;

public class P161989 {

    public static void main(String[] args) {

    }

    public static int solution(int n, int m, int[] section) {
        int answer = 1;
        int idx = section[0];

        for(int i = 0; i < section.length; i++) {
            if (idx + m - 1 < section[i]) {
                answer++;
                idx = section[i];
            }
        }
        return answer;
    }

}
