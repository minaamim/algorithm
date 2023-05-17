package codechallenge;

public class RepeatTransformation {
    public static void main(String args[]) {
        solution("110010101001");
        solution("01110");
        solution("1111111");
    }

    public static int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0, binaryCnt = 0;

        while (!s.equals("1")) {

            for(int i = 0; i < s.length(); i++) if(s.charAt(i) == '0') cnt++;


            s = s.replace("0", "");
            s = Integer.toBinaryString(s.length());
            binaryCnt++;
        }

        answer[0] = binaryCnt;
        answer[1] = cnt;

        return answer;
    }
}
