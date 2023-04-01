package kakaoblind;

public class PrimeNumber {

    public static void main(String args[]) {
        int n = 110011;
        int k = 10;
        System.out.println(solution(n, k));
    }

    public static int solution(int n, int k) {
        int answer = 0;


        //k진수로 변환
        String num = Integer.toString(n, k);

        String[] arr = num.split("0");

        for(String str : arr) {
            if(str.equals(""))
                continue;

            long prime = Long.parseLong(str);

            if(isPrime(prime))
                answer++;
        }

        return answer;
    }

    private static boolean isPrime(long prime) {

        if(prime == 0 || prime == 1)
            return false;

        for(int i = 2; i <= Math.sqrt(prime); i++) {
            if(prime % i == 0)
                return false;
        }
        return true;
    }

}
