public class Weapon {
    public int solution(int number, int limit, int power) {
        /**
         * number = 기사단원의 수
         * limit = 공격력 제한수치
         * power = 초과했을 시 사용할 무기의 공격력
         * answer = 무기를 만들기 위해 필요한 철의 무게
         */

        int answer = 0;

        for(int i = 1; i <= number; i++) {
            int count = 0;

            //약수 구하기
            for(int j = 1; j * j <= i; j++) {
                if(j * j == i)
                    count++;
                else if (i % j == 0)
                    count += 2;
            }

            answer += count > limit ? power : count;

        }
        return answer;
    }
}
