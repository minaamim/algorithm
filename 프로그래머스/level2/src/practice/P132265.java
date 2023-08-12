package practice;

import java.util.*;

public class P132265 {

    public static void main(String[] args) {
        int[] toppings1 = {1, 2, 1, 3, 1, 4, 1, 2};
        int[] toppings2 = {1, 2, 3, 1, 4};

        System.out.println(solution(toppings1));
        System.out.println(solution(toppings2));
    }

    public static int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for(int t : topping) {
            right.put(t, right.getOrDefault(t, 0) + 1);
        }

        for(int t : topping) {
            left.put(t, left.getOrDefault(t, 0) + 1);

            if(right.get(t) == 1) right.remove(t);
            else right.put(t, right.get(t) - 1);

            if(left.size() == right.size()) answer++;
        }
        return answer;
    }
}
