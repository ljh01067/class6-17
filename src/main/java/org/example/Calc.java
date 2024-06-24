package org.example;

public class Calc{
    public static int run(String exp){
        int i = 0;
        if(exp.indexOf("+") != -1){
            String[] bits = exp.split("\\+");
            int a = Integer.parseInt(bits[0]);
            int b = Integer.parseInt(bits[1]);
            i = a+b;
        }
        else if(exp.indexOf("-") != -1){
            String[] bits = exp.split("-");
            int a = Integer.parseInt(bits[0]);
            int b = Integer.parseInt(bits[1]);
            i = a-b;
        }
        return i;
    }
}