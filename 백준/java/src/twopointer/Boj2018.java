package twopointer;

import java.util.Scanner;

public class Boj2018 {

    public static void main(String[] args) {
        int start_index = 1, end_index = 1;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 1, count = 1;

        while (end_index != N) {
            if(sum == N) {
                count++;
                end_index++;
                sum += end_index;
            } else if(sum > N) {
                sum -= start_index;
                start_index++;
            } else {
                end_index++;
                sum += end_index;
            }
        }
        System.out.println(count);
    }
}
