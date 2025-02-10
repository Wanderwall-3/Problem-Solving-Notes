package Wildcard_Pattern_Matching;           //COMPLETE

//REFERENCE: https://www.youtube.com/watch?v=g7KXWiiOtbA  https://www.youtube.com/watch?v=BotnSue5_eA

import java.util.Scanner;

public class Wildcard_Pattern_Matching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String pat = sc.next();
        sc.close();
        int len = str.length() + 1;
        int lenP = pat.length() + 1;
        int[][] dp = new int[len][lenP];
        dp[0][0] = 1;

        for(int i=1;i<lenP;i++){
            if(pat.charAt(i-1)=='*') dp[0][i] = dp[0][i-1];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < lenP; j++) {
                if(pat.charAt(j-1)=='*' && (dp[i-1][j]==1 || dp[i][j-1]==1)) dp[i][j] = 1;
                else if(pat.charAt(j-1)=='?' || pat.charAt(j-1)==str.charAt(i-1)) dp[i][j] = dp[i-1][j-1];
            }
        }
        if(dp[len-1][lenP-1]==1) System.out.println("YES");
        else System.out.println("NO");
    }
}
// abbbbbbbbccbhd
// a*b??b?d♦

// abbbbbbbbccbhd 
// *c?b??