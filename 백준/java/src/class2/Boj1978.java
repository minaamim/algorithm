package class2;

import java.util.*;
import java.io.*;

public class Boj1978 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            if(solution(Integer.parseInt(st.nextToken()))) answer++;
        }
        System.out.println(answer);
    }

    private static boolean solution(int num) {
        if(num == 1) return false;

        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
