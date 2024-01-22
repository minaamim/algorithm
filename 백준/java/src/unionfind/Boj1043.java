package unionfind;

import java.io.*;
import java.util.*;

public class Boj1043 {

    private static int[] parent;
    private static int[] truth;
    private static ArrayList<Integer>[] party;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        truth = new int[num];
        party = new ArrayList[M];

        for(int i = 0; i < party.length; i++) {
            party[i] = new ArrayList<>();
        }

        for(int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < num; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for(int j = 0; j < size; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 0; i < party.length; i++) {
            int first = party[i].get(0);
            for(int j = 1; j < party[i].size(); j++) {
                union(first, party[i].get(j));
            }
        }

        for(int i = 0; i < party.length; i++) {
            boolean isPossible = true;
            for(int j = 0; j < truth.length; j++) {
                if(find(truth[j]) == find(party[i].get(0))) {
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) ans++;
        }

        System.out.println(ans);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[b] = a;
        }
    }

    private static int find(int node) {
        if(parent[node] == node) return node;
        return find(parent[node]);
    }
}
