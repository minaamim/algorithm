package sort;

import java.io.*;
import java.util.*;

public class Boj1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();
        Integer[] arr = new Integer[num.length()];

        for(int i = 0; i < num.length(); i++) {
            arr[i] = num.charAt(i) - '0';
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i : arr) {
            System.out.print(i);
        }
    }
}
