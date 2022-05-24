package com.basic.letcode;

public class DaySix {
    public static void main(String[] args) {
        CreateArray createArray=new CreateArray();
        createArray.m();

//        CharTest charTest=new CharTest();
//        charTest.mathod();
//
//        StringEqual stringEqual=new StringEqual();
//        stringEqual.m();
    }
}

class CreateArray{
    public void m(){
        int[][] arr=new int[][]{{1,2,3,4},{2,4,5,6},{}};
        System.out.println(arr[0][3]);
        String[][] arrstr=new String[4][];
    }
}

class StringEqual{
    public void m(){
        String st="124";
        String st1="124";
        String st2=new String("124");
        System.out.println(st==st1);
        System.out.println(st==st2);
    }
}

class CharTest{
    public void mathod(){
        char[] c=new char[4];
        int[] arrint=new int[3];

        if (c[0] == 0 &&arrint[0] ==0) {        //char 和 int 以及其他类型都是48的零
            System.out.println("--"+c[0]+"--");
        }
        else if (c[0] =='0'){
            System.out.println();
        }
    }
}