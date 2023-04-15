package kakaoblind;

import java.util.*;

/**
 * 2018 kakao blind recruitment [1차]
 */
public class NewsClustering {

    public static void main(String args[]) {
        String str1 = "FRANCE";
        String str2 = "french";

        String str3 = "aa1+aa2";
        String str4 = "AAAA12";
        System.out.println(solution(str1, str2));
//        System.out.println(solution(str3, str4));
    }

    static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z'};

    public static int solution(String str1, String str2) {
        int answer = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for(int i = 0; i < str1.length() - 1; i++)
            list1.add(str1.substring(i, i+2));
        for(int i = 0; i < str2.length() - 1; i++)
            list2.add(str2.substring(i, i+2));

        List<String> removeList = new ArrayList<>();

        for(int i = 0; i < list1.size(); i++) {
            String str = list1.get(i);
            if(!check(str)) {
                removeList.add(str);
            }
        }

        list1.removeAll(removeList);
        removeList.clear();

        for(int i = 0; i < list2.size(); i++) {
            String str = list2.get(i);
            if(!check(str))
               removeList.add(str);
        }

        list2.removeAll(removeList);

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for(String str : list1)
            map1.put(str, map1.getOrDefault(str, 0) + 1);

        for(String str : list2)
            map2.put(str, map2.getOrDefault(str, 0) + 1);

        int same = 0, total;
        for(String firstKey : map1.keySet()) {

            for(String secondKey : map2.keySet()) {
                if(firstKey.equals(secondKey)) {
                    int num1 = map1.get(firstKey);
                    int num2 = map2.get(secondKey);

                    same += num1 < num2 ? num1 : num2;
                }
            }
        }

        total = list1.size() + list2.size() - same;

        double jackard;

        if(total == 0) jackard = 1;
        else jackard = (double) same / (double) total;

        answer = (int) (jackard * 65536);

        return answer;
    }

    static boolean check(String str) {
        boolean one = false, two = false;
        char ch1 = str.charAt(0);
        char ch2 = str.charAt(1);

         for(char alpha : alphabet) {
             if (ch1 == alpha)
                 one = true;
             if(ch2 == alpha)
                 two = true;
         }

        if(one == true && two == true)
            return true;
        return false;
    }

}
