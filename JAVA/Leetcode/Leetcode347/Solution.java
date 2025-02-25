package Leetcode.Leetcode347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> fre=new HashMap<>();

        for(int i:nums) fre.put(i,fre.getOrDefault(i,0)+1);
        
        List<Map.Entry<Integer,Integer>> ans=new ArrayList<>(fre.entrySet());
        ans.sort((a,b) -> b.getValue()-a.getValue());

        int[] freK=new int[k];
        for(int i=0;i<k;i++){
            freK[i]=ans.get(i).getKey();
        }
        return freK;

    }

    public static void main(String[] args) {
        System.out.println("Leetcode347");
        //INPUT:
        int[] nums={1,1,1,2,2,3};
        int k=2;
        //OUTPUT: [1,2]
        Solution solution=new Solution();
        int[] ans=solution.topKFrequent(nums, k);
        for(int i:ans) System.out.print(i+" ");
    }
    
}