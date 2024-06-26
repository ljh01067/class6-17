package org.ts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String exp = "(((20 + 20))) + 20";
        int i = 0;

        while (exp.indexOf(")") != -1) {
            Pattern pattern = Pattern.compile("[(](.*?)[)]");
            Matcher matcher = pattern.matcher(exp);
            연산 연산1 = new 연산();
            String ex = "";
            while (matcher.find()) {
                if(matcher.group(1).indexOf("(") != -1){
                    exp = exp.replace("(" + matcher.group(1) + ")",matcher.group(1));
                    if(exp.length() - exp.replace(String.valueOf(")"), "").length()>=2){
                        break;
                    }
                    Pattern pattern1 = Pattern.compile("[(](.*?)[)]");
                    Matcher matcher1 = pattern1.matcher(exp);
                    while (matcher1.find()) {
                        exp = exp.replace("(" + matcher1.group(1) + ")",matcher1.group(1));
                        연산 연산2 = new 연산();
                        i = 연산2.사칙연산(exp);
                        break;
                    }
                    break;
                }
                ex = 연산1.사칙연산(matcher.group(1)) + "";
                exp = exp.replace("(" + matcher.group(1) + ")", ex);
                if(exp.indexOf(")") != -1){
                    continue;
                }
                연산 연산2 = new 연산();
                i = 연산2.사칙연산(exp);
                if (matcher.group(1) == null)
                    break;
            }
            if(exp.length() - exp.replace(String.valueOf(")"), "").length()>=2){
                continue;
            }
        }
        if(exp.indexOf(")") == -1){
            연산 연산1 = new 연산();
            i = 연산1.사칙연산(exp);
        }
        System.out.println(i);
    }
}

class 연산 {
    public int 사칙연산(String exp) {
        //수식에 곱하기가 있는경우
        int i = 0;
        if (exp.indexOf(" * ") != -1) {
            i = 1;
            //수식에 곱하기와 더하기가 있는 경우
            if (exp.indexOf(" + ") != -1) {
                int unum = 0;
                int dnum;
                int f = 0;
                //+를 기준으로 나눈뒤 나눈것들 사이에서 *가 있는 것의 위치를 찾는다.
                String[] bits = exp.split(" \\+ ");
                for (int l = 0; l < bits.length; l++) {
                    if (bits[l].indexOf("*") != -1) {
                        unum++;
                    }
                }
                dnum = bits.length - unum;

                int[] n = new int[unum];
                int[] g = new int[dnum];
                for (int l = 0; l < bits.length; l++) {
                    for (int k = 0; k < unum; k++) {
                        if (bits[l].indexOf("*") != -1) {
                            n[k] = l;
                            break;
                        }
                    }
                }
                for (int l = 0; l < bits.length; l++) {
                    for (int k = 0; k < dnum; k++) {
                        if (bits[l].indexOf("*") == -1) {
                            g[k] = l;
                            break;
                        }
                    }
                }
                //위치를 기반으로 *를 기준으로 나누고 곱한다.
                int ssum = 0;
                int[] sum = new int[unum];
                for (int m = 0; m < unum; m++) {
                    String[] bits2 = bits[n[m]].split(" \\* ");
                    i = 1;
                    for (int l = 0; l < bits2.length; l++) {
                        i = i * Integer.parseInt(bits2[l]);
                    }
                    ssum = ssum + i;
                }
                for (int m = 0; m < dnum; m++) {
                    f += Integer.parseInt(bits[g[m]]);
                }
                i = ssum + f;
            }
            else {
                String[] bits = exp.split(" \\* ");
                for (int j = 0; j < bits.length; j++) {
                    i *= Integer.parseInt(bits[j]);
                }

            }
        }
        else if(exp.indexOf("-") != -1) {
            exp = exp.replace(" - ", " + -");
            String[] bits = exp.split(" \\+ ");
            for (int j = 0; j < bits.length; j++) {
                i += Integer.parseInt(bits[j]);
            }
        }
        else if(exp.indexOf(" + ") != -1) {
            String[] bits = exp.split(" \\+ ");
            for (int j = 0; j < bits.length; j++) {
                i += Integer.parseInt(bits[j]);

            }
        }
        return i;
    }}

