package class2;

import java.util.*;
import java.io.*;

public class Boj15829 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long total = 0;
        int r = 31, M = 1234567891;

        for(int i = 0; i < L; i++) {
            int num = str.charAt(i) - 'a' + 1;
            total += num * Math.pow(r, i);
            total = total % M;
        }
        System.out.println(total);
    }
}
