package com.example.demo.FileUtils;

/**
 * 斐波纳契数列
 * <p>
 * 斐波纳契数列，又称黄金分割数列，指的是这样一个数列：1、1、2、3、5、8、13、21、
 * ……在数学上，斐波纳契数列以如下被以递归的方法定义：F0=0，F1=1，Fn=F(n-1)+F(n-2)（n>=2，n∈N*）。
 * Created by cuilb3 on 2017/8/29.
 * </p>
 */
public class Fibonacci {

    //定义数组方法
    public static  void  fibnoci(){
        int arr[] = new int[20];
        arr[0] = arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println("斐波那契数列的前20项如下所示：");
        for (int i = 0; i < arr.length; i++) {
            if (i % 5 == 0) {
                System.out.println();
            }
            System.out.print(arr[i]+"\t");
        }
    }


    //使用递归方法
    private static int getFibo(int i) {
        if (i == 1 || i == 2)
            return 1;
        else
            return getFibo(i - 1) + getFibo(i - 2);
    }
    public static void main(String[] args) {
        fibnoci();
        for (int j = 1; j <= 20; j++) {
            System.out.print(getFibo(j) + "\t");
            if (j % 5 == 0)
                System.out.println();
        }
    }
}
