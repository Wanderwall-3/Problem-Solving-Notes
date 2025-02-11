package Minimum_Edit_Distance_Two_Strings;

import java.util.Scanner;

public class Minimum_Edit_Distance_Two_Strings {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        int m=s1.length();
        int n=s2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++) dp[i][0]=i;
        for(int i=0;i<=n;i++) dp[0][i]=i;
        dsdsdsd
    }
}


//INPUT :
// hello 
// hail

//OUTPUT :
//3