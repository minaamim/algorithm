package kakaoblind;

import java.util.ArrayList;
import java.util.List;

public class TheSong {

    public static void main(String args[]) {
        String m1 = "ABCDEFG";
        String[] musicinfos1 = { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" };

        String m2 = "CC#BCC#BCC#BCC#B";
        String[] musicinfos2 = { "03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B" };

        String m3 = "ABC";
        String[] musicinfos3 = { "12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF" };

        String m4 = "ABCDEFG";
        String[] musicinfos4 = {"11:50,12:04,HELLO,CDEFGAB", "12:57,13:11,BYE,CDEFGAB"};

        String m5 = "A";
        String[] musicinfos5 ={"00:00,23:59,HELL,CA#", "00:00,23:59,HI,CA#"};

        System.out.println(solution(m1, musicinfos1));
        System.out.println(solution(m2, musicinfos2));
        System.out.println(solution(m3, musicinfos3));
        System.out.println(solution(m4, musicinfos4));
        System.out.println(solution(m5, musicinfos5));
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max = 0;

        for(int i = 0; i < musicinfos.length; i++) {
            String[] str = musicinfos[i].split(",");
            int time = calculatePlaytime(str[0], str[1]);
            String name = str[2];
            String sound = convert(str[3]);
            m = convert(m);

            while(sound.length() < time)
                sound += sound;

            sound = sound.substring(0, time);

            if(sound.contains(m) && max < time) {
                max = time;
                answer = name;
                System.out.println("max: " + name + " " + max);
            }
        }
        return answer;
    }

    static String convert(String str) {
        str = str.replaceAll("A#", "a");
        str = str.replaceAll("C#", "c");
        str = str.replaceAll("D#", "d");
        str = str.replaceAll("F#", "f");
        str = str.replaceAll("G#", "g");
        str = str.replaceAll("E#", "e");
        return str;
    }

    static int calculatePlaytime(String start, String end) {
        int time = 0;

        String[] startTime = start.split(":");
        String[] endTime = end.split(":");

        time = (Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1])) - (Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]));

        return time;
    }


}
