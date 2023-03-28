package dfsbfs;

public class WordConversion {

    int answer = 51;
    boolean[] visited;

    public int solution(String begin, String target, String[] words) {

        visited = new boolean[words.length];

        dfs(begin, target, 0, words);

        return answer == 51 ? 0 : answer;
    }

    void dfs(String now, String target, int cnt, String[] words) {

        if(now.equals(target)) {
            answer = answer > cnt ? cnt : answer;
            return;
        }

        for(int i = 0; i < words.length; i++) {
            if(!visited[i] && check(now, words[i])) {
                visited[i] = true;

                dfs(words[i], target, cnt + 1, words);
                visited[i] = false;
            }
        }

    }

    boolean check(String now, String next) {

        int count = 0;

        for(int i = 0; i < now.length(); i++) {
            if(now.charAt(i) != next.charAt(i))
                count++;
        }

        return count == 1 ? true : false;
    }

}
