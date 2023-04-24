package summerwintercoding;

public class MakePrimeNum {

    public static void main(String args[]) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 7, 6, 4};

        System.out.println(solution(nums1));
        System.out.println(solution(nums2));
    }

    public static int solution(int[] nums) {
        int answer = 0;

       for(int i = 0; i < nums.length - 2; i++) {
           for(int j = i+1; j < nums.length - 1; j++) {
               for(int k = j+1; k < nums.length; k++) {
                   if(isPrime(nums[i] + nums[j] + nums[k]))
                       answer++;
               }
           }
       }
        return answer;
    }

    static boolean isPrime(int num) {

        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }

        return true;
    }

}
