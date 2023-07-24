package bruteforce;

import java.io.*;
import java.util.*;

public class Boj19532 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[6];
        int idx = 0;
        while(st.hasMoreTokens()) arr[idx++] = Integer.parseInt(st.nextToken());

        solution(arr);

    }

    private static void solution(int[] arr) {

        int a, b, c, d, e, f;
        int x, y;

        a = arr[0]; b = arr[1]; c = arr[2]; d = arr[3]; e = arr[4]; f = arr[5];

        y = (d * c - a * f) / (d * b - a * e);
        x = (c * e - b * f) / (a * e - b * d);
        System.out.println(x + " " + y);
    }
}