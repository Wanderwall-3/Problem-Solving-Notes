package JAVA.Waste;
import java.util.*;
public class Nto1Recurstion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        fuction(n);
        sc.close();
    }
    
    public static void fuction(int n){
        int count=n;
        if(count<1){
            return;
        }
        System.out.print(count);
        n--;
        fuction(n);
        

    }
}

