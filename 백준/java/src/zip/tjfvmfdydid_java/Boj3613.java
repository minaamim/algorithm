package zip.tjfvmfdydid_java;

import java.util.*;
import java.io.*;

public class Boj3613 {

    private static int JAVA = 1;
    private static int CPP = 2;
    private static int ERROR = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int type = getType(target);
        if (type == ERROR) {
            System.out.println("Error!");
            return;
        }

        transform(type, target);
    }

    private static int getType(String target) {

        boolean containsUpperCase = false;
        for(int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            if(ch >= 'A' && ch <= 'Z') {
                containsUpperCase = true;
            }
        }

        if(target.startsWith("_") || target.endsWith("_") || target.charAt(0) <= 'Z' || target.contains("__")) {
            return ERROR;
        }
        if(!target.contains("_") && containsUpperCase) return JAVA;
        if(!containsUpperCase) return CPP;

        return ERROR;
    }

    private static void transform(int type, String target) {
        if(type == JAVA) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < target.length(); i++) {
                char ch = target.charAt(i);
                if(ch <= 'Z') {
                    ch += 32;
                    sb.append("_");
                    sb.append(ch);
                    continue;
                }
                sb.append(ch);
            }
            System.out.println(sb.toString());
        }

        if(type == CPP) {
            String[] toJava = target.split("_");
            for(int i = 1; i < toJava.length; i++) {
                char temp = toJava[i].charAt(0);
                temp -= 32;
                String t = temp + toJava[i].substring(1);
                toJava[i] = t;
            }
            System.out.println(String.join("", toJava));
        }
    }
}