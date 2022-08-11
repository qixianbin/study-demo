package com.spring.study.algorithm;

/**
 * @description Z形打印
 * @author Qi
 * @date 2022/8/2 7:19
 */
public class ZString {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String res = convert(s,3);
        System.out.println(res);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1 || numRows > s.length()){
            return s;
        }

        int length = s.length();
        int t = numRows + numRows - 2;
        int x = 0;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++){
            sbs[i] = new StringBuilder();
        }
        for (int i = 0;i < length; i++){
            //此处必须先对位置进行赋值，再进行位置的变换
            sbs[x] = sbs[x].append(s.charAt(i));
            //当前位置 i mod t 如果小于最大行的行号，行号就继续加，否则行号开始减小
            if (i % t < numRows - 1){
                x++;
            }else {
                x--;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; i++){
            ans.append(sbs[i]);
        }
        return ans.toString();
    }
}
