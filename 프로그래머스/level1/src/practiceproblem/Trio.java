package practiceproblem;

public class Trio {

    public int solution(int[] number) {
        /**
         * number = 학생들의 번호를 나타내는 정수 배열
         * answer = 삼총사를 만들 수 있는 방법의 수
         */

        int answer = 0;

        for(int first = 0; first < number.length - 2; first++) {
            for(int second = first + 1; second < number.length - 1; second++) {
                for(int third = second + 1; third < number.length; third++) {
                    if(number[first] + number[second] + number[third] == 0) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

}
