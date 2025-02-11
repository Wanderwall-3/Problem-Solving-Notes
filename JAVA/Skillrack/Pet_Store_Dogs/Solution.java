package Pet_Store_Dogs;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

//REFERENCE --- https://www.youtube.com/watch?v=CMu0yUCqgAs https://www.youtube.com/watch?v=8TcNk0E2VN4
//APPROACH --- Math <Set base condition> and <take current element multiply with current position-2 element and add with current position-1 element>

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.close();
        BigInteger ways[] =new BigInteger[n+1];
        for(int i=1;i<=n;i++){
            if(i<=2) ways[i]=new BigInteger(i+"");
            else{
                BigInteger passive=new BigInteger((i-1)+"").multiply(ways[i-2]);
                ways[i]=passive.add(ways[i-1]);
            }
        }
        System.out.println(Arrays.toString(ways));
        System.out.println(ways[n].toString());
    }
}
