package d2;

import java.util.Scanner;

public class Game369 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int cnt = 0;
            StringBuffer sb = new StringBuffer();
            sb.append(test_case);

            for(int i = 0; i < sb.length(); i++) {
                char ch = sb.charAt(i);
                if(ch == '3' || ch == '6' || ch == '9') cnt ++;
            }

            if(cnt > 0) {
                for(int i = 0; i < cnt; i++) System.out.print("-");
                System.out.print(" ");
            } else {
                System.out.print(test_case + " ");
            }
        }

    }
}
