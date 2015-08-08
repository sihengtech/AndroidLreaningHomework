package com.meibaorui.multiplicationtable;

public class MultiplicationTable {
    public static void main(String[] args) {
        PrintSimplifiedMultiplicationTable();
        PrintResimplifiedMultiplicationTable();
        PrintCompleteMultiplicationTable();
    }

    /**
     * 输出完整乘法表
     */
    private static void PrintCompleteMultiplicationTable() {
        System.out.println("完整乘法表：");
        for(int i=1;i<10;i++){
            for(int j=1;j<10;j++){
                System.out.print(MultiplicationResult(i,j));
            }
            System.out.println();
        }
    }

    /**
     * 输出精简乘法表
     */
    private static void PrintSimplifiedMultiplicationTable() {
        System.out.println("精简乘法表：");
        for(int i=1;i<10;i++){
            for(int j=1;j<=i;j++){
                System.out.print(MultiplicationResult(i,j));
            }
            System.out.println();
        }
    }

    /**
     * 输出反转精简乘法表
     */
    private static void PrintResimplifiedMultiplicationTable() {
        System.out.println("反转精简乘法表：");
        for(int i=9;i>0;i--){
            for(int j=1;j<=i;j++){
                System.out.print(MultiplicationResult(j,i));
            }
            System.out.println();
        }
    }

    /**
     * 返回乘法算式字符串
     * @param multiplicand 被乘数
     * @param multiplier 乘数
     * @return 乘法算式字符串
     */
    private static String MultiplicationResult(int multiplicand,int multiplier){
        String blankStr=multiplicand*multiplier>9?"":" ";
        return ("  "+multiplicand+"X"+multiplier+"="+multiplicand*multiplier+blankStr);
    }
}
