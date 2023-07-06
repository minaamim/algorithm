package twopointer;

public class SumOfSequence {
    public static void main(String args[]) {
        int[] sequence1 = {1, 2, 3, 4, 5};
        int[] sequence2 = {1, 1, 1, 2, 3, 4, 5};
        int[] sequence3 = {2, 2, 2, 2, 2};

        solution(sequence1, 7);
        solution(sequence2, 5);
        solution(sequence3, 6);
    }

    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int minRange = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = 0;

        while (true) {

           if(sum >= k) sum -= sequence[left++];
           else if(right >= sequence.length) break;
           else sum += sequence[right++];

           if(sum == k) {
               if(minRange > right - left) {
                   minRange = right - left;
                   answer[0] = left;
                   answer[1] = right - 1;
               }
           }
        }
        return answer;
    }
}
