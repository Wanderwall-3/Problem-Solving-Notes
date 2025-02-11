package Minimum_Edit_Distance_Two_Strings;          //COMPLETED

//REFERENCE --- https://www.youtube.com/watch?v=lizkwM1gmw4
import java.util.Scanner;

public class Minimum_Edit_Distance_Two_Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int m = s1.length();
        int n = s2.length();
        sc.close();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            dp[i][0] = i;
        for (int i = 0; i <= n; i++)
            dp[0][i] = i;

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;

        System.out.println(dp[m][n]);

    }
}

// INPUT :
// hello
// hail

// OUTPUT :
// 3