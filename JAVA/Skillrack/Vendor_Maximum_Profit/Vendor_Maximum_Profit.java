package Vendor_Maximum_Profit;

//REFERENCE ----https://www.youtube.com/watch?v=kpoXaH_ZRbc https://www.youtube.com/watch?v=_JGgKyUnQWA

import java.util.Scanner;

public class Vendor_Maximum_Profit {
    public static void main(String[] args) {
        int ans=0;
        Scanner sc=new Scanner(System.in);
        int mon=sc.nextInt();
        int intCount=sc.nextInt();
        int[][] intArr=new int[intCount+1][3];
        for(int i=1;i<intCount+1;i++){
            intArr[i][1]=sc.nextInt();
            intArr[i][2]=sc.nextInt();
        }
        sc.close();
        int[][] dp=new int[intCount+1][mon+1];
        for(int i=1;i<=intCount;i++){
            for(int j=1;j<=mon;j++){
                if(intArr[i][1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    // System.out.println(intArr[i][1]+" "+j);
                    int cal=intArr[i][2]+dp[i-1][j-intArr[i][1]];
                    dp[i][j]=Math.max(cal,dp[i-1][j]);
                }
                // for(int k=0;k<intCount+1;k++) System.out.println(Arrays.toString(dp[i]));
                // System.out.println();
                ans=Math.max(ans,dp[i][j]);
            }
        }
        System.out.println(ans);
    }
}

//INPUT :

// 10 6
// 5 2
// 6 4
// 3 2
// 4 3
// 1 2
// 15 20