package practiceproblem;

public class Substring {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();

        for(int i = 0; i <= t.length() - len; i++) {
            if(Long.parseLong(t.substring(i, i+len)) <= Long.parseLong(p))
                answer++;
        }
        return answer;
    }
}
