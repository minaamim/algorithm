package practice;

public class P87390 {

    public static void main(String[] args) {
        int[] arr = solution(3, 2, 5);
        for(int i : arr) System.out.print(i + " ");
    }

    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        int idx = 0;
        for(long i = left; i<= right; i++) {
            long row = i / n;
            long col = i % n;
            answer[idx++] = (int) (row <= col ? col + 1 : row + 1);
        }
        return answer;
    }
}
