package com.meibaorui;

public class OutputEvenNumber {
    public static void main(String[] args){
        /**
         * 方法一
         */
        for(int i=0;i<=100;i+=2){
            System.out.println(i);
        }

        /**
         * 方法二
         */
        for(int i=0;i<=100;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
}
