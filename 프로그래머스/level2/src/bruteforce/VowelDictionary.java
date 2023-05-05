package bruteforce;

public class VowelDictionary {

    static final String MAPPING = "AEIOU";
    static final int[] RATE_OF_INCREASE = {781, 156, 31, 6, 1};

    public static void main(String args[]) {
        System.out.println(solution("AAAAE"));
        System.out.println(solution("AAAE"));
        System.out.println(solution("I"));
        System.out.println(solution("EIO"));
    }

    public static int solution(String word) {
        int answer = word.length();

        for(int i = 0; i < word.length(); i++)
            answer += (RATE_OF_INCREASE[i] * MAPPING.indexOf(word.charAt(i)));

        return answer;
    }

}
