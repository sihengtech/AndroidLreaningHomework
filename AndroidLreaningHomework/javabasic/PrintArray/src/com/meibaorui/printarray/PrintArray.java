package com.meibaorui.printarray;
public class PrintArray {
    public static void main(String[] args) {
        boolean isFirst = true;
        int[] numArr = {7, 5, 8, 9, 2, 1, 3, 12, 15, 48, 79, 56, 2323, 121};
        System.out.print("array { ");
        for (int value : numArr) {
            String str = isFirst ? "" : ", ";
            System.out.print(str + value);
            isFirst = false;
        }
        System.out.println(" }");
    }
}
