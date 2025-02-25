package Leetcode.Leetcode1524;

//REFERENCE -- https://www.youtube.com/watch?v=AIlI-24oC6Q


class Solution {
    public int numOfSubarrays(int[] arr) {
        int cur=0;
        int even=0;
        int odd=0;
        int res=0;
        int mod=1000000007;
        for(int i=0;i<arr.length;i++){
            cur+=arr[i];
            if(cur%2==1){
                res=(res+1+even)%mod;
                odd+=1;
            }
            else{
                res+=odd;
                even+=1;
            }
        }
        return res%mod;
    }
    public static void main(String[] args) {
        int[] arr=new int[]{1,3,5};
        Solution solution = new Solution();
        System.out.println(solution.numOfSubarrays(arr));
    }
}