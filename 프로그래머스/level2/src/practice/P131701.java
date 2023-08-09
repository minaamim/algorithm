package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P131701 {
    public static void main(String[] args) {
        int[] elements = {7, 9, 1, 1, 4};
        System.out.println(solution(elements));
    }


    public static int solution(int[] elements) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int i : elements) {
            list.add(i);
        }
        list.addAll(list);
        list.remove(list.size() - 1);

        for(int i = 0; i < elements.length; i++) {
            int sum = 0;
            for(int j = i; j < elements.length + i; j++) {
                sum += list.get(j);
                set.add(sum);
            }
        }
        return set.size();
    }
}
