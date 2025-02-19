package Single_Source_Shortest_Path;

//REFERENCE --- https://www.youtube.com/watch?v=5YHc2sR8S4o  https://www.youtube.com/watch?v=L9hTD6Ck7Y4

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][3];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < 3; j++)
                arr[i][j] = sc.nextInt();
        sc.close();
        HashMap<Integer,Integer> hash=new HashMap<>();
        hash.put(1,0);
        int[] ans=new int[n+1];
        ans[1]=0;
        int i=0;
        while(i<n-1){
            for(int j=0;j<arr.length;j++){
                int[] temp=arr[j];
                int a=temp[0],b=temp[1],c=temp[2];
                if(hash.getOrDefault(a,-1)!=-1){
                    int d=hash.get(a)+c;
                    if(hash.getOrDefault(b,-1)==-1){
                        hash.put(b,d);
                        ans[b]=d;
                    }
                    else{
                        hash.put(b,Math.min(hash.get(b),d));
                        ans[b]=Math.min(ans[b],d);
                    }
                }
            }
            i++;
        }
        System.out.println(Arrays.toString(ans));
        System.out.println(hash);
    }
}

// INPUT 1:
// 6 7
// 1 2 20
// 1 6 5
// 6 5 2
// 5 4 3
// 4 3 2
// 5 2 10
// 3 2 2

// OUTPUT :
// 14 12 10 7 5

// INPUT :
// 5 7
// 1 2 10
// 2 3 50
// 3 5 10
// 4 5 60
// 1 5 100
// 1 4 30
// 4 3 20

// OUTPUT :
// 10 50 30 60
