package practiceproblem;

public class Babillage2 {

    public static void main(String args[]) {
    }

    public int solution(String[] babbling) {

        String[] babList = {"aya", "ye", "woo", "ma"};
        String[] repeatedList = {"ayaaya", "yeye", "woowoo", "mama"};

        int answer = 0;

        for(String bab : babbling) {

            for(String rStr : repeatedList) {
                bab = bab.replace(rStr, "X");
                System.out.println("replacedBab: " + bab);
            }

            for(String str : babList) {
                bab = bab.replace(str, " ");
                System.out.println("result: " + bab);
            }

            bab = bab.replace(" ", "");

            if(bab == "")
                answer++;
        }

        return answer;
    }

}
