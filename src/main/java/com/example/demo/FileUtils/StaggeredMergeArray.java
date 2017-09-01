package com.example.demo.FileUtils;

import java.util.Arrays;

/**
 * 交错合并列表元
 * 编写一个交错合并列表元素的函数。例如：给定的两个列表为[a，B，C]和[1，2，3]，函数返回[a，1，B，2，C，3]。
 * Created by cuilb3 on 2017/8/29.
 */
public class StaggeredMergeArray {
    public static String[] getStaggeredMergeArray(String[] a,String[] b){
        String[] finalArray = new String[a.length+b.length];
        int sameLength = a.length>b.length?b.length:a.length;
        for(int j =0;j<2*sameLength;j++){
            if(j%2==0) finalArray[j]=a[j/2];
            else finalArray[j]=b[(j-1)/2];
        }
        if(a.length==sameLength){
            for(int j = 2*sameLength;j<finalArray.length;j++){
                if(j%2==0) finalArray[j]=b[j/2];
                else finalArray[j]=b[(j-1)/2];
            }
        }else if(b.length==sameLength){
            for(int j = 2*sameLength;j<finalArray.length;j++){
                if(j%2==0) finalArray[j]=a[j/2];
                else finalArray[j]=a[(j-1)/2];
            }
        }
        return finalArray;

    }

    public static void main(String[] args) {
        String[] a = new String[]{"a","b","c"};
        String[] b = new String[]{"1","2","3","4"};
        String[] finalArray = getStaggeredMergeArray(a,b);
        System.out.println(Arrays.toString(finalArray));

        String[] aa = new String[]{"a","b","c","d"};
        String[] bb = new String[]{"1","2","3"};
        String[] finalArray1 = getStaggeredMergeArray(aa,bb);
        System.out.println(Arrays.toString(finalArray1));
    }
}
