package greedy;

public class Joystick {
    public static void main(String args[]) {
        System.out.println(solution("JEROEN"));
        System.out.println(solution("JAN"));
    }

    public static int solution(String name) {
        int answer = 0;
        int index;
        int len = name.length();
        int move = len - 1;

        for(int i = 0; i < name.length(); i++) {
            //상하
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i + 1;
            while(index < len && name.charAt(index) == 'A') index++;

            //커서
            move = Math.min(move, i * 2 + len - index);
            //처음부터 뒤로 가는 게 더 빠른 경우
            move = Math.min(move, (len - index) * 2 + i);
        }

        return answer + move;
    }
}
