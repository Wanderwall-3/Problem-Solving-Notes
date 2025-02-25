package Skillrack.Subset_Count_Combination;

//REFERENCE --- https://www.youtube.com/watch?v=HARX1OyVqdg  https://www.youtube.com/watch?v=idDVJ1CWvSo


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int n=4;
        int[] arr = {2,7,5,4};
        Arrays.sort(arr);
        int sum = Arrays.stream(arr).sum();
        int[][] dp=new int[n+1][sum+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                // if(i==0){
                //     dp[i][j]=0;
                // }
                // else if(j==0){
                //     dp[i][j]=0;
                // }
                // else{
                System.out.println(j+" "+-arr[i-1]);
                    if(arr[i-1]==j) dp[i][j]=1;
                    else if(dp[i-1][j]==1 || (arr[i-1]<=j && dp[i-1][(j-arr[i-1])]==1)) dp[i][j]=1;
                // }
            }
            // for(int k=0;k<n+1;k++) System.out.print(Arrays.toString(dp[k])+"\n");
        }
        int ans=0;
        for(int j=0;j<sum+1;j+=2) if(dp[n][j]==1) ans++;
        System.out.println(ans);
    }
}
