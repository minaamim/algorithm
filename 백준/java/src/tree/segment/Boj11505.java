package tree.segment;

import java.io.*;
import java.util.*;

public class Boj11505 {
    private static int N, M, K;
    private static long[] tree;
    private static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int len = N;
        int height = 0;
        while(len != 0) {
            len /= 2;
            height++;
        }

        int treeSize = (int) Math.pow(2, height + 1);
        int leafStartIdx = (int) Math.pow(2, height);

        tree = new long[treeSize];
        Arrays.fill(tree, 1);
        for(int i = leafStartIdx; i < leafStartIdx + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize - 1);

        for(int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            switch (a) {
                case 1:
                    updateVal(b + leafStartIdx - 1, c);
                    break;
                case 2:
                    getMul(b + leafStartIdx - 1, (int) (c + leafStartIdx - 1));
                    break;
            }
        }
    }

    private static void getMul(int s, int e) {
        long result = 1;
        while(s <= e) {
            if(s % 2 == 1) {
                result = result * tree[s] % MOD;
                s++;
            }
            if(e % 2 == 0) {
                result = result * tree[e] % MOD;
                e--;
            }
            s /= 2;
            e /= 2;
        }
        System.out.println(result);
    }

    private static void updateVal(int target, long value) {
        tree[target] = value;
        while(target > 1) {
            target /= 2;
            tree[target] = tree[target * 2] % MOD * tree[target * 2 + 1] % MOD;
        }
    }

    private static void setTree(int idx) {
        while(idx != 1) {
            tree[idx / 2] = tree[idx / 2] * tree[idx] % MOD;
            idx--;
        }
    }
}