package task;

import java.io.*;
import java.util.*;

public class Coin {
    public static void main(String[] args) throws IOException {
        int[] coins1 = {1, 2, 3};
        int[] coins2 = {2, 5, 3, 6};
        System.out.println(solution(coins1, 4));
        System.out.println(solution(coins2, 10));
    }

    private static int[] coins;
    private static int total, ans;

    private static long solution(int[] target, int sum) {
        coins = target;
        total = sum;
        ans = 0;
        List<Integer> comb = new ArrayList<>();
        combination(0, 0, comb);
        return ans;
    }



    private static void combination(int idx, int sum, List<Integer> comb) {
        if(sum > total) return;

        if(sum == total) {
            ans++;
            System.out.println(comb.toString());
            return;
        }

        for(int i = idx; i < coins.length; i++) {
            sum += coins[i];
            comb.add(coins[i]);
            combination(i, sum, comb);
            sum -= coins[i];
            comb.remove(comb.size() - 1);
        }
    }
}
