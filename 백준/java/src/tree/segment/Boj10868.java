package tree.segment;

import java.io.*;
import java.util.*;

public class Boj10868 {

    private static int N, M;
    private static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int len = N;
        int height = 0;
        while(len != 0) {
            len /= 2;
            height++;
        }

        int treeSize = (int) Math.pow(2, height + 1);
        int leafStartIndex = (int) Math.pow(2, height);
        tree = new int[treeSize];
        Arrays.fill(tree, Integer.MAX_VALUE);

        for(int i = leafStartIndex; i < N + leafStartIndex; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }
        setTree(treeSize - 1);

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            getMin(leafStartIndex + a - 1, leafStartIndex + b - 1);
        }
    }

    private static void getMin(int s, int e) {
        int min = Integer.MAX_VALUE;
        while(s <= e) {
            if(s % 2 == 1) {
                min = Math.min(min, tree[s]);
                s++;
            }
            if(e % 2 == 0) {
                min = Math.min(min, tree[e]);
                e--;
            }
            s /= 2;
            e /= 2;
        }
        System.out.println(min);
    }

    private static void setTree(int idx) {
        while(idx != 1) {
            tree[idx / 2] = Math.min(tree[idx / 2], tree[idx]);
            idx--;
        }
    }
}