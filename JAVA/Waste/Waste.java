
package Waste;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public boolean Waste(int n) {
        int res = 0;
        int temp = 0;
        int op = 0;
        List<Integer> lst = new ArrayList<>();
        while(res < n){
            int it = 0;
            op = 0;
            temp = n - res;
            while(op <= temp){
                op = (int) Math.pow(3,it);
                System.out.print(op+" ");
                it++;
            }
            op /= 3;
            if(lst.contains(op)){
                return false;
            }
            lst.add(op);
            res += op;
            System.out.print("result :"+res);
        }
        return res == n ? true : false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        Solution s = new Solution();
        System.out.println(s.Waste(n));
        sc.close();
    }
}
