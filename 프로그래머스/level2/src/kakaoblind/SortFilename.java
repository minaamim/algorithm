package kakaoblind;

import java.util.*;
import java.io.*;

public class SortFilename {

    private static class File {
        String name;
        String head;
        int number;
        String tail;

        public File(String name, String head, int number, String tail) {
            this.name = name;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }

    public static void main(String args[]) {
//        String[] files = {
//                "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"
//        };

        String[] files = {
                "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"
        };

        solution(files);
    }

    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];

        File[] fileInfo = new File[files.length];

        for(int i = 0; i < files.length; i++) {

            String file = files[i].toUpperCase();

            String[] split = splitName(file);

            File temp = new File(files[i], split[0], Integer.parseInt(split[1]), split[2]);
            fileInfo[i] = temp;
        }

        Arrays.sort(fileInfo, (o1, o2) -> {
            if((o1.head).equals(o2.head)) {
                return o1.number - o2.number;
            } else {
                return (o1.head).compareTo(o2.head);
            }
        });

        for(int i = 0; i < files.length; i++) {
            answer[i] = fileInfo[i].name;
            System.out.println(answer[i]);
        }

        return answer;
    }

    static String[] splitName(String name) {
        String[] str = new String[3];

        str[0] = "";
        str[1] = "";
        str[2] = "";

        int index = 0;

        for(int i = 0; i < name.length(); i++) {
            Character c = name.charAt(i);

            if (index == 0 && !Character.isDigit(c)) {
                str[0] += c.toString();
                continue;
            }

            if(index == 0 && Character.isDigit(c)) index++;

            if(index == 1 && Character.isDigit(c)) {
                str[1] += c.toString();
                continue;
            }

            if(index == 1 && !Character.isDigit(c)) {
                str[2] = name.substring(i);
                break;
            }
        }

        return str;
    }
}
