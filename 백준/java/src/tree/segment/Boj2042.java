package tree.segment;

import java.io.*;
import java.util.*;

public class Boj2042 {
    private static int N, M, K;
    private static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int height = 0;
        int len = N;
        while(len != 0) {
            len /= 2;
            height++;
        }

        int treeSize = (int) Math.pow(2, height + 1);
        int leafNodeStartIndex = (int) Math.pow(2, height);
        tree = new long[treeSize + 1];

        for(int i = leafNodeStartIndex; i < leafNodeStartIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);

        for(int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            switch (type) {
                case 1:
                    changeValue(leafNodeStartIndex + a - 1, b);
                    break;
                case 2:
                    getSum((int) (leafNodeStartIndex + a - 1), (int) (leafNodeStartIndex + b - 1));
                    break;
            }
        }
    }

    private static void changeValue(long index, long value) {
        long diff = value - tree[(int) index];
        while(index > 0) {
            tree[(int) index] += diff;
            index /= 2;
        }
    }

    private static void getSum(int start, int end) {
        long sum = 0;

        while(start <= end) {
            if(start % 2 == 1) {
                sum += tree[start];
                start++;
            }
            if(end % 2 == 0) {
                sum += tree[end];
                end--;
            }
            start /= 2;
            end /= 2;
        }
        System.out.println(sum);
    }


    private static void setTree(int node) {
        while(node != 1) {
            tree[node / 2] += tree[node];
            node--;
        }
    }
}
