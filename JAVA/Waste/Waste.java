package Waste;

import java.util.Arrays;

public class Waste {
    public static void main(String[] args) {
        int[] a={1,2,3,6,4,3};
        int left=0,right=a.length-1;
        while(left<right){
            int tem=a[left];
            a[left]=a[right];
            a[right]=tem;
            right--;
            left++;
        }
        System.out.println(Arrays.toString(a));

    }
}
