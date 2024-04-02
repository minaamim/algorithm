package zip.ses9928;

import java.io.*;
import java.util.*;

public class Boj5073 {

    private static String Equilateral = "Equilateral";
    private static String Scalene = "Scalene";
    private static String Isosceles = "Isosceles";
    private static String fail = "Invalid";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] len = new int[3];
            boolean zero = true;
            for(int i = 0; i < 3; i++) {
                len[i] = Integer.parseInt(st.nextToken());
                if(len[i] != 0) zero = false;
            }
            if(zero) break;
            Arrays.sort(len);

            if (len[0] == len[1] && len[1] == len[2]) {
                System.out.println(Equilateral);
                continue;
            }
            if (len[0] + len[1] <= len[2]) {
                System.out.println(fail);
                continue;
            }
            if (len[0] == len[1] || len[1] == len[2] || len[0] == len[2]) {
                System.out.println(Isosceles);
                continue;
            }
            System.out.println(Scalene);
        }
    }
}
