package Skillrack.Max_Coins_Bottom_Row_Cannot_Pick;                   //COMPLETED

import java.util.Arrays;

//REFERENCE --- https://www.youtube.com/watch?v=JMRDYzTB4iE https://www.youtube.com/watch?v=2vkj5ZcoykQ

import java.util.Scanner;

public class Solution {

    // Approch 1: Brute Force(USING DFS).
    // Approch 2: Using DP(Optimized).

    // static int ans = 0;
    // static int[][] main;

    // public static void dfs(int[][] arr, int i, int row, int col, int total,
    // int[][] main) {
    // if (i >= row) {
    // ans = Math.max(ans, total);
    // return;
    // }
    // for (int k = 0; k < col; k++) {
    // if (i > 0 && main[i - 1][k] != 1) {
    // main[i][k] = 1;
    // dfs(arr, i + 1, row, col, total + arr[i][k], main);
    // main[i][k] = 0;
    // } else if (i == 0) {
    // main[i][k] = 1;
    // dfs(arr, i + 1, row, col, total + arr[i][k], main);
    // main[i][k] = 0;

    // }
    // }

    // // main[i][j]=1;
    // // dfs(arr, i+1, j, row, col, total=arr[i][j]);

    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int firstmax=0,secondmax=0;
        for (int time = 0; time < n; time++) {
            int row = sc.nextInt();
            int col = sc.nextInt();

            int[][] arr = new int[row][col];

            for (int i = 0; i < row; i++)
                for (int j = 0; j < col; j++)
                    arr[i][j] = sc.nextInt();

            // ans = 0;
            // main = new int[row][col];
            // dfs(arr, 0, row, col, 0, main);
            // System.out.println(ans);

            // firstmax = 0;
            // secondmax = 0;
            int[][] dp = new int[row][col];

            dp[0] = Arrays.copyOf(arr[0], col);
            int[] prev = Arrays.copyOf(arr[0], col);
            Arrays.sort(prev);
            firstmax = prev[col - 1];
            secondmax = prev[col - 2];
            for (int i = 1; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (dp[i - 1][j] == firstmax) {
                        dp[i][j] = secondmax + arr[i][j];
                    } else {
                        dp[i][j] = firstmax + arr[i][j];
                    }
                }
                prev = Arrays.copyOf(dp[i], col);
                Arrays.sort(prev);
                firstmax = prev[col - 1];
                secondmax = prev[col - 2];
            }
        }
        sc.close();
        System.out.println(firstmax);
    }
}
// INPUT :
// 1
// 4 4
// 20 50 100 120
// 200 100 60 400
// 60 50 70 900
// 500 100 90 200

// 1
// 5 5
// 25 98 74 11 89
// 53 68 36 48 23
// 4 14 99 48 41
// 40 22 97 72 1
// 29 67 61 92 49