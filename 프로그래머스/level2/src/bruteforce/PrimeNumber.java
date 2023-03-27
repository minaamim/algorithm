package bruteforce;

import java.util.HashSet;

public class PrimeNumber {

    static HashSet<Integer> set = new HashSet<>();
    static char[] ch;
    static boolean[] visited;

    public int solution(String numbers) {

        /**
         * 1. 만들 수 있는 조합 찾기
         * 2. 소수인지 판단하기
         */

        int answer = 0;
        ch = new char[numbers.length()];
        visited = new boolean[numbers.length()];

        for(int i = 0; i < numbers.length(); i++)
            ch[i] = numbers.charAt(i);

        answer = set.size();
        dfs("", 0);

        return answer;
    }

    void dfs(String str, int index) {
        int num;
        if(str!="") {
            num = Integer.parseInt(str);

            if(isPrime(num))
                set.add(num);
        }

        if(index == ch.length)
            return;

        for(int i = 0; i < ch.length; i++) {
            if(visited[i])
                continue;

            visited[i] = true;
            dfs(str + ch[i], index + 1);
            visited[i] = false;
        }


    }

    boolean isPrime(int num) {

        if(num == 0 || num == 1)
            return false;


        for(int i = 2; i <= Math.sqrt(num); i++) {

            if (num % i == 0)
                return false;

        }

        return true;
    }
}
