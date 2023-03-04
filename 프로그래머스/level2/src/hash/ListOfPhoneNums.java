package hash;

import java.util.HashSet;

public class ListOfPhoneNums {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashSet<String> nums = new HashSet<>();

        for(String num : phone_book)
            nums.add(num);

        for(String s : phone_book) {
            for(int i = 1; i < s.length(); i++) {
                if(nums.contains(s.substring(0, i)))
                    return false;
            }
        }

        return answer;
    }

}
