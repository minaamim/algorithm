package practice;

public class P135807 {

    public static void main(String[] args) {

        int[] a1 = {10, 17};
        int[] b1 = {5, 20};

        int[] a2 = {10, 20};
        int[] b2 = {5, 17};

        int[] a3 = {14, 35, 119};
        int[] b3 = {18, 30, 102};

        System.out.println(solution(a1, b1));
        System.out.println(solution(a2, b2));
        System.out.println(solution(a3, b3));
    }

    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int num1 = gcd(arrayA);
        int num2 = gcd(arrayB);

        if(notDivisible(arrayB, num1))
            if(answer < num1) answer = num1;
        if(notDivisible(arrayA, num2))
            if(answer < num2) answer = num2;

        return answer;
    }

    public static int gcd(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static boolean notDivisible(int[] arr, int num) {
        for(int n : arr) {
            if(n % num == 0) return false;
        }
        return true;
    }

}
