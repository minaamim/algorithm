package kakaoblind;

public class P60057 {

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
    }

    public static int solution(String s) {
        int answer = s.length();

        for(int i = 1; i <= s.length() / 2; i++) {
            int cnt = 1;
            StringBuilder sb = new StringBuilder();
            String base = s.substring(0, i);

            for(int j = i; j <= s.length(); j+=i) {
                int endIdx = Math.min(s.length(), j + i);
                String compare = s.substring(j, endIdx);

                if(compare.equals(base)) cnt++;
                else {
                    if(cnt > 1) sb.append(cnt);
                    sb.append(base);

                    base = compare;
                    cnt = 1;
                }
            }
            sb.append(base);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}
