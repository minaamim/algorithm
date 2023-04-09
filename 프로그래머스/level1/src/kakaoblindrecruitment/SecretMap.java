package kakaoblindrecruitment;

/**
 * 2018 kakao blind recruitment
 */

public class SecretMap {

    public static void main(String args[]) {
//        int n = 5;
//        int[] arr1 = {9, 20, 28, 18, 11};
//        int[] arr2 = {30, 1, 21, 17, 28};


        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};

        solution(n, arr1, arr2);
    }

    static boolean[][] map;

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        map = new boolean[n][n];

        check(arr1, n);
        check(arr2, n);

        for(int i = 0; i < map.length; i++) {
            answer[i] = "";
            for(int j = 0; j < map.length; j++) {
                if(!map[i][j]) {
                    answer[i] += " ";
                } else{
                    answer[i] += "#";
                }
            }

            System.out.println("answer" + i + ": " + answer[i]);
        }



        return answer;
    }

    static void check(int[] arr, int n) {
        for(int i = 0; i < arr.length; i++) {
            String binary = Integer.toBinaryString(arr[i]);

            while(binary.length() < n) {
                binary = "0" + binary;
            }
            for(int j = 0; j < binary.length(); j++) {
                if(binary.charAt(j) == '1')
                    map[i][j] = true;
            }
        }
    }

}
