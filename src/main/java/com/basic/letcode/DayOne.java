package com.basic.letcode;

public class DayOne {
    public static void main(String[] args) {

        short s=23;
        s += 2;
        logicSymbol();

    }
    public static void logicSymbol(){
        int z=40;
        boolean x=true;
        boolean y=false;

//        z++=40时先判断后加加故左true就可运行右边的赋值语句，&逻辑与而&&是短路与后者左边false时不会运行右边的语句
//        符号的左边和右边的位置表示的是是否在等号之前运行还是等号之后运行
        if ((z++==40)&&(y=true)){
            z++;
        }
        if ((x=false)||(++z==43)){
            z++;
        }
        System.out.println("z="+z);
    }
}
