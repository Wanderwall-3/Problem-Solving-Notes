package Skillrack.String_Permutation;

import java.util.HashSet;

//REFERECE --- https://www.youtube.com/watch?v=dmzPo0meGyQ https://www.youtube.com/watch?v=iSj7a1Qt6cc
//So simple if we use backtrack.



public class Solution {

    public static void back(String s, int n, HashSet<Character> set,String ans){
        if(set.size()==n){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<n;i++){
            if(set.contains(s.charAt(i))) continue;
            set.add(s.charAt(i));
            back(s,n,set,ans+s.charAt(i));
            set.remove(s.charAt(i));
        }
    }

    public static void main(String[] args) {
        String s = "like";
        String ans="";
        int n=s.length();
        HashSet<Character> set = new HashSet<>();
        back(s,n,set,ans);
    }
}
