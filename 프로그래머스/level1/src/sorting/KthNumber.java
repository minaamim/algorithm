package sorting;

import java.util.Arrays;

public class KthNumber {

    public static void main(String args[] ) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };
        solution(array, commands);
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int i, j, k;

        for(int count = 0; count < commands.length; count++) {
            i = commands[count][0];
            j = commands[count][1];
            k = commands[count][2];

            int arr[] = new int[j - i + 1];

            for(int index = 0; index < arr.length; index++) {
                arr[index] = array[i - 1];
                i++;
            }

            Arrays.sort(arr);

            answer[count] = arr[k - 1];
        }

        return answer;
    }

}
