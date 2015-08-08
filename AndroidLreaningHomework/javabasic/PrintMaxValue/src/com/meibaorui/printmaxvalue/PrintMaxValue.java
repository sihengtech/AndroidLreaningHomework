package com.meibaorui.printmaxvalue;


public class PrintMaxValue {

    public static void printMaxValueFromArray(int[] array) {
        System.out.println(getMaxValueFromArray(array));
    }

    public static int getMaxValueFromArray(int[] array) {
        int maxTemp = Integer.MIN_VALUE;
        for (int value : array) {
            maxTemp = Integer.max(value, maxTemp);//value > maxTemp ? value : maxTemp;
        }
        return maxTemp;
    }
}
