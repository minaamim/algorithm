package hash;

import java.util.HashSet;

public class Pocketmon {

    public int solution(int[] nums) {
        int max = nums.length/2;

        HashSet<Integer> hash = new HashSet<>();

        for(int num : nums)
            hash.add(num);

        return hash.size() < max ? hash.size() : max;
    }

}
