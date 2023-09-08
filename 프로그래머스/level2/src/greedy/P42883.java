package greedy;

public class P42883 {

    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
    }

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int len = number.length() - k;
        int start = 0;

        while(start < number.length() && answer.length() != len) {
            int left = k + answer.length() + 1;
            int max = 0;
            for(int j = start; j < left; j++) {
                if(max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    start = j + 1;
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }
}
