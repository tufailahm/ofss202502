package com.training.hr;

public class VariableDemo {

    public int add(int...num){
        int result=0;
        for(int i:num){
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        VariableDemo d = new VariableDemo();
        System.out.println( d.add(12,88,88));
    }
}
