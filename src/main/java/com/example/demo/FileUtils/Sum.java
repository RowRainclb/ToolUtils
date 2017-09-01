package com.example.demo.FileUtils;

/**
 * for while 递归求和
 * Created by cuilb3 on 2017/8/29.
 */
public class Sum {
    public static int forSum(Integer[] a){
        int b = 0 ;
        for(int c = 0 ;c<a.length;c++) {
            b+=a[c];
        }
        return b;
    }
    public static int whileSum(Integer[] a) {
        int b = 0;
        int c = 0;
        while (c<a.length){
            b+=a[c];
            c++;
        }
        return b;
    }
    static int sum = 0;
    public static int sum(int index,Integer[] a){
        if(index >=a.length) {
            return sum;
        }
        sum+=a[index];
        return sum(++index,a);

    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{3,4,5,6,3,2};
//        System.out.println(forSum(a));
//        System.out.println(whileSum(a));
        System.out.println(sum(0,a));
    }

}
