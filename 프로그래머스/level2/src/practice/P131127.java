package practice;

import java.util.*;

public class P131127 {

    public static void main(String[] args) {

        String[] want1 = {"banana", "apple", "rice", "pork", "pot"};
        int[] number1 = {3, 2, 2, 2, 1};
        String[] discount1 = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        String[] want2 = {"apple"};
        int[] number2 = {10};
        String[] discount2 = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};

        System.out.println(solution(want1, number1, discount1));
        System.out.println(solution(want2, number2, discount2));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        boolean isIdentical = true;

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> shop = new HashMap<>();

        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for(int i = 0; i < 10; i++) {
            shop.put(discount[i], shop.getOrDefault(discount[i], 0) + 1);
        }

        for(String key : map.keySet()) {
           if(map.get(key) != shop.get(key)) {
               isIdentical = false;
               break;
           }
        }
        if(isIdentical) answer++;

        for(int day = 1; day < discount.length - 9; day++) {
            isIdentical = true;
            String previous = discount[day - 1];
            String next = discount[day + 9];

            if(shop.get(previous) == 1) shop.remove(previous);
            else shop.put(previous, shop.get(previous) - 1);
            shop.put(next, shop.getOrDefault(next, 0) + 1);

            for(String key : map.keySet()) {
                if(map.get(key) != shop.get(key)) {
                    isIdentical = false;
                    break;
                }
            }
            if(isIdentical) answer++;
        }
        return answer;
    }
}
