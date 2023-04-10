package kakaointernshipp2021;

public class NumericStrings {

    public static void main(String args[]) {
        solution("one4seveneight");
    }

    public static int solution(String s) {
        int answer = 0;

        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < num.length; i++) {
            s = s.replace(num[i], Integer.toString(i));
        }
        answer = Integer.parseInt(s);
        System.out.println(answer);
        return answer;
    }

}
