package prepare_ses9928;

import java.io.*;
import java.util.*;

public class Boj23971 {
    private static int H, W, N, M;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        N = sc.nextInt();
        M = sc.nextInt();

        int i = (W - 1)/ (M + 1) + 1;
        int j = (H - 1) / (N + 1) + 1;

        System.out.println(i * j);
    }
}
