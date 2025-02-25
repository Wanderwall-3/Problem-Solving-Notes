package GFG;

import java.util.Scanner;

public class Waste {
   public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int i=1,p=0;
    while (i*i<n) {
        p=i;
        i+=1;
    }
    int a=p*p;
    int b=i*i;
    int a1=n-a;
    int b1=b-n;
    if(a1<=b1) System.out.println(p);
    else System.out.println(i);
    sc.close();
   } 
}
