package practiceproblem;

import java.util.*;

public class P131128 {

    public static void main(String args[]) {
        System.out.println(solution("100", "2345"));
        System.out.println(solution("100", "203045"));
        System.out.println(solution("100", "123450"));
        System.out.println(solution("12321", "42531"));
        System.out.println(solution("5525", "1255"));
    }

    public static String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];
        StringBuilder sb = new StringBuilder();

        for(String x : X.split("")) countX[Integer.parseInt(x)]++;
        for(String y : Y.split("")) countY[Integer.parseInt(y)]++;

        for(int i = 9; i >= 0; i--) {
            while(countX[i] > 0 && countY[i] > 0) {
                sb.append(i);
                countX[i]--;
                countY[i]--;
            }
        }

        if(sb.toString().equals("")) return "-1";
        if(sb.substring(0, 1).equals("0")) return "0";

        return sb.toString();
    }
}
