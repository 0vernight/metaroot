package com.basic.arithmatic;

import org.junit.Test;

/*
1.模拟一个trim方法,去除字符串两端的空格。
    判断是否空，string转为cahr数组类型，从前找空，前移覆盖空格，从后找空，创建char数组剪掉尾部的空格。
2．将一个字符串进行反转。将字符串中指定部分进行反转。比如"abcdefg"反转为"abfedcg"
3.获取一个字符串在另一个字符串中出现的次数。比如:获取“ab”在“abkkcadkabkebfkabkskab”中出现的次数
    s1.indexOf("ab");和s1.substring(index+2);的使用
*4.获取两个字符串中最大相同子串。比如:str1 = "abcwerthelloyuiodef";str2 = "cvhellobnm"提示:将短的那个串进行长度依次递减的子串与较长的串比较。
    也是借助s.substring(i,j)来解决。
*5.对字符串中字符进行自然顺序排序。提示:1）字符串变成字符数组。2）对数组排序，选择，冒泡，Arrays.sort();3）将排序后的数组变成字符串。
*/
public class StringMethod {
    public static void main(String[] args) {
        System.out.println("字符串的算法");
        String str = " ";
        String s1 = "   hello  oworld ";
        System.out.println("***"+s1.trim()+"***");
//        第一题最好的答案
        System.out.println("***"+ myTrim(s1) +"***");

        String ss="hello world";
        String reverse = reverse(ss, 2, 8);
        System.out.println(reverse);

        counting("ab",ss);

        String str1 = "abcwerthelloyuiod ef";
        String str2 = "cvhellobnm";


    }


    //转为char[]
    //第二题 有好几种方法最起码4个
    public static String reverse(String str,int sindex,int eindex){
        if (str != null) {
            char[] arr=str.toCharArray();
            for (int i = sindex,j=eindex; i <j ; i++,j--) {
                char tem=arr[i];
                arr[i]=arr[j];
                arr[j]=tem;
            }
            return new String(arr);
        }

        return null;
    }
    //通过线程不安全，但是效率搞得stringBuilder 来实线反转
    public String reverse1(String str,int sindex,int eindex){
        if (str!=null){
            StringBuilder builder=new StringBuilder(str.length());
            builder.append(str.substring(0,sindex));
            for (int i = eindex; sindex<=i ; i--) {
                builder.append(str.charAt(i));
            }
            builder.append(str.substring(eindex,str.length()+1));
            return builder.toString();
        }

        return null;
    }
    @Test
    public void trimMathod() {
        String s = "  hello world !  ";
        String s1 = s.trim();
        String s2 = "hello world !";

        int i = 0;
//        比较关键的步骤，string是不能改变的，所以借助能改变的char类型来
        char[] chars = s.toCharArray();
        for (; i < chars.length; i++) {
            if (chars[i] == ' ') {

            } else {
                break;
            }
        }
        for (int j = 0; j < s.length() - i; j++) {
            chars[j] = chars[j + i];
        }
        int c = chars.length;
        for (int j = s.length() - 1; j > 0; j--) {
            if (chars[j] == ' ') {
                c--;
            } else break;
        }
        char[] cs = new char[c];
        for (int j = 0; j < c; j++) {
            cs[j] = chars[j];
        }
        String des = new String(cs);
        System.out.println(des);


        System.out.println("|" + s1);
        System.out.println(des.equals(s1));
        System.out.println(des == s2);
    }
    //第四题
    public static String getMaxSameString(String str1,String str2){
        //用contains来做也可
        if (str1!= null&&str2!=null) {
            String maxS=str1.length()>=str2.length()?str1:str2;
            String minS=str1.length()<str2.length()?str1:str2;
            int len=minS.length();
            for (int i = 0; i < len; i++) {//小的有多少个，就循环多少遍
                for (int j = 0,k=len-i; k<=len; j++,k++) {//每一轮遍历中，从左j，到右k查看字串有无在其中。
                    String subs=minS.substring(j,k);
                    if (maxS.contains(subs)) {
                        return subs;
                    }
                }
            }
        }

        return null;
    }
    @Test
    public  void testGetMaxSameString(){
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";
        System.out.println(getMaxSameString(str1, str2));
    }

    //第一题高效率的
    public static String myTrim(String s) {
//        利用了substring相当高效率
        int start = 0, end = s.length() - 1;

        while (start <= end && s.charAt(start) == ' ') {
            start++;
        }

        while (start <= end && s.charAt(end) == ' ') {
            end--;
        }
        return s.substring(start, end + 1);
    }
//    第三题只知道两个api即可
    public static int counting(String source,String target){
        if (source.length()>=target.length()) {
            int index=0,count=0,sublen=target.length();
            //方式一；
//            while ((index=source.indexOf(target))!=-1){
//                source=source.substring(index+ target.length());
//                count++;
//            }
            //方式二：对方式一的改进
            while((index = source.indexOf(target,index)) != -1){//index是开始找的位置
                count++;
                index += sublen;
            }
//            System.out.println(count);
            return count;
        }
        return 0;

    }


}

class StringTest {
    /*
     * 第一題
     * 他的思路是每次检查第一个，是空那么整体前移再判断
     * 我的思路是检查前面总共有多少个空格整体往前移，
     * 结论：我的效率好一点
     * */

    public static void main(String[] args) {
        System.out.println("字符串的算法‘");
        String str = " ";
        String s1 = "   hello  oworld ";
        System.out.println("***" + s1.trim() + "***");
        System.out.println("***" + (new StringTest()).Trim(s1) + "***");
    }

    public String Trim(String str) {
        if (str != null) {//判断字符串是否为空值
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[0] == ' ') {//判断数组开头是否为空格
                    for (int j = 0; j < chars.length - 1; j++) {
                        chars[j] = chars[j + 1];//如果是空格，就将数组从后往前赋值，从而取代数组开头部分
                    }
                } else {
                    break;
                }
            }


            int charLength = chars.length;//新数组的长度
            for (int i = str.length() - 1; i >= 0; i--) {
                if (chars[i] == ' ') {
                    charLength--;//如果数组结尾是空格，就减少一次新数组的长度
                } else {
                    break;
                }
            }

            char[] lastChar = new char[charLength];
            for (int i = 0; i < lastChar.length; i++) {
                lastChar[i] = chars[i];//对新数组进行赋值操作
            }
            return String.valueOf(lastChar);//返回trim()后的字符串
        } else {
            System.out.println("不能为空字符串");
        }
        return null;
    }

}
