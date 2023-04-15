package kakaoblindrecruitment;

/**
 * 2018  kakao blind recruitment [1차]
 */

public class DartsGame {

    public static void main(String args[]) {
        System.out.println(solution("1S2D*3T"));
        System.out.println(solution("1D2S#10S"));
        System.out.println(solution("1D2S0T"));
        System.out.println(solution("1S*2T*3S"));
        System.out.println(solution("1D#2S*3S"));
        System.out.println(solution("1T2D3D#"));
        System.out.println(solution("1D2S3T*"));
    }

    public static int solution(String dartResult) {
        int answer = 0;

        int[] score = new int[3];
        int idx = 0;

        for(int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);

            if(ch - '0' >= 0 && ch - '0' <= 10) {
                int temp = ch - '0';
                int next = dartResult.charAt(i+1) - '0';

                score[idx] = temp;

                if(next == 0) {
                    score[idx] = 10;
                    i++;
                }
            }
            else if(ch == 'S' || ch == 'D' || ch == 'T') {
                if(ch == 'D')
                    score[idx] = (int) Math.pow(score[idx], 2);
                else if(ch == 'T')
                    score[idx] = (int) Math.pow(score[idx], 3);

                idx++;
            }
            else {
                if(ch == '*') {
                    if(idx == 1)
                        score[idx-1] *= 2;
                    else {
                        score[idx-1] *= 2;
                        score[idx-2] *= 2;
                    }
                }
                else if(ch == '#') {
                    score[idx-1] *= -1;
                }
            }

        }

        for(int i : score)
            answer += i;

        return answer;
    }
}
