package bruteforce;

import java.util.HashSet;

public class PrimeNumber {

    static char[] ch;
    static boolean[] visited;
    static HashSet<Integer> hash;

    public static void main(String args[]) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        int answer = 0;
        ch = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        hash = new HashSet<>();

        for (int i = 0; i < numbers.length(); i++) ch[i] = numbers.charAt(i);

        dfs("", 0);
        answer = hash.size();
        return answer;
    }

    static void dfs(String str, int index) {
        int num;

        if(str != "") {
            num = Integer.parseInt(str);
            if(isPrime(num)) hash.add(num);
        }

        if(index == ch.length) return;

        for(int i = 0; i < ch.length; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            dfs(str + ch[i], index + 1);
            visited[i] = false;
        }
    }

    static boolean isPrime(int num) {
        if(num == 0 || num == 1) return false;

        for(int i = 2; i <= Math.sqrt(num); i++) if(num % i == 0) return false;

        return true;
    }

}
