package practice;

import java.util.*;

public class P152996 {

    public static void main(String[] args) {
        int[] weights = {100, 180, 360, 100, 270};

        System.out.println(solution(weights));
    }

    public static long solution(int[] weights) {
        long answer = 0;

        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();

        for(int i : weights) {
            double a = i * 1.0;
            double b = (i * 2) / 3.0;
            double c = i / 2.0;
            double d = (i * 3) / 4.0;

            if(map.containsKey(a)) answer += map.get(a);
            if(map.containsKey(b)) answer += map.get(b);
            if(map.containsKey(c)) answer += map.get(c);
            if(map.containsKey(d)) answer += map.get(d);
            map.put((i * 1.0), map.getOrDefault((i * 1.0), 0) + 1);
        }

        return answer;
    }
}
