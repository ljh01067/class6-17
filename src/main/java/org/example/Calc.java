package org.example;

public class Calc {
    public static int run(String exp) {
        int i = 0;
        exp = exp.replace("-", "+-");
        String[] bits = exp.split("\\+");
        for (int j = 0; j < bits.length; j++) {
            i += Integer.parseInt(bits[j]);
        }
        return i;
    }
}