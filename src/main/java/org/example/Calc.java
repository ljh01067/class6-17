package org.example;

import java.util.Arrays;

public class Calc {
    public static int run(String exp) {
        int i = 0;
        //수식에 곱하기가 있는경우
        if(exp.indexOf(" * ") != -1) {
            i = 1;
            //수식에 곱하기와 더하기가 있는 경우
            if (exp.indexOf(" + ") != -1) {
                int unum = 0;
                int dnum = 0;
                int f = 0;
                //+를 기준으로 나눈뒤 나눈것들 사이에서 *가 있는 것의 위치를 찾는다.
                String[] bits = exp.split(" \\+ ");
                for (int l = 0; l < bits.length; l++) {
                    if (bits[l].contains("*")) {
                        unum++;
                    }
                    for (l = 0; l < bits.length; l++) {
                        if (bits[l].contains("*") == false) {
                            dnum++;
                        }
                    }
                    int[] n = new int[unum];
                    int[] g = new int[dnum];
                    for (int k = 0; k < bits.length; k++) {
                        for (l = 0; l < unum; l++) {
                            if (bits[k].contains("*")) {
                                n[l] = k;
                            }
                        }
                        for (l = 0; l < dnum; l++) {
                            if (bits[k].contains("*") == false) {
                                g[l] = k;
                            }
                        }
                    }
                    //위치를 기반으로 *를 기준으로 나누고 곱한다.
                    int ssum = 0;
                    int[] sum = new int[unum];
                    for (int m = 0; m < unum; m++) {
                        i = 1;
                        String[] bits2 = bits[n[m]].split(" \\* ");
                        for (int j = 0; j < bits2.length; j++) {
                            i *= Integer.parseInt(bits2[j]);
                            sum[m] = i;
                        }
                            ssum += sum[m];
                    }
                    for (int m = 0; m < dnum; m++) {
                        f += Integer.parseInt(bits[g[m]]);
                    }
                    i = ssum + f;
                }
            }
            //수식에 곱하기만 있는경우
            else {
                String[] bits = exp.split(" \\* ");
                for (int j = 0; j < bits.length; j++) {
                    i *= Integer.parseInt(bits[j]);
                }
            }
        }
        else if(exp.indexOf(" - ") != -1) {
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
    }
}