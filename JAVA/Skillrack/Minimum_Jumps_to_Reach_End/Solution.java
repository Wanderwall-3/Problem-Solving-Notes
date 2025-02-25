package Skillrack.Minimum_Jumps_to_Reach_End;

//REFERENCE: https://www.youtube.com/watch?v=JUH4Ayb373g https://www.youtube.com/watch?v=Yhxzu9S75Bw

public class Solution {
    public static void main(String[] args) {
        int[] arr=new int[]{1,3,5,3,3,1,1,1,1,1,1,1,1,4};
        if(arr.length==1){
            System.out.println(0);
            return;
        }
        int jum=1;
        int max=arr[0];
        int steps=arr[0];
        for(int i=1;i<arr.length;i++){
            if(i==arr.length-1) break;
            if(arr[i]+i>max){
                max=arr[i]+i;
                // if(steps==0) steps=max-i;
                // System.out.println(max);
            }
            steps--;
            if(steps==0){
                jum++;
                steps=max-i;
            }

        }
        System.out.println(jum);
    }
}


//input: arr = [2,3,1,1,4]
//output: 2

//input: arr = [1,3,5,3,3,1,1,1,1,1,1,1,1,4]
//output: 4